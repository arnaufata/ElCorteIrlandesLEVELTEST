import Enums.CapacidadBateria;
import Enums.TemporadaUso;
import Excepcions.NoStcokException;
import Excepcions.ProductoNoExisteException;
import Models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<Producto> productos;

    public App() {
        this.productos = new ArrayList<>();
    }

    public void startMenu(){
        Scanner teclat = new Scanner(System.in);
        int option;
        do{
            printMenu();
            option = teclat.nextByte();
            switch (option){
                case 1:
                    crearProducte();
                    break;
                case 2:
                    listarProductoPorPecio();
                    break;
                case 3:
                    System.out.println("Indica el codigo del producto que quiere eliminar: ");
                    int codigoProducto = teclat.nextInt();
                    try {
                        eliminarProducto(codigoProducto);
                    } catch (ProductoNoExisteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    listarProductosRebaja();
                    break;
                case 7:
                    System.out.println("Indica el codigo del producto del que quiere conocer su stock: ");
                    int codigoProducto2 = teclat.nextInt();
                    try {
                        consultarStock(codigoProducto2);
                    } catch (NoStcokException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Indica el codigo del producto que quiere actualizar: ");
                    int codigoProducto3 = teclat.nextInt();
                    System.out.println("Indique en cuantas unidades quiere aumentar el stock: ");
                    int cantidad = teclat.nextInt();
                    aumentarStock(codigoProducto3, cantidad);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while(option != 0);

    }

    private void printMenu() {
        System.out.println("Que quieres hacer:\n" +
                "1. Crear un producto.\n" +
                "2. Listar productos ordenados de menor a mayor precio.\n" +
                "3. Eliminar producto\n" +
                "4. Calcular fecha vencimiento de la garantía\n" +
                "5. Aplicar rebajas a productos\n" +
                "6. Productos en rebajas\n" +
                "7. Consultar stock de un producto\n" +
                "8. Aumentar stock de un producto\n" +
                "9. Quitar stock de un producto\n" +
                "0. Exit.");
    }

    public void crearProducte() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Crear un nuevo producto: ");
        System.out.println("Seleccione el tipo de producto que quiere crear: 1. Ropa, 2. Electrodomestico," +
                " 3. Componente electronico, 4. Belleza ");
        int tipoProducto = teclat.nextByte();
        teclat.nextLine();

        System.out.println("Nombre del producto: ");
        String nombre = teclat.nextLine();

        System.out.println("Marca del producto: ");
        String marca = teclat.nextLine();

        System.out.println("Precio del producto: ");
        double precio = teclat.nextDouble();

        System.out.println("Cantidad del stock: ");
        int stock = teclat.nextInt();
        teclat.nextLine();

        System.out.println("Data de compra (formato YYYY-MM-DD): ");
        LocalDate fechaCompra = LocalDate.parse(teclat.nextLine());

        System.out.println("Porcentaje de rebaja");
        double porcentajeRebaja = teclat.nextDouble();
        teclat.nextLine();

        Producto producto = null;

        switch (tipoProducto) {
            case 1:
                System.out.println("Talla del producto: ");
                String talla = teclat.nextLine();

                System.out.println("Tipo de tejido: ");
                String tipoTejido = teclat.nextLine();

                System.out.println("Tipo de prenda: ");
                String tipoPrenda = teclat.nextLine();

                producto = new Ropa(nombre, marca, precio,stock,fechaCompra, porcentajeRebaja, talla, tipoTejido,
                        tipoPrenda);

                productos.add(producto);
                break;
            case 2:
                System.out.println("Consumo energetico: ");
                String consumoEnergetico = teclat.nextLine();

                System.out.println("Fecha de fabricación: ");
                LocalDate fechaFabricacion = LocalDate.parse(teclat.nextLine());

                System.out.println("Capacidad: ");
                double capacidad = teclat.nextDouble();
                teclat.nextLine();

                producto = new Electrodomestico(nombre, marca, precio, stock, fechaCompra, porcentajeRebaja,
                        consumoEnergetico, fechaFabricacion, capacidad);

                productos.add(producto);
                break;
            case 3:
                System.out.println("Resolucion de imagen: ");
                String resolucionImagen = teclat.nextLine();

                System.out.println("Capacidad de la bateria: (MHA_2500, MHA_3000, MHA_4000)");
                String capacidadBateriaStr = teclat.nextLine();
                CapacidadBateria capacidadBateria = CapacidadBateria.valueOf(capacidadBateriaStr);

                producto = new ComponenteElectronico(nombre, marca, precio, stock, fechaCompra, porcentajeRebaja,
                        resolucionImagen, capacidadBateria);

                productos.add(producto);
                break;
            case 4:
                System.out.println("Es vegano? (true/false): ");
                boolean vegano = teclat.hasNextBoolean();
                teclat.nextLine();

                System.out.println("Temporada de uso: (PRIMAVERA, VERANO, OTONO, INVIERNO)");
                String temporadaUsoStr = teclat.nextLine();
                TemporadaUso temporadaUso = TemporadaUso.valueOf(temporadaUsoStr);

                producto = new Belleza(nombre, marca, precio, stock, fechaCompra, porcentajeRebaja,
                        vegano, temporadaUso);

                productos.add(producto);
                break;

            default:
                System.out.println("Tipo de producto no valido!");
                return;

        }

    }

    public List<Producto> listarProductoPorPecio() {
        List<Producto> productosOrdenados = new ArrayList<>(productos);
        productosOrdenados.sort(Comparator.comparingDouble(Producto::getPrecio));
        return productosOrdenados;
    }

    public void eliminarProducto (int codigoProducto) throws ProductoNoExisteException {
        productos.removeIf(producto -> producto.getCodigoProducto() == codigoProducto);
    }

    public int consultarStock (int codigoProducto) throws NoStcokException {
        int stock = 0;
        for (Producto producto : productos) {
            if(producto.getCodigoProducto() == codigoProducto) {
                stock = producto.getStock();
            }
        }
        return stock;
    }

    public List<Producto> listarProductosRebaja() {
        List<Producto> productosEnRebaja = new ArrayList<>();
        for (Producto producto : productos) {
            if(producto.getPorcentajeRebaja() > 0) {
                productosEnRebaja.add(producto);
            }
        }
        return productosEnRebaja;
    }

    public void aumentarStock(int codigoProducto, int cantidad) {
        for (Producto producto : productos) {
            if(producto.getCodigoProducto() == codigoProducto) {
                producto.setStock(producto.getStock() + cantidad);
                return;
            }
        }

    }

}
