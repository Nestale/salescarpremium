package com.example.salescarpremium.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Long id;
    private String marca;
    private String linea;
    private String color;
    private Integer model;
    private String placa;
}
