package com.example.demo.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Package: com.cc.proj.colorcollection.config.security
 * Name: TokenAuthenticationProvider
 * Description:
 * *******************************************
 * <p>
 * Copyright: Copyright (c) 2015
 * <p>
 * Company: ND Co., Ltd.
 * <p>
 * *****************************************
 * <p>
 * User: Yangyang
 * Version: V1.0
 * Date: 2020-12-03
 */

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(TokenAuthentication.class);
    }
}
