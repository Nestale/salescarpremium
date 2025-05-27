package com.example.salescarpremium.dao;

import com.example.salescarpremium.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDAO extends JpaRepository<Car,Long> {
}