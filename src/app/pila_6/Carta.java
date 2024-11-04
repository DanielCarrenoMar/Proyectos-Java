package app.pila_6;

import app.pila_6.Exceptions.CartaInvalidaException;

public class Carta {
    public enum Pinta {TREBOL, PICA, CORAZON, DIAMANTE};
    public enum Color {ROJO, NEGRO};
    private Pinta pinta;
    private Color color;
    private Integer numero;
    
    public Carta(Integer numero, Color color, Pinta pinta ) throws CartaInvalidaException{
        if (numero < 1 || numero > 12) throw new CartaInvalidaException();
        this.numero = numero;
        this.color = color;
        this.pinta = pinta;
    }

    @Override
    public String toString() {
        return "Carta Numero: " + numero + " | " + "Color: " + color + " | " + "Pinta: " + pinta;
    }
    
    
    
}
