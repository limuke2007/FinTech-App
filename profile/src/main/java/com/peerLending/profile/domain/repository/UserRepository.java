package com.peerLending.profile.domain.repository;

import com.peerLending.profile.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
