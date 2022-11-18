package com.urbanoSpring.urbanoSpring.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanoSpring.urbanoSpring.models.OrdenCompra;
@Repository
public interface OrdenRepository extends JpaRepository<OrdenCompra, Serializable> {
    

}
 