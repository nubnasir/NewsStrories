package com.nubnasir.newsstories.authentication.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by root on 9/13/18.
 */
public class ApplicationUserAuthentication {

    public static String encrypt(String str){
        return new BCryptPasswordEncoder().encode(str);
    }

    public static boolean match(String str, String encryptedStr){
        return new BCryptPasswordEncoder().matches(str, encryptedStr);
    }

}
