package Funciones;

import java.io.IOException;

public class pruebas {

	public static void main(String[] args) {

		try {
			String a = Funciones.takeToFile("src/Ficheros/RecordarClave.txt");
			System.out.println(a);
		} catch (IOException e) {}

	}

}
