package com.kinde.oauth.model;

import com.kinde.user.UserInfo;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Data
@Builder
public class KindeProfile {
    private String idToken;
    private String accessToken;
    private String fullName;
    private Set<GrantedAuthority> roles;
    private UserInfo userInfo;
}
