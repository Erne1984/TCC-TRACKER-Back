package com.floriano.com.floriano.tcc_tracker_api.repositories;

import com.floriano.com.floriano.tcc_tracker_api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer > {

    UserDetails findByEmail(String email);

    boolean existsByEmail(String email);
}
