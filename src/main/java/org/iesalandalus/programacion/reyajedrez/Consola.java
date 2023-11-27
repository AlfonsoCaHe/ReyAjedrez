package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.reyajedrez.modelo.Color;

public class Consola {
    private Consola(){

    }

    public static void mostrarMenu(){
        System.out.println("Opciones:");
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

}
