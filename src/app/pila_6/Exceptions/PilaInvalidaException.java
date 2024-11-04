package app.pila_6.Exceptions;

public class PilaInvalidaException extends Exception{
    public PilaInvalidaException(){
        super("Maximo de pila invalido");
    }
}
