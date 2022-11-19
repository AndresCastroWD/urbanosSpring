package com.urbanoSpring.urbanoSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanoSpring.urbanoSpring.models.DetallesOrdenCompra;
import com.urbanoSpring.urbanoSpring.models.OrdenCompra;
import com.urbanoSpring.urbanoSpring.models.Productos;
import com.urbanoSpring.urbanoSpring.service.DetallesService;
import com.urbanoSpring.urbanoSpring.service.OrdenService;
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
    private OrdenService ordenservice;

    @Autowired
    private DetallesService detallesService;

    // Mostrar Todos los Productos al usuario
    @GetMapping("/todos")
    public ResponseEntity<List<Productos>> BuscarTodos() {
        return new ResponseEntity<>(productoservice.BuscarTodos(), HttpStatus.OK);
    }

    // buscar productos
    @GetMapping("/{id}")
    public ResponseEntity<Productos> BucarById(@PathVariable Integer id) {
        return new ResponseEntity<>(productoservice.get(id), HttpStatus.OK);
    }

    // buscar Orden de Compra
    @GetMapping("/buscar")
    public List<OrdenCompra> buscar() {
        return ordenservice.buscar();
    }

    // guardar Orden de compra
    @PostMapping("/guardar")
    public OrdenCompra guardar(@RequestBody OrdenCompra ordenCompra) {

        List<DetallesOrdenCompra> detalles = ordenCompra.getDetallesOrdenCompra();

        ordenCompra.setDetallesOrdenCompra(null);
        ordenservice.guardarOrden(ordenCompra);

        for (DetallesOrdenCompra det : detalles) {
            det.setOrdenid(ordenCompra.getOrdenid());
        }

        detallesService.GuardarDetalles(detalles);

        return ordenCompra;
    }

    // Eliminar Factura
    @DeleteMapping("/eliminar/{id}")
    public void eliminarOrden(@PathVariable("id") Integer id) {
        Optional<OrdenCompra> orden = ordenservice.BuscarOrden(id);
        if (orden.isPresent()) {
            detallesService.EliminarDetalles(orden.get().getDetallesOrdenCompra());
            ordenservice.EliminarOrden(orden.get());
        }
    }

}
