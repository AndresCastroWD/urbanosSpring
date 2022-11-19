package com.urbanoSpring.urbanoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.urbanoSpring.urbanoSpring.service.ProductosService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class ProductosController {

   @Autowired
   private ProductosService productoservice;


   @PostMapping("/guardarProductos")
   public ResponseEntity<Productos> save(@RequestBody Productos product) {
      return new ResponseEntity<>(productoservice.GuardarProducto(product), HttpStatus.CREATED);
   }

   @GetMapping("/todosProductos")
   public ResponseEntity<List<Productos>> BuscarTodos() {
      return new ResponseEntity<>(productoservice.BuscarTodos(), HttpStatus.OK);
   }

   @GetMapping("/buscarProducto/nombrelike")
	public ResponseEntity<List<Productos>> getLaptopsByNameLike(@RequestParam String nombre) {
		return new ResponseEntity<List<Productos>>(productoservice.BuscarLikeNombre("%"+nombre+"%"), HttpStatus.OK);
	}

   @DeleteMapping("/elimnarProdcuto/{id}")
   public ResponseEntity delete(@PathVariable Integer id) {
    //  productoservice.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);

   }

   @PutMapping("actualizarProducto")
   public void ActualizarProducto(@RequestBody Productos product){
      productoservice.ActualizarProducto(product);

   }


}
