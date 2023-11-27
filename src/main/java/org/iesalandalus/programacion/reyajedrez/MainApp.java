package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Rey;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
    private static Rey rey;
    public static void main(String[] args) {

    }

    private static void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1:
                crearReyDefecto();
                break;
            case 2:
                crearReyColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                Consola.despedirse();
        }
    }
}
