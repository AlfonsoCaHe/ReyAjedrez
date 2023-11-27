package org.iesalandalus.programacion.reyajedrez.modelo;

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

    private void setFila(int fila){
        if((fila < 1) || (fila > 8)){
            throw new IllegalArgumentException("ERROR: Fila no válida");
        }
        this.fila = fila;
    }

    private void setColumna(char columna){
        if(columna > 'h'){
            throw new IllegalArgumentException("ERROR: Columna no válida");
        }
        this.columna = columna;
    }

    public Posicion(int fila, char columna) throws IllegalArgumentException{
        try{
            setFila(fila);
            setColumna(columna);
        }catch(IllegalArgumentException ie){
            throw new IllegalArgumentException("ERROR: Fila no válida");
        }
    }

    public Posicion(Posicion p){
        if(p == null){
            throw new NullPointerException("ERROR: La posición no es válida");
        }
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

    @Override
    public String toString(){
        return "fila=" + fila +", columna="+ columna;
    }
}
