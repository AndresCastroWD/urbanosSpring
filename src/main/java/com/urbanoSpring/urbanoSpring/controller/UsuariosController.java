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
@RequestMapping("/admin/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/guardar")
    public ResponseEntity<Usuarios> GuardarUsuario(@RequestBody Usuarios usuarios){
        return new ResponseEntity<>(usuariosService.GuardarUsuario(usuarios), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuarios>> BuscarTodos(){
        return new ResponseEntity<>(usuariosService.BuscarTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> BuscarById(@PathVariable Integer id){
        return new ResponseEntity<>(usuariosService.BuscarById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity EliminarUsuario(@PathVariable Integer id){
        usuariosService.EliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
