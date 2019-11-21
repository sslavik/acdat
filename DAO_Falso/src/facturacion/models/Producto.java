/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.models;

/**
 *
 * @author usuario
 */
public class Producto {
    
    private int id_producto;
    private String ean;
    private String nom_producto;

    public Producto(String ean, String nom_producto) {
        this.ean = ean;
        this.nom_producto = nom_producto;
    }
    
    
    
     public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }
    
}
