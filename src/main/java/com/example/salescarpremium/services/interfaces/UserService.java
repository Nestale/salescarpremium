package com.example.salescarpremium.services.interfaces;

import com.example.salescarpremium.dtos.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAllService();
    Optional<UserDTO> findOneService(Long id);
    UserDTO saveService(UserDTO userDTO);
    void deleteService(Long id);
} 