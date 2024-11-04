package app.vector_5.main;

import app.vector_5.myExceptions.DimensionExceptions;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vector> vectores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Crear vector");
                System.out.println("2. Operar vectores");
                System.out.println("3. Salir");
                int option = pedirInt(scanner);

                switch (option) {
                    case 1:
                        createVector(scanner, vectores);
                        break;
                    case 2:
                        operateVectores(scanner, vectores);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opcion invalida");
                }

            }catch (IndexOutOfBoundsException e) {
                System.out.println("Error al seleccionar vector: índice fuera de rango");
            } catch (IllegalArgumentException e) {
                System.out.println("Error al crear vector: dimensión no válida");
            }
        }
        }

    public static void createVector(Scanner scanner, ArrayList<Vector> vectores) {
        System.out.println("Ingrese la dimension del vector:");
        int dimension = pedirInt(scanner);
        Vector vector = new Vector(dimension);

        for (int i = 0; i < dimension; i++) {
            System.out.println("Ingrese el valor de la componente " + i + ":");
            int valor = pedirInt(scanner);
            vector.cambiaComponente(i, valor);
        }

        vectores.add(vector);
        System.out.println("Vector creado y añadido a la lista.");
    }

    public static void operateVectores(Scanner scanner, ArrayList<Vector> vectores) {
        if (vectores.size() < 2) {
            System.out.println("No hay suficientes vectores para operar.");
            return;
        }

        System.out.println("Seleccione el primer vector (indice):");
        for (int i = 0; i < vectores.size(); i++) {
            System.out.print(i + ": "); vectores.get(i).printComponentes();
        }
        int indice1 = pedirInt(scanner);

        System.out.println("Seleccione el segundo vector (indice):");
        for (int i = 0; i < vectores.size(); i++) {
            System.out.print(i + ": "); vectores.get(i).printComponentes();
        }

        int indice2 = pedirInt(scanner);

        try {
            Vector v1 = vectores.get(indice1);
            Vector v2 = vectores.get(indice2);

            System.out.println("Operaciones disponibles:");
            System.out.println("1. Acumular");
            System.out.println("2. Sumar");
            int operacion = pedirInt(scanner);

            switch (operacion) {
                case 1:
                    v1.acumula(v2);
                    System.out.println("Resultado de acumular:");
                    v1.printComponentes();
                    break;
                case 2:
                    Vector resultado = v1.suma(v2);
                    System.out.println("Resultado de sumar:");
                    resultado.printComponentes();
                    break;
                default:
                    System.out.println("Operacion invalida");
            }
        } catch (DimensionExceptions e) {
            System.out.println("Error al operar vectores: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error al seleccionar vector: índice fuera de rango");
        }
    }

    public static Integer pedirInt(Scanner scanner){
        while (true){
            try{
                String num = scanner.next();
                return Integer.parseInt(num);
            }catch(NumberFormatException e){
                System.out.println("Opccion invalida");
            }
        }
    }
}
