package edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "compras_productos")
public class CompraProducto {

    @EmbeddedId
    //Viene de la clase CompraProductoPK
    private CompraProductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    //Saber todos los productos que hay en una compra
    @ManyToOne
    @JoinColumn(name = "id_compra",
    insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto",
            insertable = false, updatable = false)
    private Compra producto;

    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    //Realizar los getters and setters de todas las clases de la carpeta entity a
    //excepción de CompraProductoPK


    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Compra getProducto() {
        return producto;
    }

    public void setProducto(Compra producto) {
        this.producto = producto;
    }
}
