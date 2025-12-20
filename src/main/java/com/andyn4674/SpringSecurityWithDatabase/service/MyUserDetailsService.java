package com.andyn4674.SpringSecurityWithDatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.andyn4674.SpringSecurityWithDatabase.model.UserPrincipal;
import com.andyn4674.SpringSecurityWithDatabase.model.Users;
import com.andyn4674.SpringSecurityWithDatabase.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
    
}
