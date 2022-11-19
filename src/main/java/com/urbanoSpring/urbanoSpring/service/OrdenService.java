package com.urbanoSpring.urbanoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanoSpring.urbanoSpring.models.OrdenCompra;
import com.urbanoSpring.urbanoSpring.repository.OrdenRepository;


@Service
public class OrdenService {
    @Autowired
    OrdenRepository ordenRepository;
    
    public List<OrdenCompra> buscar() {
        return ordenRepository.findAll();
    }
    
    public OrdenCompra guardarOrden(OrdenCompra orden) {
        return ordenRepository.save(orden);
    }

    public Optional<OrdenCompra> BuscarOrden(Integer id){
        return ordenRepository.findById(id);
    }

public  void EliminarOrden(OrdenCompra orden){
    ordenRepository.delete(orden);

}



}
