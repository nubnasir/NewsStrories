package com.nubnasir.newsstories.authentication.provider;
import com.nubnasir.newsstories.authentication.model.session.UserInfo;
import com.nubnasir.newsstories.user.model.entity.UserEntity;
import com.nubnasir.newsstories.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by root on 9/12/18.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserEntity userEntity = userService.getByUserName(authentication.getName());

        if(userEntity != null){
            boolean isAuthenticated = userService.isAuthenticate(authentication.getName(), authentication.getCredentials().toString());
            if(isAuthenticated){
                UserInfo userInfo = new UserInfo();
                userInfo.setId(userEntity.getId());
                userInfo.setFullName(userEntity.getFullName());

                return new UsernamePasswordAuthenticationToken(userInfo, "", null);
            } else {
                throw new UserAccountStatusException("Username or password incorrect.");
            }
        } else {
            throw new UserAccountStatusException("Username or password incorrect.");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationClass) {
        return authenticationClass.equals(UsernamePasswordAuthenticationToken.class);
    }

    class UserAccountStatusException extends AccountStatusException {
        public UserAccountStatusException(String msg) {
            super(msg);
        }
    }
}
