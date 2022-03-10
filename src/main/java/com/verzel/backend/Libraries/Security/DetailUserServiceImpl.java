package com.verzel.backend.Libraries.Security;


import com.verzel.backend.Database.Models.UsersModel;
import com.verzel.backend.Database.Repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailUserServiceImpl implements UserDetailsService {
    private final UsersRepository userRepository;

    public DetailUserServiceImpl(UsersRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersModel> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("email [ " + username + " ] not found");
        }

        return new DetailUserData(user);
    }
}
