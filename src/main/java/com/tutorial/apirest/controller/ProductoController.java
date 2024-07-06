package com.tutorial.apirest.controller;

import com.tutorial.apirest.dto.ProductoDto;
import com.tutorial.apirest.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/producto")
    public ResponseEntity<ProductoDto> saveProducto(@Valid @RequestBody ProductoDto productoDto) {
        return new ResponseEntity<>(productoService.save(productoDto), HttpStatus.CREATED);
    }

    @GetMapping("/producto")
    public ResponseEntity<List<ProductoDto>> getProducto() {
        return new ResponseEntity<>(productoService.getProductos(), HttpStatus.OK);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<ProductoDto> productoById(@PathVariable Long id) {

        return new ResponseEntity<>(productoService.getProducto(id), HttpStatus.OK);

    }

    @GetMapping("/producto/categoria/{nombre}")
    public ResponseEntity<List<ProductoDto>> getAllProductoCategoria(@PathVariable String nombre) {
        return new ResponseEntity<>(productoService.getProductoCategoria(nombre), HttpStatus.OK);
    }

    @PutMapping("/producto/{productoId}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long productoId, @RequestBody ProductoDto productoDto) {
        return new ResponseEntity<>(productoService.update(productoId, productoDto), HttpStatus.OK);
    }

    @DeleteMapping("/producto/{productoId}")
    public ResponseEntity<ProductoDto> deleteProducto(@PathVariable Long productoId) {
        return new ResponseEntity<>(productoService.delete(productoId), HttpStatus.OK);
    }
}
