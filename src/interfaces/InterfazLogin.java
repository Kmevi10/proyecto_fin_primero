package interfaces;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;
import ConexionBBDD.Conectar;
import Funciones.Funciones;

public class InterfazLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String t;
	
	public InterfazLogin() {

		String a = "";
		String b = "";
		t = "";
		String du = "src/Ficheros/RecordarUsuario.txt";
		String dc = "src/Ficheros/RecordarClave.txt";
		Conectar c = new Conectar();
		c.Conectar();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		txtrUsuario.setForeground(Color.DARK_GRAY);
		txtrUsuario.setBackground(new Color(220, 220, 220));
		txtrUsuario.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrUsuario.setBounds(34, 79, 67, 22);
		txtrUsuario.setText("Usuario:");
		panel.add(txtrUsuario);

		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setBounds(179, 11, 67, 45);
		txtrLogin.setForeground(Color.DARK_GRAY);
		txtrLogin.setBackground(new Color(220, 220, 220));
		txtrLogin.setFont(new Font("Segoe Print", Font.BOLD, 23));
		txtrLogin.setEditable(false);
		txtrLogin.setText("Login");
		panel.add(txtrLogin);

		try {
			b = Funciones.takeToFile(du);
		} catch (IOException e2) {}
		textField = new JTextField(b);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setBounds(111, 79, 96, 20);
		panel.add(textField);
		textField.setColumns(10);

		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setText("Clave de acceso:");
		txtrContrasea.setForeground(Color.DARK_GRAY);
		txtrContrasea.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrContrasea.setBackground(new Color(220, 220, 220));
		txtrContrasea.setBounds(34, 112, 135, 22);
		panel.add(txtrContrasea);

		JButton btnhaOlvidadoSu = new JButton("\u00BFHa olvidado su clave de acceso?");
		btnhaOlvidadoSu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazRecuperarCuenta rc = new InterfazRecuperarCuenta();
				rc.setVisible(true);
			}
		});

		JCheckBox recordar = new JCheckBox("Recordar usuario y contrase\u00F1a");
		recordar.setForeground(Color.DARK_GRAY);
		recordar.setBackground(new Color(220,220,220));
		recordar.setFont(new Font("Monospaced", Font.BOLD, 13));
		recordar.setBounds(34, 141, 357, 28);
		panel.add(recordar);
		
		btnhaOlvidadoSu.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnhaOlvidadoSu.setToolTipText("");
		btnhaOlvidadoSu.setForeground(Color.DARK_GRAY);
		btnhaOlvidadoSu.setBackground(Color.LIGHT_GRAY);
		btnhaOlvidadoSu.setBounds(34, 176, 357, 23);
		panel.add(btnhaOlvidadoSu);

		try {
			a = Funciones.takeToFile(dc);
		} catch (IOException e2) {}
		passwordField = new JPasswordField(a);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setEchoChar('*');
		passwordField.setBounds(174, 112, 96, 20);
		panel.add(passwordField);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean existe = false;
				String[] usuarios = c.EjecutarSentencia("SELECT Usuario FROM registrodeconsultores", "Usuario");
				for (int i = 0; i < usuarios.length; i++) {

					if (usuarios[i].equals(textField.getText())) {

						existe = true;

					}

				}
				if (existe) {

					String[] claves = c
							.EjecutarSentencia("SELECT Contrasena FROM registrodeconsultores WHERE Usuario LIKE(\""
									+ textField.getText() + "\")", "Contrasena");
					if (passwordField.getText().equals(claves[0])) {

						if (recordar.isSelected()) {
							try {
								Funciones.savedOnFile(textField.getText(), du);
								Funciones.savedOnFile(passwordField.getText(), dc);
							} catch (IOException e1) {}
							t = "\nAutom\u00e1ticamente se guardar\u00e1 esta cuenta y contraseña\ny se borrar\u00e1 la anteriormente guardada.";
						}
						JOptionPane.showMessageDialog(null,
								"Enhora buena " + textField.getText() + ", conseguiste entrar en tu cuenta." + t, "Login",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						InterfazHome h = new InterfazHome(textField.getText());
						h.setVisible(true);

					} else {

						JOptionPane.showMessageDialog(null,
								"La contraseña del usuario " + textField.getText()
										+ " no es la correcta, inténtelo de nuevo.",
								"Login", JOptionPane.ERROR_MESSAGE);

					}

				} else {

					JOptionPane.showMessageDialog(null,
							"El usuario " + textField.getText() + " no existe, inténtelo de nuevo.", "Login",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(235, 210, 156, 30);
		panel.add(btnNewButton);

		JButton btnRegistrarte = new JButton("Registrarte");
		btnRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazRegister r = new InterfazRegister();
				r.setVisible(true);
			}
		});
		btnRegistrarte.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnRegistrarte.setBackground(Color.LIGHT_GRAY);
		btnRegistrarte.setForeground(Color.BLACK);
		btnRegistrarte.setBounds(34, 210, 147, 30);
		panel.add(btnRegistrarte);

		JButton btnNoAccederA = new JButton("No iniciar sesion");
		btnNoAccederA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazHome h = new InterfazHome(null);
				h.setVisible(true);
			}
		});
		btnNoAccederA.setForeground(Color.BLACK);
		btnNoAccederA.setFont(new Font("Monospaced", Font.PLAIN, 9));
		btnNoAccederA.setBackground(Color.LIGHT_GRAY);
		btnNoAccederA.setBounds(279, 28, 135, 22);
		panel.add(btnNoAccederA);
		
	}
}
