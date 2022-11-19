package com.urbanoSpring.urbanoSpring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanoSpring.urbanoSpring.models.DetallesOrdenCompra;
import com.urbanoSpring.urbanoSpring.repository.DetallesOrdenRepository;

@Service
public class DetallesService {
   @Autowired
   private DetallesOrdenRepository detallesOrdenRepository;
   
   public List<DetallesOrdenCompra> GuardarDetalles(List<DetallesOrdenCompra> detallesOrdenCompra) {
    return detallesOrdenRepository.saveAll(detallesOrdenCompra);
}

public void EliminarDetalles(List<DetallesOrdenCompra> det){
    detallesOrdenRepository.deleteAll(det);
}




}
