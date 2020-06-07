package com.peerLending.securityapp.user.model.repository;

import com.peerLending.securityapp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
