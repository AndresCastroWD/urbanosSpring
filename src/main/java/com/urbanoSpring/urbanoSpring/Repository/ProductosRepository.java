package com.urbanoSpring.urbanoSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanoSpring.urbanoSpring.models.Productos;
@Repository
public interface ProductosRepository extends JpaRepository<Productos,Integer> {
    List<Productos> findByNombreLike(String nombre);
}
