package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    public Rey(){
        posicion = new Posicion(1, 'e');
        totalMovimientos = 0;
    }

    public Rey(Color color){
        if(color.toString().equals(Color.BLANCO.toString())){
            posicion = new Posicion(1, 'e');
            this.color = Color.BLANCO;
        }
        if(color.toString().equals(Color.NEGRO.toString())){
            posicion = new Posicion(8,'e');
            this.color = Color.NEGRO;
        }
        totalMovimientos = 0;
    }
    public Color getColor(){
        return color;
    }

    public Posicion getPosicion(){
        return posicion;
    }

    private void setColor(Color color){
        boolean valido = false;
        for(Color aux : Color.values())
        {
            if(color.equals(aux)) {
                this.color = color;
                valido = true;
            }
        }
        if(!valido){
            throw new IllegalArgumentException("ERROR: El color del Rey no es válido");
        }
    }

    private void setPosicion(Posicion posicion){
        if((posicion.getFila() < 1) || (posicion.getFila() > 8)){
            throw new IndexOutOfBoundsException("ERROR: La posición del Rey es incorrecta");
        }
        if(posicion.getColumna() > 0){
            throw new IndexOutOfBoundsException("ERROR: La posición del Rey es incorrecta");
        }
        this.posicion = posicion;
    }

    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if(direccion == null){//Si la direccion es nula
            throw new NullPointerException("ERROR: La posición del Rey no puede ser nula");
        }
        //Variable auxiliares
        int nuevaColumna = posicion.getColumna();
        int nuevaFila = posicion.getFila();
        char a;

        switch (direccion.toString()){
            case "Noroeste"://Si nos movemos al noroeste subimos una fila y bajamos una columna
                nuevaFila += 1;
                nuevaColumna -= 1;
                if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if((nuevaFila < 0) || (nuevaFila > 8)){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                break;

            case "Noreste"://Si nos movemos al noroeste subimos una fila y una columna
                nuevaFila += 1;
                nuevaColumna += 1;
                if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if((nuevaFila < 0) || (nuevaFila > 8)){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                break;

            case "Sureste"://Si nos movemos al noroeste bajamos una fila y subimos una columna
                nuevaFila -= 1;
                nuevaColumna += 1;
                if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if((nuevaFila < 0) || (nuevaFila > 8)){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                break;

            case "Suroeste"://Si nos movemos al noroeste bajamos una fila y una columna
                nuevaFila -= 1;
                nuevaColumna -= 1;
                if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if((nuevaFila < 0) || (nuevaFila > 8)){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                break;

            case "Norte"://Si nos movemos al norte subimos una fila
                nuevaFila += 1;
                if((nuevaFila < 0) || (nuevaFila > 8)){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                posicion = new Posicion(nuevaFila, posicion.getColumna());
                break;

            case "Sur"://Si nos movemos al sur bajamos una fila
                nuevaFila -= 1;
                if((nuevaFila < 0) || (nuevaFila > 8)){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                posicion = new Posicion(nuevaFila, posicion.getColumna());
                break;

            case "Este"://Si nos movemos a este subimos una columna
                nuevaColumna += 1;
                if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(posicion.getFila(),a);
                break;

            case "Oeste"://Si nos movemos a este bajamos una columna
                nuevaColumna -= 1;
                if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(posicion.getFila(),a);
                break;

            case "Enroque corto"://Un enroque corto sube dos columnas
                if(totalMovimientos == 0){//Para que el rey pueda hacer un enroque, debe no haberse desplazado ninguna casilla
                    nuevaColumna += 2;
                    if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                        throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                    }
                    if(color.equals(Color.NEGRO)){//Si es el rey negro
                        if(!posicion.equals(new Rey(Color.NEGRO).posicion)){//Si no está en su posición incial
                            throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                        }
                    }
                    a = Character.toString(nuevaColumna).charAt(0);
                    posicion = new Posicion(posicion.getFila(),a);
                }

                break;
            case "Enroque largo"://Un enroque largo baja dos columnas
                if(totalMovimientos == 0){//Para que el rey pueda hacer un enroque, debe no haberse desplazado ninguna casilla
                    nuevaColumna -= 2;
                    if((nuevaColumna < 97) || (nuevaColumna > 104)){//El rey se mueve fuera del tablero
                        throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                    }
                    if(color.equals(Color.BLANCO)){//Si es el rey blanco
                        if(!posicion.equals(new Rey(Color.BLANCO).posicion)){//Si no está en su posición inicial
                            throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                        }
                    }
                    a = Character.toString(nuevaColumna).charAt(0);
                    posicion = new Posicion(posicion.getFila(),a);
                }
                break;
            default:
                throw new IllegalArgumentException("ERROR: No se ha introducido una dirección válida");
        }
    }

    @Override
    public String toString(){
        return "Rey "+color.toString() +" en " + posicion.getFila() + posicion.getColumna();
    }
}
