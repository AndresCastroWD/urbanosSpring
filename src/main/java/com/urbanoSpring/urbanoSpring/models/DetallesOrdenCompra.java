package com.urbanoSpring.urbanoSpring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_orden")
public class DetallesOrdenCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Integer detalleid;
    private double cantidad;
    private double precio;

    private double total;

    @Column(name = "ordenid")
    private Integer ordenid;

    @Column(name = "productoid")
    private Integer productoid;

    public Integer getDetalleid() {
        return detalleid;
    }

    public void setDetalleid(Integer detalleid) {
        this.detalleid = detalleid;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid(Integer productoid) {
        this.productoid = productoid;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getOrdenid() {
        return ordenid;
    }

    public void setOrdenid(Integer ordenid) {
        this.ordenid = ordenid;
    }

}
