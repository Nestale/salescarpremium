package com.example.salescarpremium.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//  @Data = @NoArgsConstructor & @AllArgsConstructor
@Table(name = "cars_premium")
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String marca;
    private String linea;
    private String color;

    @Column(length = 4)
    private Integer model;
    private String placa;
    private LocalDate fechafabri;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getFechafabri() {
        return fechafabri;
    }

    public void setFechafabri(LocalDate fechafabri) {
        this.fechafabri = fechafabri;
    }
}
