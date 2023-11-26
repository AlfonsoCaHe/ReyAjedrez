package org.iesalandalus.programacion.reyajedrez;

public enum Direccion {
    NORTE("NORTE"),
    NORESTE("NORESTE"),
    ESTE("ESTE"),
    SURESTE("SURESTE"),
    SUR("SUR"),
    SUROESTE("SUROESTE"),
    OESTE("OESTE"),
    NOROESTE("NOROESTE"),
    ENROQUE_CORTO("ENROQUE_CORTO"),
    ENROQUE_LARGO("ENROQUE_LARGO");

    private String direccion;
    private Direccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

}
