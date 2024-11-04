package app.pila_6.Exceptions;

public class DesbordePilaException extends Exception{
    public DesbordePilaException(){
        super("La pila esta llena");
    }
}
