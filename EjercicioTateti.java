package ejercicios;
/* TRABAJO PARA ENTREGAR EN GIT
 * TATETI:
 * Se tiene Un tablero de 3 x 3 matriz [fila][columna]
 * Dos jugadores que ingresan las coordenadas de cada ficha por teclado
 * Una vez que tengo fila y columna de la ficha, muestro el tablero con X o 0
 * Verificar si es posible la posicion de la ficha y ver si hay ganador
 * Mientras no haya ganador continua el siguiente jugador
 * 
 *      |     |
 * ---|---|---         fila columna
 *      |   | X  -> tablero[1][2]
 * ---|---|----
 *    |   |
 *    
 *    
 *    */

import java.util.Scanner;

public class EjercicioTateti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int filas = 3;
		final int columnas = 3;

		int movimiento;
		boolean jugar = true;

		Scanner sc = new Scanner(System.in);

		char tablero[][] = new char[filas][columnas];

		tablero[0][0] = '1';
		tablero[0][1] = '2';
		tablero[0][2] = '3';
		tablero[1][0] = '4';
		tablero[1][1] = '5';
		tablero[1][2] = '6';
		tablero[2][0] = '7';
		tablero[2][1] = '8';
		tablero[2][2] = '9';

		imprimirTablero(tablero);

		System.out.println();

		while (jugar) {

			// Movimiento jugador 1
			System.out.println("Ingresa tu movimiento del 1 al 9");
			movimiento = sc.nextInt();
			ubicarMovimiento(tablero, movimiento, "jugador1", sc);
			imprimirTablero(tablero);
			jugar = ganador(tablero, jugar);

			// Movimiento jugador 2
			System.out.println("Ingresa tu movimiento del 1 al 9");
			movimiento = sc.nextInt();
			ubicarMovimiento(tablero, movimiento, "jugador2", sc);
			imprimirTablero(tablero);
			jugar = ganador(tablero, jugar);
		}
	}

	public static boolean ganador(char[][] tablero, boolean jugar) {

		if ((tablero[0][0] == 'X') && (tablero[0][1] == 'X') && (tablero[0][2] == 'X')) {
			System.out.println("Gano el jugador 1 en la primera linea horizontal");
			jugar = false;
		}
		if ((tablero[0][0] == 'O') && (tablero[0][1] == 'O') && (tablero[0][2] == 'O')) {
			System.out.println("Gano el jugador 2 en la primera linea horizontal");
			jugar = false;
		}
		if ((tablero[1][0] == 'X') && (tablero[1][1] == 'X') && (tablero[1][2] == 'X')) {
			System.out.println("Gano el jugador 1 en la segunda linea horizontal");
			jugar = false;
		}
		if ((tablero[1][0] == 'O') && (tablero[1][1] == 'O') && (tablero[1][2] == 'O')) {
			System.out.println("Gano el jugador 2 en la segunda linea horizontal");
			jugar = false;
		}
		if ((tablero[2][0] == 'X') && (tablero[2][1] == 'X') && (tablero[2][2] == 'X')) {
			System.out.println("Gano el jugador 1 en la tercera linea horizontal");
			jugar = false;
		}
		if ((tablero[2][0] == 'O') && (tablero[2][1] == 'O') && (tablero[2][2] == 'O')) {
			System.out.println("Gano el jugador 2 en la tercera linea horizontal");
			jugar = false;
		}
		if ((tablero[0][0] == 'X') && (tablero[1][0] == 'X') && (tablero[2][0] == 'X')) {
			System.out.println("Gano el jugador 1 en la primera linea vertical");
			jugar = false;
		}
		if ((tablero[0][0] == 'O') && (tablero[1][0] == 'O') && (tablero[2][0] == 'O')) {
			System.out.println("Gano el jugador 1 en la primera linea vertical");
			jugar = false;
		}
		if ((tablero[0][1] == 'X') && (tablero[1][1] == 'X') && (tablero[2][1] == 'X')) {
			System.out.println("Gano el jugador 1 en la segunda linea vertical");
			jugar = false;
		}
		if ((tablero[0][1] == 'O') && (tablero[1][1] == 'O') && (tablero[2][1] == 'O')) {
			System.out.println("Gano el jugador 2 en la segunda linea vertical");
			jugar = false;
		}
		if ((tablero[0][2] == 'X') && (tablero[1][2] == 'X') && (tablero[2][2] == 'X')) {
			System.out.println("Gano el jugador 1 en la tercera linea vertical");
			jugar = false;
		}
		if ((tablero[0][2] == 'O') && (tablero[1][2] == 'O') && (tablero[2][2] == 'O')) {
			System.out.println("Gano el jugador 2 en la tercera linea vertical");
			jugar = false;
		}
		if ((tablero[0][0] == 'X') && (tablero[1][1] == 'X') && (tablero[2][2] == 'X')) {
			System.out.println("Gano el jugador 1 en la primera linea diagonal");
			jugar = false;
		}
		if ((tablero[0][0] == 'O') && (tablero[1][1] == 'O') && (tablero[2][2] == 'O')) {
			System.out.println("Gano el jugador 2 en la primera linea diagonal");
			jugar = false;
		}
		if ((tablero[0][2] == 'X') && (tablero[1][1] == 'X') && (tablero[2][0] == 'X')) {
			System.out.println("Gano el jugador 1 en la segunda linea diagonal");
			jugar = false;
		}
		if ((tablero[0][2] == 'O') && (tablero[1][1] == 'O') && (tablero[2][0] == 'O')) {
			System.out.println("Gano el jugador 2 en la segunda linea diagonal");
			jugar = false;
		}

		return jugar;
	}

	public static void ubicarMovimiento(char[][] tablero, int movimiento, String usuario, Scanner sc) {
		char ficha = '@';
		if (usuario == "jugador1") {
			ficha = 'X';
		} else if (usuario == "jugador2") {
			ficha = 'O';
		}

		boolean validez = true;

		switch (movimiento) {
		case 1:
			tablero[0][0] = ficha;
			break;

		case 2:
			tablero[0][1] = ficha;
			break;
		case 3:
			tablero[0][2] = ficha;
			break;
		case 4:
			tablero[1][0] = ficha;
			break;
		case 5:
			tablero[1][1] = ficha;
			break;
		case 6:
			tablero[1][2] = ficha;
			break;
		case 7:
			tablero[2][0] = ficha;
			break;
		case 8:
			tablero[2][1] = ficha;
			break;
		case 9:
			tablero[2][2] = ficha;
			break;
		default:
			break;
		}
	}

	private static void imprimirTablero(char[][] tablero) {
		for (int f = 0; f < tablero.length; f++) {
			for (int c = 0; c < tablero[f].length; c++) {
				System.out.print(tablero[f][c] + " ");
			}
			System.out.println();
		}
	}
}
