package app.vector_5.myExceptions;

public class DimensionExceptions extends Exception{
    public DimensionExceptions(){
        super("Los vectores tiene diferentes dimensiones");
    }
}
