package com.tutorial.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductoDto {
    private Long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private Integer cantidad;
}
