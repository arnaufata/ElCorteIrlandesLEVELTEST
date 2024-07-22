package Models;

import Enums.CapacidadBateria;

import java.time.LocalDate;

public class ComponenteElectronico extends Producto{

    private String resolucionImagen;
    private CapacidadBateria capacidadBateria;
    private final int garantia = 9; //meses

    public ComponenteElectronico(String nombre, String marca, double precio, int stock, LocalDate fechaCompra,
                                 double porcentajeRebaja, String resolucionImagen, CapacidadBateria capacidadBateria) {
        super(nombre, marca, precio, stock, fechaCompra, porcentajeRebaja);
        this.resolucionImagen = resolucionImagen;
        this.capacidadBateria = capacidadBateria;
    }

    public String getResolucionImagen() {
        return resolucionImagen;
    }

    public CapacidadBateria getCapacidadBateria() {
        return capacidadBateria;
    }

    public int getGarantia() {
        return garantia;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
