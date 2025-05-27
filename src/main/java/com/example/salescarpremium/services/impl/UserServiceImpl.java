package com.example.salescarpremium.services.impl;

import com.example.salescarpremium.dao.UserDAO;
import com.example.salescarpremium.dtos.UserDTO;
import com.example.salescarpremium.entities.User;
import com.example.salescarpremium.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> findAllService() {
        List<User> listDB = userDAO.findAll();
        return listDB.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findOneService(Long id) {
        Optional<User> user = userDAO.findById(id);
        return user.map(u -> modelMapper.map(u, UserDTO.class));
    }

    @Override
    public UserDTO saveService(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(userDAO.save(user), UserDTO.class);
    }
} 