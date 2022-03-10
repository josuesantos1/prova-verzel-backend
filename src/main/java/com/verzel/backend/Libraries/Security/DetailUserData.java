package com.verzel.backend.Libraries.Security;

import com.verzel.backend.Database.Models.UsersModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetailUserData implements UserDetails {

    private final Optional<UsersModel> usersModel;

    public DetailUserData(Optional<UsersModel> usersModel) {
        this.usersModel = usersModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usersModel.orElse(new UsersModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return usersModel.orElse(new UsersModel()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}