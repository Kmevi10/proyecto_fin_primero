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

public class InterfazDatosCuenta extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_2;
	private Component textField_1;
	private JTextField textField;
	private JTextField textField_2;

	public InterfazDatosCuenta(String username, String mailname, String password) {

		ImageIcon icon = new ImageIcon("src/Imagenes/INFO.png");
		Conectar c = new Conectar();
		c.Conectar();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 423);
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
		txtrUsuario.setBounds(34, 132, 117, 22);
		txtrUsuario.setForeground(Color.DARK_GRAY);
		txtrUsuario.setBackground(new Color(220, 220, 220));
		txtrUsuario.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrUsuario.setText("Nuevo usuario:");
		panel.add(txtrUsuario);

		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setBounds(127, 24, 165, 45);
		txtrLogin.setForeground(Color.DARK_GRAY);
		txtrLogin.setBackground(new Color(220, 220, 220));
		txtrLogin.setFont(new Font("Segoe Print", Font.BOLD, 23));
		txtrLogin.setEditable(false);
		txtrLogin.setText("Editar cuenta");
		panel.add(txtrLogin);

		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setBounds(34, 226, 117, 22);
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
		btnNewButton.setBounds(33, 333, 156, 30);
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		panel.add(btnNewButton);

		JButton btnRegistrarte = new JButton("Editar");
		btnRegistrarte.addActionListener(new ActionListener() {
			private AbstractButton textField_1;
			private AbstractButton passwordField_2;
			private AbstractButton passwordField;
			private Component txtrLasClavesNo;

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRegistrarte.setBounds(245, 333, 147, 30);
		btnRegistrarte.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnRegistrarte.setBackground(Color.LIGHT_GRAY);
		btnRegistrarte.setForeground(Color.BLACK);
		panel.add(btnRegistrarte);

		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setEditable(false);
		txtrEmail.setBounds(34, 162, 67, 22);
		txtrEmail.setText("E-mail:");
		txtrEmail.setForeground(Color.DARK_GRAY);
		txtrEmail.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrEmail.setBackground(new Color(220, 220, 220));
		panel.add(txtrEmail);

		JTextArea txtrRepetirLaClave = new JTextArea();
		txtrRepetirLaClave.setEditable(false);
		txtrRepetirLaClave.setBounds(34, 292, 135, 22);
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
		textArea.setBounds(34, 99, 67, 22);
		panel.add(textArea);

		JTextArea txtrNuevoCorreo = new JTextArea();
		txtrNuevoCorreo.setText("Nuevo correo:");
		txtrNuevoCorreo.setForeground(Color.DARK_GRAY);
		txtrNuevoCorreo.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrNuevoCorreo.setEditable(false);
		txtrNuevoCorreo.setBackground(new Color(220, 220, 220));
		txtrNuevoCorreo.setBounds(34, 193, 109, 22);
		panel.add(txtrNuevoCorreo);

		JTextArea txtrNuevaClave = new JTextArea();
		txtrNuevaClave.setText("Nueva clave:");
		txtrNuevaClave.setForeground(Color.DARK_GRAY);
		txtrNuevaClave.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrNuevaClave.setEditable(false);
		txtrNuevaClave.setBackground(new Color(220, 220, 220));
		txtrNuevaClave.setBounds(34, 259, 101, 22);
		panel.add(txtrNuevaClave);

		JLabel lblNewLabel = new JLabel(username);
		lblNewLabel.setBounds(111, 98, 135, 22);
		panel.add(lblNewLabel);

		JLabel label = new JLabel(mailname);
		label.setBounds(100, 161, 192, 22);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(161, 132, 109, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(153, 193, 239, 20);
		panel.add(textField_2);
		
		JLabel lblCorreoNoDisponible = new JLabel("Correo no disponible");
		lblCorreoNoDisponible.setBounds(307, 165, 48, 14);
		panel.add(lblCorreoNoDisponible);

	}
}
