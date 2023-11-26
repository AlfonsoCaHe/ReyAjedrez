package org.iesalandalus.programacion.reyajedrez;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    public Rey(){
        posicion = new Posicion(1, 'e');
    }

    public Rey(Color color){
        if(color.toString().equals(Color.BLANCO.toString())){
            posicion = new Posicion(1, 'e');
        }
        if(color.toString().equals(Color.NEGRO.toString())){
            posicion = new Posicion(8,'e');
        }
    }
    public Color getColor(){
        return color;
    }

    public Posicion getPosicion(){
        return posicion;
    }

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
