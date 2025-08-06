package com.hospital.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

    // Find a user by their email, useful for login or checking uniqueness
    Optional<User> findByEmail(String email);

    // Check if a user exists with a given email (for uniqueness validation)
    boolean existsByEmail(String email);

    
    Optional<User> findByEmailAndPassword(String email, String password);

    
    // Check if a user exists with a given license number (for doctors)
    Optional<User> findByLicenseNumber(String licenseNumber);
}
