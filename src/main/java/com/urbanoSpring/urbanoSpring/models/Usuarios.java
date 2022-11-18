package com.urbanoSpring.urbanoSpring.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identificacion;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    @OneToMany(mappedBy = "usuario")
    private List<Productos> productos;

    @OneToMany(mappedBy = "usuario")
    private List<OrdenCompra>  ordenCompra;

    public Usuarios() {

    }



    public List<Productos> getProductos() {
        return productos;
    }



    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }



    public List<OrdenCompra> getOrdenCompra() {
        return ordenCompra;
    }



    public void setOrdenCompra(List<OrdenCompra> ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

}
