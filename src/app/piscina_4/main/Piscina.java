package app.piscina_4.main;

import app.piscina_4.myExceptions.PiscinaVaciadaException;
import java.security.InvalidParameterException;
import app.piscina_4.myExceptions.DesbordePiscinaException;

public class Piscina{
    private int nivel = 0; 
    public final int MAX_NIVEL;

    public Piscina(int max){
        if (max<=0) throw new IllegalArgumentException();
        MAX_NIVEL=max;
    }

    public int getNivel(){
        return nivel;
    }

    public void vaciar(int cantidad) throws PiscinaVaciadaException {
        if (cantidad < 0) throw new InvalidParameterException();
        nivel=nivel-cantidad;
        if (nivel < 0) throw new PiscinaVaciadaException();
    }

    public void llenar(int cantidad)throws DesbordePiscinaException {
        if (cantidad < 0) throw new InvalidParameterException();
        nivel=nivel+cantidad;
        if (nivel > MAX_NIVEL) throw new DesbordePiscinaException();
    }
}
