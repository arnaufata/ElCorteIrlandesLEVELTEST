package Models;

import java.time.LocalDate;

public class Ropa extends Producto{

    private String talla;
    private String tipoTejido;
    private String tipoPrenda;

    public Ropa(String nombre, String marca, double precio, int stock, LocalDate fechaCompra,
                double porcentajeRebaja, String talla, String tipoTejido, String tipoPrenda) {
        super(nombre, marca, precio, stock, fechaCompra, porcentajeRebaja);
        this.talla      = talla;
        this.tipoTejido = tipoTejido;
        this.tipoPrenda = tipoPrenda;
    }

    public String getTalla() {
        return talla;
    }

    public String getTipoTejido() {
        return tipoTejido;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
