package app.piscina_4.main;

import app.piscina_4.myExceptions.DesbordePiscinaException;
import app.piscina_4.myExceptions.PiscinaVaciadaException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese borde maximo de la pisina");
        Integer maximo = pedirInt(scanner);
        
        Piscina piscina;
        
        try{
            piscina = new Piscina(maximo);
            
            while(true){
                System.out.println("PISCINA " + piscina.getNivel() + "/" + maximo);
                System.out.println("1. Llenar piscina");
                System.out.println("2. Vaciar piscina");
                
                Integer op = pedirInt(scanner);
                switch(op){
                    case 1:
                        System.out.println("Ingresar cantidad a llenar");
                        piscina.llenar(pedirInt(scanner));
                        break;
                    case 2:
                        System.out.println("Ingresar cantidad a vaciar");
                        piscina.vaciar(pedirInt(scanner));
                        break;
                    default:
                        System.out.println("Ingrese opccion valida");
                        break;
                }
                
            }
        
        }catch(IllegalArgumentException e){
            System.out.println("Error, parametro de piscina invalido");
        }catch(DesbordePiscinaException e){
            System.out.println("Error al llenar piscina " + e.getMessage());
        }catch(PiscinaVaciadaException e){
            System.out.println("Error al vaciar piscina " + e.getMessage());
        }
    }
    
    public static Integer pedirInt(Scanner scanner){
        while (true){
            try{
                String num = scanner.next();
                return Integer.parseInt(num);
            }catch(NumberFormatException e){
                System.out.println("Ingrese opccion valida");
            }
        }
    }
    
}
