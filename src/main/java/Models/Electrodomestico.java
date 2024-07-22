package Models;

import java.time.LocalDate;

public class Electrodomestico extends Producto{

    private String consumoEnergetico;
    private LocalDate fechaFabricacion;
    private double capacidad;
    private final int garantia = 18; //meses

    public Electrodomestico(String nombre, String marca, double precio, int stock, LocalDate fechaCompra,
                            double porcentajeRebaja, String consumoEnergetico, LocalDate fechaFabricacion,
                            double capacidad) {
        super(nombre, marca, precio, stock, fechaCompra, porcentajeRebaja);
        this.consumoEnergetico = consumoEnergetico;
        this.fechaFabricacion = fechaFabricacion;
        this.capacidad = capacidad;
    }

    public String getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public int getGarantia() {
        return garantia;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
