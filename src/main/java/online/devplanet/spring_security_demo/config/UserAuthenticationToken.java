package online.devplanet.spring_security_demo.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private final String userId;

    public UserAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String userId) {
        super(principal, credentials, authorities);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
