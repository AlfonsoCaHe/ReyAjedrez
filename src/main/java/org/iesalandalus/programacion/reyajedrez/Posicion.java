package org.iesalandalus.programacion.reyajedrez;

import java.lang.IllegalArgumentException;
import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public int getFila(){
        return fila;
    }

    public char getColumna(){
        return columna;
    }

    public void setFila(int fila){
        if((fila < 1) || (fila > 8)){
            throw new IllegalArgumentException("La posición del Rey es incorrecta");
        }
        this.fila = fila;
    }

    public void setColumna(char columna){
        if(columna > 'h'){
            throw new IllegalArgumentException("La posición del Rey es incorrecta");
        }
        this.columna = columna;
    }

    public Posicion(int fila, char columna){
        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion p){
        fila = p.getFila();
        columna = p.getColumna();
    }

    public boolean equals(Posicion p1){
        if(fila != p1.getFila()){
            return false;
        }else if(columna != p1.getColumna()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(fila);
    }
}
