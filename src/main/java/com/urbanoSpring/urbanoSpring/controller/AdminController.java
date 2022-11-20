package com.urbanoSpring.urbanoSpring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urbanoSpring.urbanoSpring.models.Productos;
import com.urbanoSpring.urbanoSpring.models.Usuarios;
import com.urbanoSpring.urbanoSpring.service.ProductosService;
import com.urbanoSpring.urbanoSpring.service.UsuariosService;

@RestController
@RequestMapping("/apiAdmin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private ProductosService productoservice;

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/guardarProductos")
    public ResponseEntity<Productos> save(@RequestBody Productos product) {
        return new ResponseEntity<>(productoservice.GuardarProducto(product), HttpStatus.CREATED);
    }

    @GetMapping("/todosProductos")
    public ResponseEntity<List<Productos>> BuscarTodos() {
        return new ResponseEntity<>(productoservice.BuscarTodos(), HttpStatus.OK);
    }


    @GetMapping("/producto/{id}")
    public ResponseEntity<?> BuscarProductoById(@PathVariable Integer id) {
        Map<String, Object> respuesta = new HashMap<>();
        Optional<Productos> productoactual = null;
        productoactual = productoservice.BuscarById(id);

        if (productoactual.isPresent()) {
            respuesta.put("Mensaje", productoactual.get());
        }else {
            respuesta.put("Mensaje", "No se encontro en Producto con id: ".concat(id.toString()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }
 
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/buscarProducto/nombrelike")
    public ResponseEntity<List<Productos>> getLaptopsByNameLike(@RequestParam String nombre) {
        return new ResponseEntity<List<Productos>>(productoservice.BuscarLikeNombre("%" + nombre + "%"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<?> EliminarProducto(@PathVariable Integer id) {
        Map<String, Object> respuesta = new HashMap<>();
        try {
            productoservice.EliminarProducto(id);
            respuesta.put("Mensaje", "Se Elimino Correctamente el Producto ".concat(id.toString()));
        } catch (DataAccessException e) {
            respuesta.put("Mensaje", "Ocurrio un error al eliminar el Producto id: ".concat(id.toString()));
            respuesta.put("Error:", e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/actualizarProducto")
    public void ActualizarProducto(@RequestBody Productos product) {
        productoservice.ActualizarProducto(product);
    }

    @PostMapping("/usuarios/guardar")
    public ResponseEntity<Usuarios> GuardarUsuario(@RequestBody Usuarios usuarios) {
        return new ResponseEntity<>(usuariosService.GuardarUsuario(usuarios), HttpStatus.CREATED);
    }

    @GetMapping("/usuarios/todosUsuarios")
    public ResponseEntity<List<Usuarios>> BuscarTodosUsuario() {
        return new ResponseEntity<>(usuariosService.BuscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
        Map<String, Object> respuesta = new HashMap<>();
        Optional<Usuarios> usuarioactual = null;
        usuarioactual = usuariosService.BuscarById(id);

        if (usuarioactual.isPresent()) {
            respuesta.put("Mensaje", usuarioactual.get());
        }else {
            respuesta.put("Mensaje", "No se encontro en Usuario con id: ".concat(id.toString()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }
 
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("/EliminarUsuario/{id}")
    public ResponseEntity<?> EliminarUsuario(@PathVariable Integer id) {
        Map<String, Object> respuesta = new HashMap<>();
        try {
            usuariosService.EliminarUsuario(id);
            respuesta.put("Mensaje", "Se Elimino Correctamente el Usuario ".concat(id.toString()));
        } catch (DataAccessException e) {
            respuesta.put("Mensaje", "Ocurrio un error al eliminar el Usuario id: ".concat(id.toString()));
            respuesta.put("Error:", e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
    }

}
