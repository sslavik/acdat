/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_falso.models;

/**
 *
 * @author Vyacheslav Shylyayev
 */
public class Cliente {
    String dni;
    String nom_cliente;
    int id;

   
    public Cliente(String dni, String nom_cliente) {
        this.dni = dni;
        this.nom_cliente = nom_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }
     
    public int getId() {
        return id;
    }

    
}
