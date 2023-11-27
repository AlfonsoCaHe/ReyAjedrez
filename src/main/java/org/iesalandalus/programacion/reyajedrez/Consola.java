package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.reyajedrez.modelo.Color;

import javax.naming.OperationNotSupportedException;

public class Consola {
    private Consola(){

    }

    public static void mostrarMenu(){
        System.out.println("1.Crear rey por defecto.");
        System.out.println("2.Crear rey eligiendo color.");
        System.out.println("3.Mover.");
        System.out.println("4.Salir.");
    }

    public static int elegirOpcionMenu(){
        int opcion;
        do{
            mostrarMenu();
            System.out.println("Escoja una opción:");
            opcion = Entrada.entero();
        }while((opcion < 1) || (opcion > 4));//Las opciones van del 1 al 4
        return opcion;
    }

    public static Color elegirOpcion(){
        int opcion;
        do{
            System.out.println("Escoja un color: (1.BLANCO o 2.NEGRO)");
            opcion = Entrada.entero();
        }while ((opcion < 1) || (opcion > 2));
        if(opcion == 1){
            return Color.BLANCO;
        }
        return Color.NEGRO;
    }

    public static void mostrarMenuDirecciones(){
        System.out.println("7.Noroeste\t8.Norte\t9.Noreste");
        System.out.println("4.Oeste\t\t\t\t6.Este");
        System.out.println("1.Suroeste\t2.Sur\t3.Sureste");
        System.out.println("\n10.Enroque largo\t11.Enroque corto");
    }

    public static Direccion elegirDireccion(){
        int opcion;
        do{
            mostrarMenuDirecciones();
            opcion = Entrada.entero();
        }while((opcion < 1) || (opcion == 5) || (opcion > 11));
        Direccion direccion = Direccion.SURESTE;
        switch (opcion){
            case 7://Escogemos Noroeste
                direccion = Direccion.NOROESTE;
                break;

            case 8://Escogemos Norte
                direccion = Direccion.NORTE;
                break;

            case 9://Escogemos Noreste
                direccion = Direccion.NORESTE;
                break;

            case 4://Escogemos Oeste
                direccion = Direccion.OESTE;
                break;

            case 6://Escogemos Este
                direccion = Direccion.ESTE;
                break;

            case 1://Escogemos Suroeste
                direccion = Direccion.SUROESTE;
                break;

            case 2://Escogemos Sur
                direccion = Direccion.SUR;
                break;

            case 3://Escogemos Sureste
                direccion = Direccion.SURESTE;
                break;

            case 10://Escogemos enroque largo
                direccion = Direccion.ENROQUE_LARGO;
                break;
            case 11://Escogemos enroque corto
                direccion = Direccion.ENROQUE_CORTO;
                break;
        }
        return direccion;
    }

    public static void despedirse(){
        System.out.println("Muchas gracias por jugar.\n¡Nos vemos en la próxima partida!");
    }
}
