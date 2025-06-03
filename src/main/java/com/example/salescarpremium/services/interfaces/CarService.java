package com.example.salescarpremium.services.interfaces;

import com.example.salescarpremium.dtos.CarDTO;
import java.util.List;
import java.util.Optional;

public interface CarService {
    List<CarDTO> findAllService(); // Traerá todos los registros para meterlos en un listado
    Optional<CarDTO> findOneServide(Long id);
    CarDTO saveService(CarDTO carDTO);
    void deleteService(Long id);
}
