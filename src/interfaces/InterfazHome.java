package interfaces;

import ConexionBBDD.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InterfazHome extends JFrame {

	private JPanel contentPane;

	public InterfazHome(String username) {

		String is;
		Conectar c = new Conectar();
		c.Conectar();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("A\u00F1adir Batalla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// if (no se ha registrado); InterfazLogin.setvisible;

			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(35, 193, 236, 93);
		panel.add(btnNewButton);

		JButton btnRegistrarte = new JButton("Borrar Batalla");
		btnRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// if (no se ha registrado); InterfazLogin.setvisible;

			}
		});
		btnRegistrarte.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnRegistrarte.setBackground(Color.LIGHT_GRAY);
		btnRegistrarte.setForeground(Color.BLACK);
		btnRegistrarte.setBounds(318, 193, 236, 93);
		panel.add(btnRegistrarte);

		JButton btnVisualizarBatallas = new JButton("Visualizar Batallas");
		btnVisualizarBatallas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] local = c.EjecutarSentencia("SELECT Local FROM consultarbatallas", "Local");
				String[] visitante = c.EjecutarSentencia("SELECT Visitante FROM consultarbatallas", "Visitante");
				for (int i = 0; i < local.length; i++) {
					System.out.println(local[i] + " V/S " + visitante[i]);
				}
			}
		});
		btnVisualizarBatallas.setForeground(Color.BLACK);
		btnVisualizarBatallas.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnVisualizarBatallas.setBackground(Color.LIGHT_GRAY);
		btnVisualizarBatallas.setBounds(35, 73, 236, 93);
		panel.add(btnVisualizarBatallas);

		JButton btnPredicciones = new JButton("Predicciones");
		btnPredicciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPredicciones.setForeground(Color.BLACK);
		btnPredicciones.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnPredicciones.setBackground(Color.LIGHT_GRAY);
		btnPredicciones.setBounds(318, 73, 236, 93);
		panel.add(btnPredicciones);

		JTextArea textArea = new JTextArea();
		textArea.setText("BatallasG");
		textArea.setForeground(Color.DARK_GRAY);
		textArea.setFont(new Font("Segoe Print", Font.BOLD, 23));
		textArea.setEditable(false);
		textArea.setBackground(new Color(220, 220, 220));
		textArea.setBounds(239, 11, 114, 45);
		panel.add(textArea);

		if (username != null) {

			is = username;

		} else {

			is = "Iniciar sesion";

		}

		JButton btnSi = new JButton(is);
		btnSi.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnSi.setBackground(Color.LIGHT_GRAY);
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (is == "Iniciar sesion") {
					dispose();
					InterfazLogin l = new InterfazLogin();
					l.setVisible(true);
				} else {

					JOptionPane.showMessageDialog(null,
							"Ya ha iniciado el susario " + username + ", cierre sesion si quiere cambiar.", "Users",
							JOptionPane.WARNING_MESSAGE);					
					
				}
			}
		});
		btnSi.setBounds(399, 27, 154, 23);
		panel.add(btnSi);
		
		if (username != null) {
			
			JButton button = new JButton("Cerrar sesión");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InterfazHome h = new InterfazHome(null);
					h.setVisible(true);
					dispose();
				}
			});
			button.setFont(new Font("Monospaced", Font.BOLD, 11));
			button.setBackground(Color.LIGHT_GRAY);
			button.setBounds(220, 304, 154, 23);
			panel.add(button);
			
		}
	}
}
