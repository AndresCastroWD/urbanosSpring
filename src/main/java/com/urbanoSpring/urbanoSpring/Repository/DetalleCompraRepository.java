package com.urbanoSpring.urbanoSpring.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanoSpring.urbanoSpring.models.DetallesOrdenCompra;

@Repository
public interface DetalleCompraRepository  extends JpaRepository<DetallesOrdenCompra, Serializable>{
    
}
