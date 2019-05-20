package Funciones;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import javax.swing.*;

import ConexionBBDD.Conectar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Funciones {

	public static String generaContraseña() {

		Random r = new Random();
		int n;
		int num;
		int numero;
		String psw = "";
		char caracter;
		for (int i = 0; i < 8; i++) {

			n = r.nextInt(3) + 1;
			switch (n) {
			case 1:
				num = r.nextInt(10) + 48;
				break;
			case 2:
				num = r.nextInt(25) + 65;
				break;
			default:
				num = r.nextInt(25) + 97;
				break;
			}
			caracter = (char) num;
			psw += Character.toString(caracter);

		}
		return psw;

	}

	public static boolean requisitosUser(String usuario) {
		String ePattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(usuario);
		return m.matches();
	}

	public static boolean requisitosMail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean requisitosClave(String usuario) {
		String ePattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(usuario);
		return m.matches();
	}

	public static boolean existeEnBaseDatos(String busqueda, String columna) {
		Conectar c = new Conectar();
		c.Conectar();
		boolean existe = false;
		String[] datos = c.EjecutarSentencia("SELECT " + columna + " FROM registrodeconsultores", columna);
		for (int i = 0; i < datos.length; i++) {
			if (datos[i].equals(busqueda)) {

				existe = true;

			}

		}
		return existe;

	}

	public static boolean recuperarCuentaValida(String correo) throws SQLException {
		System.out.println(correo);
		if (existeEnBaseDatos(correo, "Correo")) {
			Conectar c = new Conectar();
			c.Conectar();
			String contrasenaNueva = generaContraseña();
			c.EjecutarUpdate("UPDATE `registrodeconsultores` SET `Contrasena` = '" + contrasenaNueva
					+ "' WHERE `registrodeconsultores`.`Correo` = '" + correo + "';");
			ImageIcon icon = new ImageIcon("src/Imagenes/KEY.png");
			JOptionPane.showConfirmDialog(null,
					"El correo " + correo + " ahora tiene de contraseña: " + contrasenaNueva + ".",
					"Recuperar contraseña", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
			return true;
		} else {
			ImageIcon icon = new ImageIcon("src/Imagenes/ALERT.png");
			JOptionPane.showConfirmDialog(null,
					"El correo " + correo + " no está registrado en la base de datos, inténtelo de nuevo",
					"Recuperar contraseña", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
			return false;
		}

	}

	public static String[] datosTotales(String user) throws SQLException {

		Conectar c = new Conectar();
		c.Conectar();
		String[] mail = c.EjecutarSentencia("SELECT Correo FROM `registrodeconsultores` WHERE Usuario='" + user + "'",
				"Correo");
		String[] pass = c.EjecutarSentencia(
				"SELECT Contrasena FROM `registrodeconsultores` WHERE Usuario='" + user + "'", "Contrasena");
		String[] devolver = { mail[0], pass[0] };
		return devolver;

	}

	public static String[] getMeses(int y, String year, int m) {

		String[] devolver = { "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
		if (y == Integer.parseInt(year)) {
			for (int i = m; i < 13; i++) {
				devolver[i - m + 1] = "" + i;
			}
		} else {
			for (int i = 1; i < 13; i++) {
				devolver[i] = "" + i;
			}
		}
		int c = 1;
		for (int i = 1; devolver[i] != ""; i++) {
			c++;
		}
		String[] r = new String[c];
		for (int i = 0; i < c; i++) {
			r[i] = devolver[i];
		}
		return r;
	}

	public static String[] getDias(String m, String y) {

		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int dias;
		int month = Integer.parseInt(m);
		int year = Integer.parseInt(y);
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dias = 31;
			break;
		case 2:
			dias = 28;
			break;
		default:
			dias = 30;
			break;
		}
		if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month == 2) {
			dias++;
		}
		String[] r = new String[dias + 1];
		if (m.equals(mes) && y.equals(anio)) {
			for (int i = dias - 1; i < dias + 1; i++) {
				if (i == dias - 1) {
					r[0] = "";
				} else {
					r[i - dias + 1] = "" + i;
				}
			}
		} else {
			for (int i = 0; i < r.length; i++) {
				if (i == 0) {
					r[i] = "";
				} else {
					r[i] = "" + i;
				}
			}
		}
		return r;
	}

	public static void savedOnFile(String text, String directorio) throws IOException {

		FileWriter writer = new FileWriter(directorio);
		writer.write(text);
		writer.close();

	}

	public static String takeToFile(String directorio) throws IOException {

		String text = "";
		File file = new File(directorio);
		Scanner q = new Scanner(file);
		while (q.hasNextLine()) {
			text += q.nextLine();
		}
		return text;

	}

	public static boolean existeEnFichero(String username) throws IOException {

		if (username.equals(Funciones.takeToFile("src/Ficheros/RecordarUsuario.txt"))) {
			return false;
		} else {
			return true;
		}

	}

	public static String[] getVisitantes(String local, String user) {
		Conectar c = new Conectar();
		c.Conectar();
		String[] r = new String[c.EjecutarSentencia("SELECT visitante FROM consultarbatallas WHERE local LIKE ('"
				+ local + "') AND Usuario LIKE ('" + user + "')", "").length + 1];
		for (int i = 0; i < r.length; i++) {
			if (i == 0) {
				r[0] = "";
			} else {
				r[i] = c.EjecutarSentencia("SELECT visitante FROM consultarbatallas WHERE local LIKE ('" + local
						+ "') AND Usuario LIKE ('" + user + "')", "visitante")[i - 1];
			}
		}
		return r;
	}

	public static String[] getFechas(String local, String visitante, String username) {
		Conectar c = new Conectar();
		c.Conectar();
		String[] r = new String[c.EjecutarSentencia("SELECT fecha FROM consultarbatallas WHERE local LIKE ('" + local
				+ "') AND Usuario LIKE ('" + username + "') AND Visitante LIKE ('" + visitante + "')", "").length + 1];
		for (int i = 0; i < r.length; i++) {
			if (i == 0) {
				r[0] = "";
			} else {
				r[i] = c.EjecutarSentencia("SELECT fecha FROM consultarbatallas WHERE local LIKE ('" + local
						+ "') AND Usuario LIKE ('" + username + "') AND Visitante LIKE ('" + visitante + "')",
						"fecha")[i - 1];
			}
		}
		return r;
	}

}
