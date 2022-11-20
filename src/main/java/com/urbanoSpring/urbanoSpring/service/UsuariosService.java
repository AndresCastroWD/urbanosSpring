package com.urbanoSpring.urbanoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanoSpring.urbanoSpring.models.Usuarios;
import com.urbanoSpring.urbanoSpring.repository.UsuariosRepository;

@Service
public class UsuariosService {
@Autowired    
private UsuariosRepository usuariosRepository;

public List<Usuarios> BuscarTodos() {
    return usuariosRepository.findAll();
}

public Usuarios GuardarUsuario(Usuarios usuarios) {
    return usuariosRepository.save(usuarios);
}

public Optional<Usuarios> BuscarById(Integer id) {
    return usuariosRepository.findById(id);
    
}

public void EliminarUsuario(Integer id) {
    usuariosRepository.deleteById(id);
}

}
