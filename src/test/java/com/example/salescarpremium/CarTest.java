package com.example.salescarpremium;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.salescarpremium.dao.CarDAO;
import com.example.salescarpremium.dtos.CarDTO;
import com.example.salescarpremium.entities.Car;
import com.example.salescarpremium.services.interfaces.CarService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CarTest {
    private List<Car> carList;

    @MockBean 
    private CarDAO carDAO; 

    @Autowired
    private CarService carService; // Inyectamos la interfaz del servicio

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();

        Car car1 = new Car();
        car1.setId(1L);
        car1.setMarca("Toyota");
        car1.setLinea("Camry");
        car1.setColor("Red");
        car1.setModel(2022);
        car1.setPlaca("ABC123");
        car1.setFechafabri(java.time.LocalDate.of(2022, 1, 1));
        car1.setLinea("Corolla");

        carList.add(car1);

        Car car2 = new Car();
        car2.setId(2L);
        car2.setMarca("Honda");
        car2.setLinea("Civic");
        car2.setColor("Blue");
        car2.setModel(2021);
        car2.setPlaca("XYZ456");
        car2.setFechafabri(java.time.LocalDate.of(2021, 1, 1));
        car2.setLinea("Accord");

        carList.add(car2);

        Car carSaveTest = new Car();
        carSaveTest.setId(3L);
        carSaveTest.setMarca("Ford");
        carSaveTest.setLinea("Focus");
        carSaveTest.setColor("Black");
        carSaveTest.setModel(2020);
        carSaveTest.setPlaca("LMN789");
        carSaveTest.setFechafabri(java.time.LocalDate.of(2020, 1, 1));
        carSaveTest.setLinea("Mustang");

        carList.add(carSaveTest);
    }

    @Test
    @DisplayName("Test Car List Creation")
    void testCarList() {

        when(carDAO.findAll()).thenReturn(carList);

        List<CarDTO> response = carService.findAllService();

       assertEquals("Toyota", response.get(0).getMarca());
    }

    @Test
    @DisplayName("Test Car find by ID")
    void testCarById(){

        when(carDAO.findById(0L)).thenReturn(Optional.of(carList.get(0)));

        Optional<CarDTO> response = carService.findOneServide(0L);

        assertEquals(1L, response.get().getId());

        
    }

    @Test
    @DisplayName("Test Car Creation")
    void testCarCreation() {

        when(carDAO.save(any(Car.class))).thenReturn(carList.get(2));

        CarDTO response = carService.saveService(new CarDTO());

        assertEquals("Ford", response.getMarca());
        
    }

    @Test
    @DisplayName("Test Car Deletion")
    void testCarDeletion() {

        doNothing().when(carDAO).deleteById(0L);

        carService.deleteService(0L);

        verify(carDAO, times(1)).deleteById(0L);
        
    }
}