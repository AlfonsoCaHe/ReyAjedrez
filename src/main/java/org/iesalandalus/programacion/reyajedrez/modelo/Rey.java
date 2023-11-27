package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    public Rey(){
        posicion = new Posicion(1, 'e');
        color = Color.BLANCO;
        totalMovimientos = 0;
    }

    public Rey(Color color){
        if(color == Color.BLANCO){
            posicion = new Posicion(1, 'e');
            this.color = Color.BLANCO;
        }
        if(color == Color.NEGRO){
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
            throw new NullPointerException("ERROR: La dirección no puede ser nula");
        }
        //Variable auxiliares
        int nuevaColumna = posicion.getColumna();
        int nuevaFila = posicion.getFila();
        char a;

        switch (direccion){
            case NOROESTE://Si nos movemos al noroeste subimos una fila y bajamos una columna
                nuevaFila += 1;
                nuevaColumna -= 1;
                if(nuevaColumna < 97){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if(nuevaFila > 8){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                totalMovimientos++;
                break;

            case NORESTE://Si nos movemos al noroeste subimos una fila y una columna
                nuevaFila += 1;
                nuevaColumna += 1;
                if(nuevaColumna > 104){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if(nuevaFila > 8){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                totalMovimientos++;
                break;

            case SURESTE://Si nos movemos al noroeste bajamos una fila y subimos una columna
                nuevaFila -= 1;
                nuevaColumna += 1;
                if(nuevaColumna > 104){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if(nuevaFila < 1){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                totalMovimientos++;
                break;

            case SUROESTE://Si nos movemos al noroeste bajamos una fila y una columna
                nuevaFila -= 1;
                nuevaColumna -= 1;
                if(nuevaColumna < 97){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if(nuevaFila < 1){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(nuevaFila, a);
                totalMovimientos++;
                break;

            case NORTE://Si nos movemos al norte subimos una fila
                nuevaFila += 1;
                if(nuevaFila > 8){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                posicion = new Posicion(nuevaFila, posicion.getColumna());
                totalMovimientos++;
                break;

            case SUR://Si nos movemos al sur bajamos una fila
                nuevaFila -= 1;
                if(nuevaFila < 1){//Si la fila sale del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                posicion = new Posicion(nuevaFila, posicion.getColumna());
                totalMovimientos++;
                break;

            case ESTE://Si nos movemos a este subimos una columna
                nuevaColumna += 1;
                if(nuevaColumna > 104){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(posicion.getFila(),a);
                totalMovimientos++;
                break;

            case OESTE://Si nos movemos a este bajamos una columna
                nuevaColumna -= 1;
                if(nuevaColumna < 97){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(posicion.getFila(),a);
                totalMovimientos++;
                break;

            case ENROQUE_CORTO://Un enroque corto sube dos columnas
                comprobarEnroque();//Comprobamos que el rey pueda llevar a cabo un enroque corto
                nuevaColumna += 2;
                if(nuevaColumna > 104){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if(color.equals(Color.NEGRO)){//Si es el rey negro
                    if(!posicion.equals(new Rey(Color.NEGRO).posicion)){//Si no está en su posición incial
                        throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                    }
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(posicion.getFila(),a);
                totalMovimientos++;
                break;
            case ENROQUE_LARGO://Un enroque largo baja dos columnas
                comprobarEnroque();//Comprobamos que el rey pueda llevar a cabo un enroque largo
                nuevaColumna -= 2;
                if(nuevaColumna < 97){//El rey se mueve fuera del tablero
                    throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                }
                if(color.equals(Color.BLANCO)){//Si es el rey blanco
                    if(!posicion.equals(new Rey(Color.BLANCO).posicion)){//Si no está en su posición inicial
                        throw new OperationNotSupportedException("ERROR: El Rey no puede salir del tablero");
                    }
                }
                a = Character.toString(nuevaColumna).charAt(0);
                posicion = new Posicion(posicion.getFila(),a);
                totalMovimientos++;
                break;
            default:
                throw new IllegalArgumentException("ERROR: No se ha introducido una dirección válida");
        }
    }

    private void comprobarEnroque() throws OperationNotSupportedException {//Comprueba que el rey pueda hacer un enroque
        if(totalMovimientos > 0){
            throw new OperationNotSupportedException("ERROR: el rey ya se ha movido, no puede hacer un enroque");
        }
        if(color == Color.BLANCO){//Comprobamos si el rey es blanco, en caso de ser así, debería estar en su posición inicial
            if((posicion.getFila() != 1) || (posicion.getColumna() != 'e')){//Si no está en su posición inicial (1e)
                throw new OperationNotSupportedException("ERROR: el rey BLANCO no está en la posición correcta");
            }
        }
        if(color == Color.NEGRO){//Comprobamos si el rey es blanco, en caso de ser así, debería estar en su posición inicial
            if((posicion.getFila() != 8) || (posicion.getColumna() != 'e')){//Si no está en su posición inicial (8e)
                throw new OperationNotSupportedException("ERROR: el rey NEGRO no está en la posición correcta");
            }
        }
    }

    @Override
    public String toString(){
        return "color="+color.toString() +", posicion=(fila=" + posicion.getFila() +", columna="+ posicion.getColumna()+")";
    }
}
