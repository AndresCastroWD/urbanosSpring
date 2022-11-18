package com.urbanoSpring.urbanoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanoSpring.urbanoSpring.Repository.DetalleCompraRepository;
import com.urbanoSpring.urbanoSpring.Repository.OrdenRepository;
import com.urbanoSpring.urbanoSpring.models.DetallesOrdenCompra;
import com.urbanoSpring.urbanoSpring.models.OrdenCompra;
import com.urbanoSpring.urbanoSpring.models.Productos;
import com.urbanoSpring.urbanoSpring.service.ProductosService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/compra")
@CrossOrigin("*")
public class CompraController {
    @Autowired
    private ProductosService productoservice;
    @Autowired
    OrdenRepository ordenRepository;
    @Autowired
    DetalleCompraRepository detallesOrdenCompraRepository;

    // Mostrar Todos los Productos al usuario
    @GetMapping("/todosProductos")
    public ResponseEntity<List<Productos>> findAll() {
        return new ResponseEntity<>(productoservice.findAll(), HttpStatus.OK);
    }

    // buscar productos
    @GetMapping("/{id}")
    public ResponseEntity<Productos> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(productoservice.get(id), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public List<OrdenCompra> buscar() {
        return ordenRepository.findAll();
    }

    @PostMapping("/guardar")
    public OrdenCompra guardar(@RequestBody OrdenCompra ordenCompra) {
        List<DetallesOrdenCompra> detalles = ordenCompra.getDetallesOrdenCompra();
        ordenCompra.setDetallesOrdenCompra(null);
        ordenRepository.save(ordenCompra);
        System.out.print(ordenCompra);

        for (DetallesOrdenCompra det: detalles) {
            det.setOrdenid(ordenCompra.getOrdenid());
        }

        detallesOrdenCompraRepository.saveAll(detalles);
        return ordenCompra;

    }

}
