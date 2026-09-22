package com.kinde.oauth.service;

import com.kinde.KindeClient;
import com.kinde.KindeClientBuilder;
import com.kinde.KindeClientSession;
import com.kinde.token.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class KindeClientService {

    private final OAuth2AuthorizedClientService authorizedClientService;

    public KindeClientService(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    public KindeClientSession getKindeClientSession() {
        OAuth2AuthorizedClient authorizedClient = getOAuth2AuthorizedClient();
        KindeClient client = KindeClientBuilder.builder().build();
        return client.initClientSession(
                AccessToken.init(authorizedClient.getAccessToken().getTokenValue(), true)
        );
    }

    /**
     * Retrieves the OAuth2 authorized client for the authenticated user.
     *
     * @return the {@link OAuth2AuthorizedClient} for the user.
     */
    public OAuth2AuthorizedClient getOAuth2AuthorizedClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return getOAuth2AuthorizedClient(authentication);
    }

    private OAuth2AuthorizedClient getOAuth2AuthorizedClient(Authentication authentication) {
        return authorizedClientService.loadAuthorizedClient("kinde", authentication.getName());
    }
}

