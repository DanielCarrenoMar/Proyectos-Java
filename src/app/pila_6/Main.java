package app.pila_6;

import app.pila_6.Exceptions.*;

public class Main {

    public static void main(String[] args) {
        try{
            Libro libro = new Libro("Principito", "Nose");
            Libro libro2 = new Libro("Divina Comedia", "Nose");
            Libro libro3 = new Libro("Libro3", "Nose");
            Libro libro4 = new Libro("Libro4", "Nose");
            Libro libro5 = new Libro("Libro5", "Nose");
            Carta carta  = new Carta(12, Carta.Color.NEGRO, Carta.Pinta.DIAMANTE);
            Carta carta2  = new Carta(11, Carta.Color.ROJO, Carta.Pinta.CORAZON);
            Carta carta3  = new Carta(1, Carta.Color.ROJO, Carta.Pinta.DIAMANTE);

            Pila<Libro> pilaLibro = new Pila<>(10);
            Pila<Carta> pilaCarta = new Pila<>(8);

            pilaCarta.apilar(carta);
            pilaCarta.apilar(carta2);
            pilaCarta.apilar(carta3);
            pilaLibro.apilar(libro);
            pilaLibro.apilar(libro2);
            pilaLibro.apilar(libro3);
            pilaLibro.apilar(libro4);
            pilaLibro.apilar(libro5);

            pilaLibro.imprimir();
            pilaCarta.imprimir();

            System.out.println();
            System.out.println("Desapilar dos libros");

            pilaLibro.desapilar();
            pilaLibro.desapilar();

            pilaLibro.imprimir();

            System.out.println();
            System.out.println("Apilar dos libros");

            pilaLibro.apilar(libro4);
            pilaLibro.apilar(libro5);

            System.out.println("Mezclar");
            
            Pila<Object> pilaMezcla = pilaLibro.mezclar(pilaCarta);
            pilaMezcla.imprimir();
            
        }catch(DesbordePilaException | VaciaPilaexception | CartaInvalidaException | PilaInvalidaException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
