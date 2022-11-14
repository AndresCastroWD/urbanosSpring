package com.urbanoSpring.urbanoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanoSpring.urbanoSpring.models.Usuarios;
import com.urbanoSpring.urbanoSpring.service.UsuariosService;



@RestController
@RequestMapping("/urbano/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/guardar")
    public ResponseEntity<Usuarios> save(@RequestBody Usuarios usuarios){
        return new ResponseEntity<>(usuariosService.save(usuarios), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuarios>> findAll(){
        return new ResponseEntity<>(usuariosService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> findById(@PathVariable Integer id){
        return new ResponseEntity<>(usuariosService.get(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        usuariosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
