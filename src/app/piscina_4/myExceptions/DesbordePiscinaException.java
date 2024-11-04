package app.piscina_4.myExceptions;

public class DesbordePiscinaException extends Exception{
    public DesbordePiscinaException(){
        super("Se ha desbordado la piscina");
    }
}
