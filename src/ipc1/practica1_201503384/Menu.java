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
    Tablero tablero = new Tablero();
    Jugador[] jugador;
    int contador_simbolo;

    public Menu() {
        contador_simbolo = 1;
    }

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
                    menuPrincipal();
                    break;
                case 3:
                    if (dificultad.getDificultad() == null) {
                        System.out.println("\nDebe de seleccionar primer la dificultad.\n");
                        menuPrincipal();
                    } else {
                        tablero.crearFacil();
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
                    dificultad.setDificultad("Facil");
                    System.out.println("");
                    menuPrincipal();
                    break;
                case 2:
                    dificultad.setDificultad("Dificil");
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
        int opcion;

        do {
            System.out.println("\nSeleccione una opcion \n1. Jugadores \n2. Subidas y bajones \n3.Regresar");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    crearJugadores(dificultad.getDificultad());
                    break;
                case 2:
                    crearSubidasBajones(dificultad.getDificultad());
                    menuParametros();
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

    public void crearJugadores(String dificultad) {
        int cant_jugadores;

        if (dificultad.equals("Facil")) {
            do {
                System.out.print("\nDificultad: " + dificultad);
                System.out.print("\nIngrese la cantidad de jugadores (De 2 a 3): ");
                parametros.setCantJugadores(cant_jugadores = teclado.nextInt());
            } while (parametros.getCantJugadores() < 2 || parametros.getCantJugadores() > 3);
        } else {
            do {
                System.out.print("\nDificultad: " + dificultad);
                System.out.print("\nIngrese la cantidad de jugadores (De 2 a 4): ");
                parametros.setCantJugadores(cant_jugadores = teclado.nextInt());
            } while (parametros.getCantJugadores() < 2 || parametros.getCantJugadores() > 4);
        }

        jugador = new Jugador[cant_jugadores];
        crearSimbolo();
    }

    public void crearSimbolo() {
        char simbolo;
        int i, j;

        for (i = 0; i < jugador.length; i++) {
            if (jugador[i] == null) {
                jugador[i] = new Jugador();
            }
        }

        for (i = 0; i < jugador.length; i++) {
            System.out.print("Ingrese el simbolo que representa al jugador " + contador_simbolo + ": ");
            simbolo = teclado.next().charAt(0);

            if (contador_simbolo == 1) {
                jugador[contador_simbolo - 1].setNumero_jugador(contador_simbolo);
                jugador[contador_simbolo - 1].setSimbolo(simbolo);
                contador_simbolo++;
            } else {
                for (j = 0; j < i; j++) {
                    if (simbolo == jugador[j].getSimbolo()) {
                        System.out.print("\nEste simbolo ya esta siendo utilizado por otro jugador. Ingrese otro.");
                        System.out.println("");
                        crearSimbolo();
                    } else {
                        jugador[contador_simbolo - 1].setNumero_jugador(contador_simbolo);
                        jugador[contador_simbolo - 1].setSimbolo(simbolo);
                        contador_simbolo++;
                        break;
                    }
                }
            }
        }
        contador_simbolo = 1;
        menuParametros();
    }

    public void crearSubidasBajones(String dificultad) {
        int cant_subidas, cant_bajones;

        if (dificultad.equals("Facil")) {
            do {
                System.out.print("\nDificultad: " + dificultad);
                System.out.print("\nIngrese la cantidad de subidas (De 5 a 10): ");
                parametros.setSubidas(cant_subidas = teclado.nextInt());
            } while (cant_subidas < 5 || cant_subidas > 10);
        } else {
            do {
                System.out.print("\nDificultad: " + dificultad);
                System.out.print("\nIngrese la cantidad de subidas (De 20 a 40): ");
                parametros.setBajones(cant_bajones = teclado.nextInt());
            } while (cant_bajones < 20 || cant_bajones > 40);
        }
    }
}
