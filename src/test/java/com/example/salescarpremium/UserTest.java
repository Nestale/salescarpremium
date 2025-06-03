package com.example.salescarpremium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.salescarpremium.dao.UserDAO;
import com.example.salescarpremium.dtos.UserDTO;
import com.example.salescarpremium.entities.User;
import com.example.salescarpremium.services.interfaces.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
@SpringBootTest

public class UserTest {
    private List<User> userList;

    @MockBean
    private UserDAO userDAO;

    @Autowired
    private UserService userService; // Inyectamos la interfaz del servicio
    
    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        user1.setName("John Doe");
        user1.setLastName("Johnson");
        user1.setAge(30);
        user1.setUsername("JohnD");
        user1.setPassword("password123");

        userList.add(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Jane Smith");
        user2.setLastName("Smith");
        user2.setAge(25);
        user2.setUsername("JaneS");
        user2.setPassword("password456");

        userList.add(user2);
    }

    @Test
    @DisplayName("Test User Creation")
    void testUserCreation() {

        when(userDAO.findAll()).thenReturn(userList);

        List<UserDTO> response = userService.findAllService();

        assertEquals("Smith", response.get(1).getLastName());
            
    }

    @Test
    @DisplayName("Test User find by ID")
    void testUserById() {

        when(userDAO.findById(0L)).thenReturn(Optional.of(userList.get(0)));

        Optional<UserDTO> response = userService.findOneService(0L);

        assertEquals("John Doe", response.get().getName());
    }

    @Test
    @DisplayName("Test Car Creation")
    void testCarCreation() {

        when(userDAO.save(any(User.class))).thenReturn(userList.get(1));

        UserDTO savCarDTO = userService.saveService(new UserDTO());

        assertEquals(25, savCarDTO.getAge());
        
    }

    @Test
    @DisplayName("Test Car Deletion")
    void testCarDeletion() {

       doNothing().when(userDAO).deleteById(0L);

        userService.deleteService(0L);

        verify(userDAO, times(1)).deleteById(0L);
        
    }
}
