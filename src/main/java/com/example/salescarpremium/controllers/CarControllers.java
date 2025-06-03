package com.example.salescarpremium.controllers;

import com.example.salescarpremium.dtos.CarDTO;
import com.example.salescarpremium.services.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Esta clase es un controlador
@RequestMapping("/api/cars") //¿A qué ruta vamos a acceder?
public class CarControllers {

    @Autowired
    private CarService carService; // Se llama a la interfaz y se inyecta con autowired

    @GetMapping("/list")
    public List<CarDTO> listCars(){
        try {
            return this.carService.findAllService();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @PostMapping("/save")
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        try {
            return this.carService.saveService(carDTO);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Long id) {
        try {
            this.carService.deleteService(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
