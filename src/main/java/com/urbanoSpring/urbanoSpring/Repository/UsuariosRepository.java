package com.urbanoSpring.urbanoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanoSpring.urbanoSpring.models.Usuarios;
@Repository
public interface UsuariosRepository  extends JpaRepository<Usuarios, Integer> {

}
