package biz.simplebank.busreservation.services;

import biz.simplebank.busreservation.entities.AppUsers;
import biz.simplebank.busreservation.repos.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AppUsers appUsers = appUserRepository.findByUserName(username).orElseThrow(() ->
            new UsernameNotFoundException("User not found with username: "));
        return User.builder()
                .username(appUsers.getUserName())
                .password(appUsers.getPassword())
                .roles(appUsers.getRole())
                .build();
    }
}
