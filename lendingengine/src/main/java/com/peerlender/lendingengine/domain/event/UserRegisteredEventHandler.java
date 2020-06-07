package com.peerlender.lendingengine.domain.event;

import com.google.gson.Gson;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventHandler {

    private Logger LOGGER = LoggerFactory.getLogger(UserRegisteredEventHandler.class);
    private static final Gson GSON = new Gson();
    private final UserRepository userRepository;

    @Autowired
    public UserRegisteredEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void handleUserRegistration(String  userDetails) {
        User user = GSON.fromJson(userDetails, User.class);
        LOGGER.info("user {} registered", user.getUsername());
        userRepository.save(user);
    }
}
