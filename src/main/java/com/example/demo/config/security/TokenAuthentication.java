package com.example.demo.config.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Package: com.cc.proj.colorcollection.config.security
 * Name: TokenAuthentication
 * Description:spring-security的Authentication的自定义实现（用于校验token）
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
 * Date: 2020-10-29
 */

public class TokenAuthentication implements Authentication {

    private List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();

    public TokenAuthentication() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }


    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}