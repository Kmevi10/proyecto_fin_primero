package interfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import ConexionBBDD.Conectar;

public class InterfazLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public InterfazLogin() {
		
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
		txtrUsuario.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
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
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setBounds(111, 79, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setText("Clave de acceso:");
		txtrContrasea.setForeground(Color.DARK_GRAY);
		txtrContrasea.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrContrasea.setBackground(new Color(220, 220, 220));
		txtrContrasea.setBounds(34, 123, 135, 22);
		panel.add(txtrContrasea);
		
		JButton btnhaOlvidadoSu = new JButton("\u00BFHa olvidado su clave de acceso?");
		btnhaOlvidadoSu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazRecuperarCuenta rc = new InterfazRecuperarCuenta();
				rc.setVisible(true);
			}
		});
		btnhaOlvidadoSu.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnhaOlvidadoSu.setToolTipText("");
		btnhaOlvidadoSu.setForeground(Color.DARK_GRAY);
		btnhaOlvidadoSu.setBackground(Color.LIGHT_GRAY);
		btnhaOlvidadoSu.setBounds(34, 164, 357, 23);
		panel.add(btnhaOlvidadoSu);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setEchoChar('*');
		passwordField.setBounds(174, 123, 96, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] usuarios = c.EjecutarSentencia("SELECT Usuario FROM registrodeconsultores", "Usuario");
				String[] claves = c.EjecutarSentencia("SELECT Contrasena FROM registrodeconsultores", "Contrasena");
				int cont = 1;
				for (int i = 0; textField.getText() != usuarios[i] || i > usuarios.length; i++) {
					
					cont++;
					
				}
				if (passwordField.getText() == claves[cont]) {
					
					System.out.println("hola");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(34, 210, 156, 30);
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
		btnRegistrarte.setBounds(244, 210, 147, 30);
		panel.add(btnRegistrarte);
		
		JButton btnNoAccederA = new JButton("No iniciar sesion");
		btnNoAccederA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazHome h = new InterfazHome();
				h.setVisible(true);
			}
		});
		btnNoAccederA.setForeground(Color.BLACK);
		btnNoAccederA.setFont(new Font("Monospaced", Font.PLAIN, 9));
		btnNoAccederA.setBackground(Color.LIGHT_GRAY);
		btnNoAccederA.setBounds(279, 11, 135, 22);
		panel.add(btnNoAccederA);
	}
}
