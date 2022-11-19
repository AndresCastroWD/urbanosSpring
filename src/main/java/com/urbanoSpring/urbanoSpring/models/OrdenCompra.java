package com.urbanoSpring.urbanoSpring.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orden_compra")
public class OrdenCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Integer ordenid;
  
    private Date fecha;
    private double total;
    private Integer usuario;

    @OneToMany(mappedBy ="ordenid")
    private List<DetallesOrdenCompra> detallesOrdenCompra;

    public OrdenCompra() {

    }

    public List<DetallesOrdenCompra> getDetallesOrdenCompra() {
        return detallesOrdenCompra;
    }

    public void setDetallesOrdenCompra(List<DetallesOrdenCompra> detallesOrdenCompra) {
        this.detallesOrdenCompra = detallesOrdenCompra;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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


    public Integer getUsuario() {
        return usuario;
    }


    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

}
