package app.piscina_4.myExceptions;

public class PiscinaVaciadaException extends Exception{
    public PiscinaVaciadaException(){
        super("No hay sufiente agua para vaciar");
    }
}
