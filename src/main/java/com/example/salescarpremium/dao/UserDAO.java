package com.example.salescarpremium.dao;

import com.example.salescarpremium.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
} 