package com.example.messanger.messanger;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    public User() {
        this.authorities = new HashSet<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.authorities = new HashSet<>();
    }

    // ID пользователя
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Username
    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Password
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Authorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    // Account is not expired
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Account is not locked
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Credentials are not expired
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // User is enabled
    @Override
    public boolean isEnabled() {
        return true;
    }
}

