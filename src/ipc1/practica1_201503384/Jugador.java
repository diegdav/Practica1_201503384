/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica1_201503384;

/**
 *
 * @author diego
 */
public class Jugador {
    
    private int numero_jugador;
    private char simbolo;

    public Jugador() {
        numero_jugador = 0;
        simbolo = ' ';
    }
    
    /**
     * @return the numero_jugador
     */
    public int getNumero_jugador() {
        return numero_jugador;
    }

    /**
     * @param numero_jugador the numero_jugador to set
     */
    public void setNumero_jugador(int numero_jugador) {
        this.numero_jugador = numero_jugador;
    }

    /**
     * @return the simbolo
     */
    public char getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
}
