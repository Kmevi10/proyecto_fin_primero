package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBBDD.Conectar;
import Funciones.Funciones;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
<<<<<<< Updated upstream
=======
import javax.swing.ImageIcon;
>>>>>>> Stashed changes
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
<<<<<<< Updated upstream
=======
import java.sql.SQLException;
>>>>>>> Stashed changes

public class InterfazRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public InterfazRegister() {
<<<<<<< Updated upstream
		
		Conectar c = new Conectar();
		c.Conectar();
		
=======

		ImageIcon icon = new ImageIcon("src/Imagenes/INFO.png");
		Conectar c = new Conectar();
		c.Conectar();

>>>>>>> Stashed changes
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
		txtrUsuario.setBounds(34, 63, 67, 22);
		txtrUsuario.setForeground(Color.DARK_GRAY);
		txtrUsuario.setBackground(new Color(220, 220, 220));
		txtrUsuario.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrUsuario.setText("Usuario:");
		panel.add(txtrUsuario);

		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setBounds(163, 11, 107, 45);
		txtrLogin.setForeground(Color.DARK_GRAY);
		txtrLogin.setBackground(new Color(220, 220, 220));
		txtrLogin.setFont(new Font("Segoe Print", Font.BOLD, 23));
		txtrLogin.setEditable(false);
		txtrLogin.setText("Registro");
		panel.add(txtrLogin);

		textField = new JTextField();
		textField.setBounds(111, 63, 96, 20);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		panel.add(textField);
		textField.setColumns(10);

		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setBounds(34, 129, 135, 22);
		txtrContrasea.setText("Clave de acceso:");
		txtrContrasea.setForeground(Color.DARK_GRAY);
		txtrContrasea.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrContrasea.setBackground(new Color(220, 220, 220));
		panel.add(txtrContrasea);

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 129, 96, 20);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setEchoChar('*');
		panel.add(passwordField);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazLogin l = new InterfazLogin();
				l.setVisible(true);
			}
		});
		btnNewButton.setBounds(34, 210, 156, 30);
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		panel.add(btnNewButton);
<<<<<<< Updated upstream
		
=======

>>>>>>> Stashed changes
		JTextArea txtrUsuarioNoDisponible = new JTextArea();
		txtrUsuarioNoDisponible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

<<<<<<< Updated upstream
				JOptionPane.showMessageDialog(null,
						"El usuario no puede estar ya registrado y debe tener:\nUna longitud mínima de 6 caracteres.\nAl menos una mayúscula.\nAl menos una minúscula.\nAl menos un número.",
						"Usuario no compatible", JOptionPane.INFORMATION_MESSAGE);
=======
				JOptionPane.showConfirmDialog(null,
						"El usuario no puede estar ya registrado y debe tener:\\nUna longitud mínima de 6 caracteres.\\nAl menos una mayúscula.\\nAl menos una minúscula.\\nAl menos un número.",
						"Usuario no compatible", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

>>>>>>> Stashed changes
			}
		});
		txtrUsuarioNoDisponible.setText("Usuario no disponible.");
		txtrUsuarioNoDisponible.setForeground(new Color(255, 0, 0));
		txtrUsuarioNoDisponible.setFont(new Font("Miriam Mono CLM", Font.BOLD, 10));
		txtrUsuarioNoDisponible.setEditable(false);
		txtrUsuarioNoDisponible.setBackground(new Color(220, 220, 220));
		txtrUsuarioNoDisponible.setBounds(217, 66, 197, 22);
		txtrUsuarioNoDisponible.setVisible(false);
		panel.add(txtrUsuarioNoDisponible);
<<<<<<< Updated upstream
		
=======

>>>>>>> Stashed changes
		JTextArea txtrMailNoValido = new JTextArea();
		txtrMailNoValido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

<<<<<<< Updated upstream
				JOptionPane.showMessageDialog(null,
						"El e-mail debe contener caracteres, un @, más caracteres, un '.' y una extensión.",
						"Correo no compatible", JOptionPane.INFORMATION_MESSAGE);
=======
				JOptionPane.showConfirmDialog(null,
						"El e-mail debe contener caracteres, un @, más caracteres, un '.' y una extensión.",
						"Correo no compatible", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

>>>>>>> Stashed changes
			}
		});
		txtrMailNoValido.setText("Mail no valido.");
		txtrMailNoValido.setForeground(Color.RED);
		txtrMailNoValido.setFont(new Font("Miriam Mono CLM", Font.BOLD, 10));
		txtrMailNoValido.setEditable(false);
		txtrMailNoValido.setBackground(new Color(220, 220, 220));
		txtrMailNoValido.setBounds(329, 99, 85, 22);
		txtrMailNoValido.setVisible(false);
		panel.add(txtrMailNoValido);
<<<<<<< Updated upstream
		
		JTextArea txtrLasClavesNo = new JTextArea();
		JTextArea txtrLasClavesNo_1 = new JTextArea();
=======

		JTextArea txtrLasClavesNo = new JTextArea();
		txtrLasClavesNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showConfirmDialog(null, "Las claves deben coincidir para que te deje registrar la cuenta.",
						"Las claves no coinciden", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

			}
		});
		txtrLasClavesNo.setText("Las claves no coinciden");
		txtrLasClavesNo.setForeground(Color.RED);
		txtrLasClavesNo.setFont(new Font("Miriam Mono CLM", Font.BOLD, 10));
		txtrLasClavesNo.setEditable(false);
		txtrLasClavesNo.setBackground(new Color(220, 220, 220));
		txtrLasClavesNo.setBounds(280, 132, 144, 22);
		txtrLasClavesNo.setVisible(false);
		panel.add(txtrLasClavesNo);

		JTextArea txtrLasClavesNo_1 = new JTextArea();
		txtrLasClavesNo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showConfirmDialog(null,
						"La clave debe tener:\\nUna longitud mínima de 8 caracteres.\\nAl menos una mayúscula.\\nAl menos una minúscula.\\nAl menos un número.",
						"Contraseña no compatible", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

			}
		});
		txtrLasClavesNo_1.setText("Las claves no cumplen los requisitos.");
		txtrLasClavesNo_1.setForeground(Color.RED);
		txtrLasClavesNo_1.setFont(new Font("Miriam Mono CLM", Font.BOLD, 10));
		txtrLasClavesNo_1.setEditable(false);
		txtrLasClavesNo_1.setBackground(new Color(220, 220, 220));
		txtrLasClavesNo_1.setBounds(111, 187, 233, 22);
		txtrLasClavesNo_1.setVisible(false);
		panel.add(txtrLasClavesNo_1);
>>>>>>> Stashed changes

		JButton btnRegistrarte = new JButton("Registrarte");
		btnRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
				if (Funciones.requisitosUser(textField.getText()) && Funciones.requisitosMail(textField_1.getText())
						&& Funciones.requisitosClave(passwordField.getText())
						&& passwordField.getText() == passwordField_2.getText()) {
					
					System.out.println("hola");
					JOptionPane.showMessageDialog(null, "Enhorabuena, su cuenta fue creada y guardada.", "Cuenta registrada", JOptionPane.PLAIN_MESSAGE);

				} else {

					if (!Funciones.requisitosUser(textField.getText())) {

						txtrUsuarioNoDisponible.setVisible(true);
=======
				if ((Funciones.requisitosUser(textField.getText()) && !Funciones.usuarioExiste(textField.getText()))
						&& Funciones.requisitosMail(textField_1.getText())
						&& Funciones.requisitosClave(passwordField.getText())
						&& passwordField.getText().equals(passwordField_2.getText())) {

					txtrMailNoValido.setVisible(false);
					txtrUsuarioNoDisponible.setVisible(false);
					txtrLasClavesNo_1.setVisible(false);
					txtrLasClavesNo.setVisible(false);
					
						try {
							c.EjecutarUpdate(
									"INSERT INTO `registrodeconsultores` (`Usuario`, `E-mail`, `Contrasena`) VALUES ('"
											+ textField.getText() + "', '" + textField_1.getText() + "', '"
											+ passwordField.getText() + "')");
							ImageIcon icon = new ImageIcon("src/Imagenes/OK.png");
							JOptionPane.showConfirmDialog(null, "Enhorabuena, se registró correctamente.", "Registro",
									JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
							
						} catch (SQLException e1) {
							System.out.println("Error en la consulta INSERT INTO.");
						}
					
					

				} else {

					if (!Funciones.requisitosUser(textField.getText())
							|| Funciones.usuarioExiste(textField.getText())) {

						txtrUsuarioNoDisponible.setVisible(true);
						txtrUsuarioNoDisponible.setVisible(true);
>>>>>>> Stashed changes

					}

					if (!Funciones.requisitosMail(textField_1.getText())) {

						txtrMailNoValido.setVisible(true);
<<<<<<< Updated upstream
=======
						txtrMailNoValido.setVisible(true);
>>>>>>> Stashed changes

					}

					if (!Funciones.requisitosClave(passwordField.getText())) {

<<<<<<< Updated upstream
						txtrLasClavesNo_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								JOptionPane.showMessageDialog(null,
										"La clave debe tener:\nUna longitud mínima de 8 caracteres.\nAl menos una mayúscula.\nAl menos una minúscula.\nAl menos un número.",
										"Usuario no compatible", JOptionPane.INFORMATION_MESSAGE);
							}
						});
						txtrLasClavesNo_1.setText("Las claves no cumplen los requisitos.");
						txtrLasClavesNo_1.setForeground(Color.RED);
						txtrLasClavesNo_1.setFont(new Font("Miriam Mono CLM", Font.BOLD, 10));
						txtrLasClavesNo_1.setEditable(false);
						txtrLasClavesNo_1.setBackground(new Color(220, 220, 220));
						txtrLasClavesNo_1.setBounds(111, 187, 233, 22);
						panel.add(txtrLasClavesNo_1);
=======
						txtrLasClavesNo_1.setVisible(true);
						txtrLasClavesNo_1.setVisible(true);
>>>>>>> Stashed changes

					}

					if (!passwordField.getText().equals(passwordField_2.getText())) {

<<<<<<< Updated upstream
						txtrLasClavesNo.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								JOptionPane.showMessageDialog(null, "Las claves deben coincidir para que te deje registrar la cuenta.",
										"Las claves no coinciden", JOptionPane.INFORMATION_MESSAGE);
							}
						});
						txtrLasClavesNo.setText("Las claves no coinciden");
						txtrLasClavesNo.setForeground(Color.RED);
						txtrLasClavesNo.setFont(new Font("Miriam Mono CLM", Font.BOLD, 10));
						txtrLasClavesNo.setEditable(false);
						txtrLasClavesNo.setBackground(new Color(220, 220, 220));
						txtrLasClavesNo.setBounds(280, 132, 144, 22);
						panel.add(txtrLasClavesNo);
						
					}
					
					if (Funciones.requisitosUser(textField.getText())) {
=======
						txtrLasClavesNo.setVisible(true);
						txtrLasClavesNo.setVisible(true);

					}

					if (Funciones.requisitosUser(textField.getText())
							&& !Funciones.usuarioExiste(textField.getText())) {
>>>>>>> Stashed changes

						txtrUsuarioNoDisponible.setVisible(false);

					}

					if (Funciones.requisitosMail(textField_1.getText())) {

						txtrMailNoValido.setVisible(false);

					}

					if (Funciones.requisitosClave(passwordField.getText())) {

						txtrLasClavesNo_1.setVisible(false);

					}

					if (passwordField.getText().equals(passwordField_2.getText())) {

						txtrLasClavesNo.setVisible(false);
<<<<<<< Updated upstream
						
=======

>>>>>>> Stashed changes
					}

				}

			}
		});
		btnRegistrarte.setBounds(244, 210, 147, 30);
		btnRegistrarte.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnRegistrarte.setBackground(Color.LIGHT_GRAY);
		btnRegistrarte.setForeground(Color.BLACK);
		panel.add(btnRegistrarte);

		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setEditable(false);
		txtrEmail.setBounds(34, 96, 67, 22);
		txtrEmail.setText("E-mail:");
		txtrEmail.setForeground(Color.DARK_GRAY);
		txtrEmail.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrEmail.setBackground(new Color(220, 220, 220));
		panel.add(txtrEmail);

		JTextArea txtrRepetirLaClave = new JTextArea();
		txtrRepetirLaClave.setEditable(false);
		txtrRepetirLaClave.setBounds(34, 162, 135, 22);
		txtrRepetirLaClave.setText("Repetir la clave:");
		txtrRepetirLaClave.setForeground(Color.DARK_GRAY);
		txtrRepetirLaClave.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrRepetirLaClave.setBackground(new Color(220, 220, 220));
		panel.add(txtrRepetirLaClave);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(184, 162, 96, 20);
		passwordField_2.setEchoChar('*');
		passwordField_2.setBackground(Color.LIGHT_GRAY);
		panel.add(passwordField_2);

		textField_1 = new JTextField();
		textField_1.setBounds(96, 96, 223, 20);
		textField_1.setBackground(Color.LIGHT_GRAY);
		panel.add(textField_1);
		textField_1.setColumns(10);

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	}
}
