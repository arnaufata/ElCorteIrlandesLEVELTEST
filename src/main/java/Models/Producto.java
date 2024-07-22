package Models;

import java.time.LocalDate;

public class Producto {

    private static int contadorCodigo = 0;
    private int codigoProducto;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;
    private LocalDate fechaCompra;
    private double porcentajeRebaja;

    public Producto(String nombre, String marca, double precio, int stock, LocalDate fechaCompra,
                    double porcentajeRebaja) {
        this.codigoProducto   = ++contadorCodigo;
        this.nombre           = nombre;
        this.marca            = marca;
        this.precio           = precio;
        this.stock            = stock;
        this.fechaCompra      = fechaCompra;
        this.porcentajeRebaja = porcentajeRebaja;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public double getPorcentajeRebaja() {
        return porcentajeRebaja;
    }


}
