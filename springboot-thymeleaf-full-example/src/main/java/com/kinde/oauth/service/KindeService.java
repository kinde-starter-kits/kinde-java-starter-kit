package com.kinde.oauth.service;

import com.kinde.authorization.AuthorizationUrl;
import com.kinde.oauth.model.KindeProfile;
import com.kinde.user.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Service class to handle interactions with the Kinde OAuth2 authorization service
 * and retrieve user information.
 */
@Service
@Slf4j
public class KindeService {

    private final KindeClientService kindeClientService;

    /**
     * Constructor to initialize the KindeService.
     *
     * @param kindeClientService the service for managing Kinde OAuth2 clients.
     */
    public KindeService(KindeClientService kindeClientService) {
        this.kindeClientService = kindeClientService;
    }

    /**
     * Loads the user dashboard by fetching the OAuth2 authorized client and retrieving
     * the user profile data.
     *
     * @return a {@link KindeProfile} object containing user details.
     */
    public KindeProfile loadDashboard() {

        UserInfo userInfo = kindeClientService.getKindeClientSession().retrieveUserInfo();

        DefaultOidcUser principal = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return KindeProfile.builder()
                .accessToken(kindeClientService.getOAuth2AuthorizedClient().getAccessToken().getTokenValue())
                .fullName(principal.getUserInfo().getFullName())
                .idToken(principal.getIdToken().getTokenValue())
                .roles(new HashSet<>(principal.getAuthorities()))
                .userInfo(userInfo)
                .build();
    }

    public AuthorizationUrl register() {
        return kindeClientService.getKindeClientSession().register();
    }

    public AuthorizationUrl createOrg(String orgName) {
        return kindeClientService.getKindeClientSession().createOrg(orgName);
    }

    public AuthorizationUrl signout() {
        try {
            return kindeClientService.getKindeClientSession().logout();
        } catch (Exception e) {
            log.error("Unable to logout: {}", e.getMessage());
            return null;
        }
    }
}

