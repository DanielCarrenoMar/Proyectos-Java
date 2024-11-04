package app.pila_6;

public class Libro {
    private String autor;
    private String titulo;
    
    public Libro(String titulo, String autor){
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro Titulo: " + titulo + " | Autor:" + autor;
    }
    
    
}
