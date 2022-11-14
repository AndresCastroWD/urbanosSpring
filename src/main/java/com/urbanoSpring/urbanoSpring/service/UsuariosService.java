package com.urbanoSpring.urbanoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanoSpring.urbanoSpring.Repository.UsuariosRepository;
import com.urbanoSpring.urbanoSpring.models.Usuarios;

@Service
public class UsuariosService {
@Autowired    
private UsuariosRepository usuariosRepository;

public List<Usuarios> findAll() {
    return usuariosRepository.findAll();
}

public Usuarios save(Usuarios usuarios) {
    return usuariosRepository.save(usuarios);
}

public Usuarios get(Integer id) {
    return usuariosRepository.findById(id).get();
    
}

public void delete(Integer id) {
    usuariosRepository.deleteById(id);
}

}
