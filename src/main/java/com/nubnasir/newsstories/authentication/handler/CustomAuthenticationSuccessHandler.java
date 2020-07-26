package com.nubnasir.newsstories.authentication.handler;

import com.nubnasir.newsstories.authentication.model.session.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 9/12/18.
 */
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            UserInfo userInfo = ((UserInfo) auth.getPrincipal());

            request.getSession().setAttribute("userInfo", userInfo);
            response.sendRedirect("/news/stories");
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
