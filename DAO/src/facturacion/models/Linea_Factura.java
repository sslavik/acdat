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
public class Linea_Factura {
    private int num_factura;
    private int num_linea_factura;
    private int id_producto;
    private int cantidad;

    public Linea_Factura(Factura factura, int num_linea_factura,Producto producto, int cantidad) {
        this.num_factura = factura.getNum_factura();
        this.num_linea_factura = num_linea_factura;
        this.cantidad = cantidad;
    }
    
    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public int getNum_linea_factura() {
        return num_linea_factura;
    }

    public void setNum_linea_factura(int num_linea_factura) {
        this.num_linea_factura = num_linea_factura;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
