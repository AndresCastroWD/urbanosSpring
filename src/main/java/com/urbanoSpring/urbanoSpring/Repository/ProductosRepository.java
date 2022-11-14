package com.urbanoSpring.urbanoSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanoSpring.urbanoSpring.models.Productos;
@Repository
public interface ProductosRepository extends JpaRepository<Productos,Integer> {
    
}
