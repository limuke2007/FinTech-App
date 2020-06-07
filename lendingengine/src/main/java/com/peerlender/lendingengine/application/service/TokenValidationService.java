package com.peerlender.lendingengine.application.service;

import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class TokenValidationService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String securityContextBaseUrl;

    @Autowired
    public TokenValidationService(final UserRepository userRepository,
                                  @Value("http://localhost:8081") final String securityContextBaseUrl) {
        this.userRepository = userRepository;
        this.securityContextBaseUrl = securityContextBaseUrl;
    }

    public User validateTokenAndGetUser(final String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> response = restTemplate
                .exchange(securityContextBaseUrl + "/user/validate", HttpMethod.POST, httpEntity, String.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return userRepository.findById(response.getBody())
                    .orElseThrow(() -> new UserNotFoundException(response.getBody()));
        }

        throw new RuntimeException("Invalid token");
    }

}
