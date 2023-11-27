package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    private static Rey rey;
    public static void main(String[] args) throws OperationNotSupportedException {
        int opcion;
        do{
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
            System.out.println("*****************************************");
        }while(opcion != 4);//Aunque salga se ejecutará la opción para mostrar el mensaje de despedida, pero ya no continuará
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
                try{
                    mover();
                }catch (OperationNotSupportedException oe){
                    System.out.println("ERROR: el movimiento ha sido incorrecto.");
                }catch (IllegalArgumentException ie){
                    System.out.println("ERROR: la posición no es posible. FUERA DE RANGO");
                }
                break;
            case 4:
                Consola.despedirse();//Nos despediremos al salir
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
                System.out.println("*****************************************");
                mostrarRey();
                if(rey != null){//Si el rey no se ha creado, este no se puede mover
                    System.out.println("¿En qué dirección desea desplazar el rey?");
                    Direccion direccion = Consola.elegirDireccion();
                    rey.mover(direccion);
                }
                desplazado = true;
            }catch (OperationNotSupportedException oe){
                System.out.println("ERROR: El rey no se puede mover en esa dirección.");
            }
        }while (!desplazado);
    }

    private static void mostrarRey() throws NullPointerException {
        if(rey != null){
            System.out.println(rey.toString());
        }else{
            throw new NullPointerException("ERROR: No se ha creado el rey.");
        }
    }

}
