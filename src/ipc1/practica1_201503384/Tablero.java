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
public class Tablero {

    private char[][] facil = new char[5][8];
    private char[][] dificil = new char[41][21];

    public void crearFacil() {
        int x, y, lineas_fila;

        for (x = 0; x < 5; x++) {
            for (y = 0; y < 8; y++) {

                facil[x][y] = ' ';
                System.out.print("|");
                System.out.print("_" + facil[x][y] + "_");

            }
            System.out.println("|");
        }
    }

    /**
     * @return the facil
     */
    public char[][] getFacil() {
        return facil;
    }

    /**
     * @param facil the facil to set
     */
    public void setFacil(char[][] facil) {
        this.facil = facil;
    }

    /**
     * @return the dificil
     */
    public char[][] getDificil() {
        return dificil;
    }

    /**
     * @param dificil the dificil to set
     */
    public void setDificil(char[][] dificil) {
        this.dificil = dificil;
    }

}
