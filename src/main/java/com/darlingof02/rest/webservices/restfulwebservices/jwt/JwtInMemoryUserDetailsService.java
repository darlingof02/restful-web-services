package com.darlingof02.rest.webservices.restfulwebservices.jwt;


import com.darlingof02.rest.webservices.restfulwebservices.todo.User;
import com.darlingof02.rest.webservices.restfulwebservices.todo.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
    @Autowired
    private UserJpaRepository userJpaRepository;

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(1L, "darlingof02",
                "$2a$10$9azqBvY6ZeXyIub4Je4ImOHFs7rW3irAyzPvsV25cRYUlVGnZ4U4G", "ROLE_USER_2"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> users = userJpaRepository.findByUsername(username);
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        } else {
            return new JwtUserDetails(users.get(0).getUid(), users.get(0).getUsername(), users.get(0).getPassword(), "ROLE_USER_2");
        }

    }

}


