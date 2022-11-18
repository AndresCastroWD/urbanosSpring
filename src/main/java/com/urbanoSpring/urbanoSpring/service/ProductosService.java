package com.urbanoSpring.urbanoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanoSpring.urbanoSpring.Repository.ProductosRepository;
import com.urbanoSpring.urbanoSpring.models.Productos;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    // definimos metodo para obtener todos los productos
    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    // definimos metodo para guardar el producto
    public Productos save(Productos product) {
        return productosRepository.save(product);
    }

    // definimos metodo para buscar el producto
    public Productos get(Integer id) {
        return productosRepository.findById(id).get();

    }

}
