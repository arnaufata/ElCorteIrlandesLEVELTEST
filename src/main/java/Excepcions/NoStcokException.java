package Excepcions;

public class NoStcokException extends Exception{
    public NoStcokException() {
        super("Actualment no tenemos stock de este producto.");
    }
}
