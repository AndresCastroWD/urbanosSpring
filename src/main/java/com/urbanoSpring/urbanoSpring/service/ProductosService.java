package com.urbanoSpring.urbanoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanoSpring.urbanoSpring.models.Productos;
import com.urbanoSpring.urbanoSpring.repository.ProductosRepository;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    // definimos metodo para obtener todos los productos
    public List<Productos> BuscarTodos() {
        return productosRepository.findAll();
    }

    // definimos metodo para guardar el producto
    public Productos GuardarProducto(Productos product) {
        return productosRepository.save(product);
    }

    // definimos metodo para buscar el producto
    public Productos get(Integer id) {
        return productosRepository.findById(id).get();

    }

    public Optional<Productos> BucarById(Integer id) {
        return productosRepository.findById(id);
    }

    public List<Productos> BuscarLikeNombre(String nombre) {
        return productosRepository.findByNombreLike(nombre);
    }

    public void ActualizarProducto (Productos producto) {
        productosRepository.save(producto);
    }

}
