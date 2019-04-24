package interfaces;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Funciones.Funciones;

public class InterfazRecuperarCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public InterfazRecuperarCuenta() {
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
		txtrUsuario.setBounds(34, 165, 67, 22);
		txtrUsuario.setText("E-mail:");
		panel.add(txtrUsuario);

		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setBounds(97, 11, 210, 45);
		txtrLogin.setForeground(Color.DARK_GRAY);
		txtrLogin.setBackground(new Color(220, 220, 220));
		txtrLogin.setFont(new Font("Segoe Print", Font.BOLD, 23));
		txtrLogin.setEditable(false);
		txtrLogin.setText("Recuperar cuenta");
		panel.add(txtrLogin);

		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setBounds(97, 165, 217, 20);
		panel.add(textField);
		textField.setColumns(10);

		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setText("Para recuperar su cuenta debe insertar");
		txtrContrasea.setForeground(Color.DARK_GRAY);
		txtrContrasea.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrContrasea.setBackground(new Color(220, 220, 220));
		txtrContrasea.setBounds(34, 64, 319, 22);
		panel.add(txtrContrasea);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazLogin l = new InterfazLogin();
				l.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(34, 210, 156, 30);
		panel.add(btnNewButton);

		JButton btnRegistrarte = new JButton("Notificar");
		btnRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Funciones.recuperarCuentaValida(textField.getText())) {
						InterfazLogin l = new InterfazLogin();
						l.setVisible(true);
						dispose();
					}
				} catch (SQLException e1) {}
			}
		});
		btnRegistrarte.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnRegistrarte.setBackground(Color.LIGHT_GRAY);
		btnRegistrarte.setForeground(Color.BLACK);
		btnRegistrarte.setBounds(244, 210, 147, 30);
		panel.add(btnRegistrarte);

		JTextArea txtrInertarSiMail = new JTextArea();
		txtrInertarSiMail.setText("su mail y nosotros le enviaremos la");
		txtrInertarSiMail.setForeground(Color.DARK_GRAY);
		txtrInertarSiMail.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrInertarSiMail.setEditable(false);
		txtrInertarSiMail.setBackground(new Color(220, 220, 220));
		txtrInertarSiMail.setBounds(34, 89, 330, 22);
		panel.add(txtrInertarSiMail);

		JTextArea txtrLaClaveDe = new JTextArea();
		txtrLaClaveDe.setText("clave de acceso del respectivo correo.");
		txtrLaClaveDe.setForeground(Color.DARK_GRAY);
		txtrLaClaveDe.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrLaClaveDe.setEditable(false);
		txtrLaClaveDe.setBackground(new Color(220, 220, 220));
		txtrLaClaveDe.setBounds(34, 111, 330, 22);
		panel.add(txtrLaClaveDe);
	}
}
