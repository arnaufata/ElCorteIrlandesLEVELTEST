package Excepcions;

public class ProductoNoExisteException extends Exception {

    public ProductoNoExisteException() {
        super("El producto que quiere eliminar no existe en nuestro stock.");
    }
}
