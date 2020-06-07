package com.peerLending.profile.application;

import com.peerLending.profile.domain.model.User;
import com.peerLending.profile.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final UserRepository userRepository;

    @Autowired
    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public void newUser(@RequestBody final User user) {
        user.setRegisteredSince(LocalDate.now());
        userRepository.save(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody final User user) {
        userRepository.save(user);
    }
}
