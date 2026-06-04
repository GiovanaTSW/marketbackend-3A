package edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity;

import jakarta.persistence.*;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Table (name = "categorias")

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria") //Nombre de la columna
    private Integer idCategoria; //Solo se agrega si es nombre diferente

    private String descripcion;

    private Boolean estado;

    //Una categoría va a tener muchos productos
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

