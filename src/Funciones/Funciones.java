package Funciones;

import java.sql.SQLException;
import java.util.Random;

<<<<<<< HEAD
<<<<<<< Updated upstream
=======
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ConexionBBDD.Conectar;

>>>>>>> develop
public class Funciones {

	public static String generaContraseña() {
=======
import ConexionBBDD.Conectar;

public class Funciones {

	public static String generaContraseña() {
		
>>>>>>> Stashed changes

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
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
	
	public static boolean usuarioExiste(String usuario) {
		
		Conectar c = new Conectar();
		c.Conectar();		
		boolean existe = false;
		String[] usuarios = c.EjecutarSentencia("SELECT Usuario FROM registrodeconsultores", "Usuario");
		for (int i = 0; i < usuarios.length; i++) {

			if (usuarios[i].equals(usuario)) {

				existe = true;

			}

		}

		return existe;
		
	}
>>>>>>> Stashed changes
=======
	
	public static String[] datosTotales(String user) throws SQLException {
		
		Conectar c = new Conectar();
		c.Conectar();
		String[] mail = c.EjecutarSentencia("SELECT Correo FROM `registrodeconsultores` WHERE Usuario='" + user + "'", "Correo");
		String[] pass = c.EjecutarSentencia("SELECT Contrasena FROM `registrodeconsultores` WHERE Usuario='" + user + "'", "Contrasena");
		String[] devolver = { mail[0], pass[0]};
		return devolver;
		
	}
>>>>>>> develop

}
