package com.urbanoSpring.urbanoSpring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanoSpring.urbanoSpring.models.DetallesOrdenCompra;


@Repository
public interface DetallesOrdenRepository extends JpaRepository<DetallesOrdenCompra, Serializable> {


 }
