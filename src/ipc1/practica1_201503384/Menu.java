/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica1_201503384;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Menu {

    Scanner teclado = new Scanner(System.in);

    Dificultad dificultad = new Dificultad();
    Parametros parametros = new Parametros();

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("1. Dificultad del juego \n2. Parametros iniciales \n3. Iniciar juego \n4. Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    menuDificultad();
                    break;
                case 2:
                    menuParametros();
                    break;
                case 3:
                    if (dificultad.getDificultad() == null) {
                        System.out.println("\nDebe de seleccionar primer la dificultad.\n");
                        menuPrincipal();
                    } else {
                        System.out.println("Inicia el juego");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("\nOpcion incorrecta, vuelva a intentarlo.");
            }
        } while (opcion < 0 || opcion > 4);
    }

    public void menuDificultad() {
        int opcion;
        do {
            System.out.println("\nSeleccione la dificultad del juego \n1. Facil \n2. Dificil \n3.Regresar");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    dificultad.setDificultad("facil");
                    System.out.println("");
                    menuPrincipal();
                    break;
                case 2:
                    dificultad.setDificultad("dificil");
                    System.out.println("");
                    menuPrincipal();
                    break;
                case 3:
                    menuPrincipal();
                    System.out.println("");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Vuelva a intentarlo.");
            }
        } while (opcion < 1 || opcion > 3);
    }

    public void menuParametros() {
        int opcion, jugadores, subidas, bajones;
        do {
            System.out.println("\nSeleccione una opcion \n1. Jugadores \n2. Subidas y bajones \n3.Regresar");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    if (dificultad.getDificultad().equals("facil")) {
                        do{
                            System.out.print("\nDificultad: " + dificultad.getDificultad());
                            System.out.print("\nIngrese la cantidad de jugadores (De 2 a 3): ");
                            parametros.setJugadores(jugadores = teclado.nextInt());
                        } while (parametros.getJugadores() < 2 || parametros.getJugadores() > 3);
                    } else {
                        do{
                            System.out.print("\nDificultad: " + dificultad.getDificultad());
                            System.out.print("\nIngrese la cantidad de jugadores (De 2 a 4): ");
                            parametros.setJugadores(jugadores = teclado.nextInt());
                        } while (parametros.getJugadores() < 2 || parametros.getJugadores() > 4);
                    }
                    break;
                case 2:
                    dificultad.setDificultad("dificil");
                    System.out.println("");
                    menuPrincipal();
                    break;
                case 3:
                    menuPrincipal();
                    System.out.println("");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Vuelva a intentarlo.");
            }
        } while (opcion < 1 || opcion > 3);
    }
}
