package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    private static Rey rey;
    public static void main(String[] args) {

    }

    private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
        switch (opcion){
            case 1:
                crearReyDefecto();
                break;
            case 2:
                Color color = Consola.elegirOpcion();//Elegimos un color
                crearReyColor(color);
                break;
            case 3:
                mover();
                break;
            case 4:
                Consola.despedirse();
        }
    }

    private static void crearReyDefecto(){
        rey = new Rey();
    }

    private static void crearReyColor(Color color){
        rey = new Rey(color);
    }

    private static void mover() throws OperationNotSupportedException {
        boolean desplazado = false;
        do{
            try{
                System.out.println("¿En qué dirección desea desplazar el rey?");
                Consola.mostrarMenuDirecciones();
                Direccion direccion = Consola.elegirDireccion();
                rey.mover(direccion);
                desplazado = true;
            }catch (OperationNotSupportedException oe){
                System.out.println("ERROR: El rey no se puede mover en esa dirección.");
            }
        }while (!desplazado);

    }

}
