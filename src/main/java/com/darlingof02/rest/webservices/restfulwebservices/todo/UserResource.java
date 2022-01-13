package com.darlingof02.rest.webservices.restfulwebservices.todo;

import com.darlingof02.rest.webservices.restfulwebservices.BcryptEncoderTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://todo-demo-frontend.s3-website.us-east-2.amazonaws.com", "http://localhost:4200/"})

public class UserResource {
    private final UserJpaRepository userJpaRepository;

    public UserResource(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @PostMapping("/signup")
    private String createUser(@RequestBody User user) {
        List<User> allByUsername = userJpaRepository.findByUsername(user.getUsername());
        if (allByUsername.stream().filter(m->m.getUsername().equals(user.getUsername())).findAny().isPresent()) {
            return "Created Failed";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userJpaRepository.save(user);
            return "Created Success";
        }
    }


}
