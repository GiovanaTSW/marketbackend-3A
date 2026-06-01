package edu.mx.tecdesoftware.marketbackend_3A.pesistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import java.util.List;

@Entity
@Table (name = "clientes")
public class Cliente {

    @Id
    private Integer id;

    private String nombre;


    private String apellidos;
    private String celular;
    private String direccion;

    @Column (name = "correo_electronico")
    private String correoElectronico;

    //Un cliente tiene muchas compras
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}
