package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ConexionBBDD.Conectar;
import Funciones.Funciones;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class InterfazDatosCuenta extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_2;
	private Component textField_1;
	private JTextField newUsr;
	private JTextField newMail;
	private JPasswordField pswAnt;
	private JPasswordField frstPsw;
	private JPasswordField scndPsw;
	private String usuario;
	private String contrasena;
	private String correo;

	public InterfazDatosCuenta(String username, String mailname, String password) throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\carlo\\Desktop\\prog\\2\\ProyectoFinalProgramacion\\src\\Imagenes\\MICRO.jpg"));
		setTitle("Batalla de Gallos");

		Boolean existe = Funciones.existeEnFichero(username);
		String du = "src/Ficheros/RecordarUsuario.txt";
		String dc = "src/Ficheros/RecordarClave.txt";
		ImageIcon iconi = new ImageIcon("src/Imagenes/INFO.png");
		ImageIcon icono = new ImageIcon("src/Imagenes/OK.png");
		ImageIcon icona = new ImageIcon("src/Imagenes/ALERT.png");
		Conectar c = new Conectar();
		c.Conectar();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextArea txtrUsuario = new JTextArea();
		txtrUsuario.setEditable(false);
		txtrUsuario.setBounds(34, 168, 117, 22);
		txtrUsuario.setForeground(Color.DARK_GRAY);
		txtrUsuario.setBackground(new Color(220, 220, 220));
		txtrUsuario.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrUsuario.setText("Nuevo usuario:");
		panel.add(txtrUsuario);

		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setBounds(186, 38, 165, 45);
		txtrLogin.setForeground(Color.DARK_GRAY);
		txtrLogin.setBackground(new Color(220, 220, 220));
		txtrLogin.setFont(new Font("Segoe Print", Font.BOLD, 23));
		txtrLogin.setEditable(false);
		txtrLogin.setText("Editar cuenta");
		panel.add(txtrLogin);

		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setBounds(34, 267, 117, 22);
		txtrContrasea.setText("Clave antigua:");
		txtrContrasea.setForeground(Color.DARK_GRAY);
		txtrContrasea.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrContrasea.setBackground(new Color(220, 220, 220));
		panel.add(txtrContrasea);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazHome h = new InterfazHome(username);
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(34, 382, 192, 30);
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		panel.add(btnNewButton);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setEditable(false);
		txtrEmail.setBounds(34, 201, 67, 22);
		txtrEmail.setText("E-mail:");
		txtrEmail.setForeground(Color.DARK_GRAY);
		txtrEmail.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrEmail.setBackground(new Color(220, 220, 220));
		panel.add(txtrEmail);
		
		JTextArea txtrRepetirLaClave = new JTextArea();
		txtrRepetirLaClave.setEditable(false);
		txtrRepetirLaClave.setBounds(34, 333, 135, 22);
		txtrRepetirLaClave.setText("Repetir la clave:");
		txtrRepetirLaClave.setForeground(Color.DARK_GRAY);
		txtrRepetirLaClave.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrRepetirLaClave.setBackground(new Color(220, 220, 220));
		panel.add(txtrRepetirLaClave);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Usuario:");
		textArea.setForeground(Color.DARK_GRAY);
		textArea.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setBackground(new Color(220, 220, 220));
		textArea.setBounds(34, 135, 67, 22);
		panel.add(textArea);
		
		JButton button = new JButton("No recordar clave");
		if (existe) {
			button.setVisible(false);
		} else {
			button.setVisible(true);			
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Funciones.savedOnFile("", du);
					Funciones.savedOnFile("", dc);
					InterfazDatosCuenta dc = new InterfazDatosCuenta(username, mailname, password);
					dc.setVisible(true);
					dispose();
				} catch (IOException e1) {}
			}
		});
		button.setFont(new Font("Monospaced", Font.BOLD, 11));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(379, 11, 162, 35);
		panel.add(button);

		
		JTextArea txtrNuevoCorreo = new JTextArea();
		txtrNuevoCorreo.setText("Nuevo correo:");
		txtrNuevoCorreo.setForeground(Color.DARK_GRAY);
		txtrNuevoCorreo.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrNuevoCorreo.setEditable(false);
		txtrNuevoCorreo.setBackground(new Color(220, 220, 220));
		txtrNuevoCorreo.setBounds(34, 234, 109, 22);
		panel.add(txtrNuevoCorreo);
		
		JTextArea txtrNuevaClave = new JTextArea();
		txtrNuevaClave.setText("Nueva clave:");
		txtrNuevaClave.setForeground(Color.DARK_GRAY);
		txtrNuevaClave.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrNuevaClave.setEditable(false);
		txtrNuevaClave.setBackground(new Color(220, 220, 220));
		txtrNuevaClave.setBounds(34, 300, 101, 22);
		panel.add(txtrNuevaClave);
		
		JLabel lblNewLabel = new JLabel(username);
		lblNewLabel.setBounds(111, 134, 135, 22);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel(mailname);
		label.setBounds(111, 200, 192, 22);
		panel.add(label);
		
		newUsr = new JTextField("");
		newUsr.setBounds(161, 168, 109, 20);
		panel.add(newUsr);
		newUsr.setColumns(10);
		
		newMail = new JTextField("");
		newMail.setColumns(10);
		newMail.setBounds(153, 236, 239, 20);
		panel.add(newMail);
		
		JLabel lblCorreoNoDisponible = new JLabel("Correo no disponible");
		lblCorreoNoDisponible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showConfirmDialog(null,
						"El e-mail debe contener:\n  -Caracteres, un @, más caracteres, un '.' y una extensión (ejemplo@hola.com).\n  -El correo no puede estar ya registrado",
						"Correo no compatible", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, iconi);

			}
		});
		lblCorreoNoDisponible.setForeground(Color.RED);
		lblCorreoNoDisponible.setBounds(307, 204, 162, 14);
		lblCorreoNoDisponible.setVisible(false);
		panel.add(lblCorreoNoDisponible);
		
		pswAnt = new JPasswordField();
		pswAnt.setBounds(161, 266, 117, 22);
		panel.add(pswAnt);
		
		frstPsw = new JPasswordField();
		frstPsw.setBounds(145, 300, 117, 22);
		panel.add(frstPsw);
		
		scndPsw = new JPasswordField();
		scndPsw.setBounds(179, 332, 117, 22);
		panel.add(scndPsw);
		
		JLabel lblClaveNoVlida = new JLabel("Clave no v\u00E1lida");
		lblClaveNoVlida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showConfirmDialog(null,
						"La clave debe tener:\n  -Una longitud mínima de 8 caracteres.\n  -Al menos una mayúscula.\n  -Al menos una minúscula.\n  -Al menos un número.",
						"Contraseña no compatible", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, iconi);
			}
		});
		lblClaveNoVlida.setForeground(Color.RED);
		lblClaveNoVlida.setBounds(272, 303, 142, 14);
		lblClaveNoVlida.setVisible(false);
		panel.add(lblClaveNoVlida);
		
		JLabel lblLasClavesNo = new JLabel("Las claves no coinciden");
		lblLasClavesNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showConfirmDialog(null, "Las claves deben coincidir para que te deje añadir la nueva cuenta.",
						"Las claves no coinciden", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, iconi);

			}
		});
		lblLasClavesNo.setForeground(Color.RED);
		lblLasClavesNo.setBounds(307, 334, 162, 19);
		lblLasClavesNo.setVisible(false);
		panel.add(lblLasClavesNo);
		
		JLabel lblSiNoQuiere = new JLabel("Si no quiere editar algo, bastar\u00E1 con dejarlo en blanco");
		lblSiNoQuiere.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblSiNoQuiere.setBounds(69, 94, 411, 30);
		panel.add(lblSiNoQuiere);
		
		JLabel lblUsuarioNoDisponible = new JLabel("Usuario no disponible");
		lblUsuarioNoDisponible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showConfirmDialog(null,
						"El usuario no puede estar ya registrado y debe tener:\n  -Una longitud mínima de 6 caracteres.\n  -Al menos una mayúscula.\n  -Al menos una minúscula.\n  -Al menos un número.",
						"Usuario no compatible", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, iconi);

			}
		});
		lblUsuarioNoDisponible.setForeground(Color.RED);
		lblUsuarioNoDisponible.setBounds(280, 171, 165, 19);
		lblUsuarioNoDisponible.setVisible(false);
		panel.add(lblUsuarioNoDisponible);

		JButton btnRegistrarte = new JButton("Editar");
		btnRegistrarte.addActionListener(new ActionListener() {
			private AbstractButton textField_1;
			private AbstractButton passwordField_2;
			private AbstractButton passwordField;
			private Component txtrLasClavesNo;

			public void actionPerformed(ActionEvent e) {
				
				if (pswAnt.getText().equals(password)) {
					if (newUsr.getText().equals("")) {
						usuario = username;
					} else {
						usuario = newUsr.getText();
					}

					if (newMail.getText().equals("")) {
						correo = mailname;
					} else {
						correo = newMail.getText();
					}

					if (frstPsw.getText().equals("") && scndPsw.getText().equals("")) {
						contrasena = password;
					} else {
						contrasena = frstPsw.getText();
					}

					if ((!Funciones.existeEnBaseDatos(usuario, "Usuario") || usuario.equals(username))
							&& Funciones.requisitosUser(usuario)
							&& (!Funciones.existeEnBaseDatos(correo, "Correo") || correo.equals(mailname))
							&& Funciones.requisitosMail(correo) && Funciones.requisitosClave(contrasena)
							&& frstPsw.getText().equals(scndPsw.getText())) {

						try {
							c.EjecutarUpdate("UPDATE registrodeconsultores SET Usuario = '" + usuario + "',Correo = '"
									+ correo + "',Contrasena = '" + contrasena + "' WHERE Usuario LIKE ('" + username + "')");
							c.EjecutarUpdate("UPDATE consultarbatallas SET Usuario = '" + usuario + "' WHERE Usuario LIKE ('" + username + "')");
							JOptionPane.showConfirmDialog(null,
									"Se editaron tus datos.",
									"Editar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icono);
							InterfazLogin l = new InterfazLogin();
							l.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							System.out.println("error");
						}

					} else {
						if ((Funciones.existeEnBaseDatos(usuario, "Usuario") || !Funciones.requisitosUser(usuario))
								&& !usuario.equals(username)) {
							lblUsuarioNoDisponible.setVisible(true);
						} else {
							lblUsuarioNoDisponible.setVisible(false);
						}
						if ((Funciones.existeEnBaseDatos(correo, "Correo") || !Funciones.requisitosUser(correo))
								&& !correo.equals(mailname)) {
							lblCorreoNoDisponible.setVisible(true);
						} else {
							lblCorreoNoDisponible.setVisible(false);
						}
						if (newUsr.getText() == username || frstPsw.getText() == password || newMail.getText() == mailname) {
							JOptionPane.showConfirmDialog(null,
											"Si no quieren cambiar algo dejenlo en blanco, pero no lo pongas igual.",
											"Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, iconi);
						}
						if (!Funciones.requisitosClave(contrasena)) {
							lblClaveNoVlida.setVisible(true);
						} else {
							lblClaveNoVlida.setVisible(false);
						}
						if (frstPsw.getText() != scndPsw.getText()) {
							lblLasClavesNo.setVisible(true);
						} else {
							lblLasClavesNo.setVisible(false);
						}
					} 
					
				} else {
					JOptionPane.showConfirmDialog(null,
							"La clave antigua no es la correcta.",
							"Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, iconi);
				}

			}
		});
		btnRegistrarte.setBounds(327, 382, 182, 30);
		btnRegistrarte.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnRegistrarte.setBackground(Color.LIGHT_GRAY);
		btnRegistrarte.setForeground(Color.BLACK);
		panel.add(btnRegistrarte);
		
	}
}
