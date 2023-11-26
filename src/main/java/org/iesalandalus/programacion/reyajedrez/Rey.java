package org.iesalandalus.programacion.reyajedrez;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    public Color getColor(){
        return color;
    }

    public Posicion getPosicion(){
        return posicion;
    }
/*
Crea los métodos get y set para cada atributo con la visibilidad adecuada. Los métodos set siempre comprobarán
la validez de los parámetros pasados y si no son correctos deberá lanzar la excepción adecuada con el mensaje adecuado.
Realiza un commit.
 */
    public void setColor(Color color){
        boolean valido = false;
        for(Color aux : Color.values())
        {
            if(color.equals(aux)) {
                this.color = color;
                valido = true;
            }
        }
        if(!valido){
            throw new IllegalArgumentException("El color del Rey no es válido");
        }
    }

    public void setPosicion(Posicion posicion){
        if((posicion.getFila() < 1) || (posicion.getFila() > 8)){
            throw new IndexOutOfBoundsException("La posición del Rey es incorrecta");
        }
        if(posicion.getColumna() > 0){
            throw new IndexOutOfBoundsException("La posición del Rey es incorrecta");
        }
        this.posicion = posicion;
    }
}
