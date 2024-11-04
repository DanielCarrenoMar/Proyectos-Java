package app.pila_6;

import app.pila_6.Exceptions.*;

public class Pila<T> {
    private final Integer max;
    private Integer amount;
    private final T[] list;
    
    public Pila(Integer max) throws PilaInvalidaException{
        if (max < 0) throw new PilaInvalidaException();
        this.max = max;
        amount = 0;
        list = (T[]) new Object[max];
    }
    
    public Boolean esVacia(){ return amount == 0;}
    
    public Boolean esLLena(){return amount.equals(max);}
    
    public void apilar(T obj) throws DesbordePilaException{
        if (esLLena()) throw new DesbordePilaException();
        
        list[amount] = obj;
        amount++;
    }
    
    public T desapilar() throws VaciaPilaexception{
        if (esVacia()) throw new VaciaPilaexception();

        amount--;
        return list[amount];
    }
    
    public void imprimir(){
        System.out.println();
        System.out.println("--- Pila ---");
        
        int i;
        for (i = 0; i<amount; i++){
            if (list[i] == null) continue;
            System.out.println(i+1+ ". " + list[i]);
        }
        if (i == 0) System.out.println("Pila vacia");
    }
    
    public Integer tamano(){ return amount;}

    public Pila<Object> mezclar(Pila pila) throws DesbordePilaException, VaciaPilaexception, PilaInvalidaException {
        Pila<Object> newPila = new Pila<>(amount+ pila.tamano());

        Pila<Object> auxPila1 = new Pila<>(amount);
        Pila<Object> auxPila2 = new Pila<>(pila.tamano());

        while(!esVacia()){
            auxPila1.apilar(desapilar());
        }

        while(!pila.esVacia()){
            auxPila2.apilar(pila.desapilar());
        }

        while(!auxPila1.esVacia() && !auxPila2.esVacia()){
            newPila.apilar(auxPila1.desapilar());
            newPila.apilar(auxPila2.desapilar());
        }

        while (!auxPila1.esVacia()){
            newPila.apilar(auxPila1.desapilar());
        }

        while (!auxPila2.esVacia()){
            newPila.apilar(auxPila2.desapilar());
        }
        
        return newPila;
    }
    
    
}
