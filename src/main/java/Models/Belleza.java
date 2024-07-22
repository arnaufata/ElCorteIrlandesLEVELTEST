package Models;

import Enums.TemporadaUso;

import java.time.LocalDate;

public class Belleza extends Producto{

    private boolean vegano;
    private TemporadaUso temporadaUso;

    public Belleza(String nombre, String marca, double precio, int stock, LocalDate fechaCompra,
                   double porcentajeRebaja, boolean vegano, TemporadaUso temporadaUso) {
        super(nombre, marca, precio, stock, fechaCompra, porcentajeRebaja);
        this.vegano       = vegano;
        this.temporadaUso = temporadaUso;
    }

    public boolean isVegano() {
        return vegano;
    }

    public TemporadaUso getTemporadaUso() {
        return temporadaUso;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
