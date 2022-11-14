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

import com.urbanoSpring.urbanoSpring.models.Productos;
import com.urbanoSpring.urbanoSpring.service.ProductosService;

@RestController
@RequestMapping("/urbano")
public class ProductosController {

   @Autowired
   private ProductosService productoservice;

   @PostMapping("/guardarProductos")
   public ResponseEntity<Productos> save(@RequestBody Productos product){
    return new ResponseEntity<>(productoservice.save(product),HttpStatus.CREATED);
   }

   @GetMapping("/todosProductos")
   public ResponseEntity<List<Productos>> findAll(){
    return new ResponseEntity<>(productoservice.findAll(),HttpStatus.OK);
   }

   @GetMapping("/buscarProcduto/{id}")
   public ResponseEntity<Productos> findById(@PathVariable Integer id) {
    return new ResponseEntity<>(productoservice.get(id),HttpStatus.OK);

   }

   @DeleteMapping("/elimnarProdcuto/{id}")
   public ResponseEntity delete(@PathVariable Integer id) {
productoservice.delete(id);
return new ResponseEntity<>(HttpStatus.OK);

   }
    

}
