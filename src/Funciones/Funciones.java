package Funciones;

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

	public static boolean requisitosFecha(String fecha) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			df.setLenient(false);
			df.parse(fecha);
			return fechaMayor(fecha);
		} catch (ParseException e) {
			return false;
		}
		
	}
	
	public static boolean fechaMayor(String date) {
		
		String dateNow = "" + LocalDate.now(ZoneId.of("Europe/Paris"));
		int year = simplificarFecha(date,1);
		int yearNow = simplificarFecha(dateNow, 1);
		if (year >= yearNow) {
			if (year > yearNow) {
				return true;
			} else {
				int month = simplificarFecha(date, 2);
				if (month < 1 || month > 12) {
					return false;
				}
				int diaMax = diaMaximoMes(month, year);
				int monthNow = simplificarFecha(dateNow, 2);
				if (month >= monthNow) {
					if (month > monthNow) {
						return true;
					} else {
						int day = simplificarFecha(date, 3);
						if (day < 1 || day > diaMax) {
							return false;
						}
						int dayNow = simplificarFecha(dateNow, 3);
						if (day >= dayNow) {
								return true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	private static int diaMaximoMes(int month, int year) {
		int dias;
		
		switch(month) {
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
			dias ++;
		}
		return dias;
	}

	public static int simplificarFecha(String date, int ymd) {
		String devolver = "";
		int control = 0;
		for (int i = 0; i < ymd; i++) {
			devolver = "";
			while (date.charAt(control) != '-' || control < date.length() - 1) {
				devolver += date.charAt(control);
				control++;
			}
			control++;
		}
		return Integer.parseInt(devolver);
	}

}
