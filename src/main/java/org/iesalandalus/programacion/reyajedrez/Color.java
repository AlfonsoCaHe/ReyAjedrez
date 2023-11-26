package org.iesalandalus.programacion.reyajedrez;

public enum Color {
    BLANCO("BLANCO"),
    NEGRO("NEGRO");

    private String cadenaAMostrar;

    private Color(String cadenaAMostrar){
        this.cadenaAMostrar=cadenaAMostrar;
    }

    public String toString(){
        return cadenaAMostrar;
    }
}
