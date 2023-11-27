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
                Direccion direccion = Consola.elegirDireccion();
                rey.mover(direccion);
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


}
