package edu.mx.tecdesoftware.marketbackend_3A.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    private int purchaseId;
    private int clientId;
    private LocalDateTime fecha;
    private String medioPago;
    private String comentario;
    private String estado;
    private List<PurchaseItem> Products;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PurchaseItem> getProducts() {
        return Products;
    }

    public void setProducts(List<PurchaseItem> products) {
        Products = products;
    }
}
