package app.vector_5.main;

import app.vector_5.myExceptions.DimensionExceptions;

public class Vector {
    private int[] componentes;
    private int dimension;

    /** Constructor que crea un vector de la dimensión indicada, inicialmente con todas sus
        componentes a cero.*
    * @param dimension
    * El número de componentes del vector 
    */
    public Vector(int dimension) {
        if (dimension <= 0) throw new IllegalArgumentException();
        componentes = new int[dimension];
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    /** Este método cambia la componente i-ésima del vector por el valor pasado * como
        argumento.
    * @param pos
    * El índice de la posición cuyo valor se va a cambiar.
    * @param valor
    * El nuevo valor que le damos a la componente i-ésima del * vector.
    */
    public void cambiaComponente(int pos, int valor) {
        if (pos < 0 || pos >= dimension) throw new IndexOutOfBoundsException();
        componentes[pos] = valor;
    }
    
    public Integer getComponente(int pos) {
        if (pos < 0 || pos >= dimension) throw new IndexOutOfBoundsException();
        return componentes[pos];
    }
    
    public void printComponentes(){
        System.out.print("(");
        for (int i = 0; i < dimension; i++){
            System.out.print(componentes[i]+",");
        }
        System.out.print(")");
        System.out.println();
    }
    
    public void acumula(Vector vector) throws DimensionExceptions {
        if (vector.getDimension() != dimension) throw new DimensionExceptions();
        
        for (int i = 0; i < dimension; i++){
            componentes[i] += vector.getComponente(i);
        }
    }
    
    public Vector suma(Vector vector){
        Vector newVector = new Vector(dimension);
        try{
            newVector.acumula(this);
            newVector.acumula(vector);
        } catch (DimensionExceptions e){
            System.out.println("Error en la suma de vectores: " + e.getMessage());
        }
        return newVector;
    }
} 