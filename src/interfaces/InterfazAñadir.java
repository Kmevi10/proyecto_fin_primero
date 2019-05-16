package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import Atxy2k.CustomTextField.RestrictedTextField;
import ConexionBBDD.Conectar;
import Funciones.Funciones;

public class InterfazAñadir extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public InterfazAñadir(String username) {

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

		DefaultTableModel modelo = new DefaultTableModel();

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazHome h = new InterfazHome(username);
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(21, 210, 153, 30);
		panel.add(btnNewButton);

		JTextArea txtrLocal = new JTextArea();
		txtrLocal.setText("Local");
		txtrLocal.setForeground(Color.DARK_GRAY);
		txtrLocal.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrLocal.setEditable(false);
		txtrLocal.setBackground(new Color(220, 220, 220));
		txtrLocal.setBounds(39, 89, 67, 22);
		panel.add(txtrLocal);

		JTextArea txtrVisitante = new JTextArea();
		txtrVisitante.setText("Visitante");
		txtrVisitante.setForeground(Color.DARK_GRAY);
		txtrVisitante.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrVisitante.setEditable(false);
		txtrVisitante.setBackground(new Color(220, 220, 220));
		txtrVisitante.setBounds(39, 122, 88, 22);
		panel.add(txtrVisitante);

		JLabel lblFechaInvlidaPor = new JLabel("Fecha inv\u00E1lida, por favor inserte");
		lblFechaInvlidaPor.setForeground(Color.RED);
		lblFechaInvlidaPor.setBounds(222, 154, 177, 22);
		lblFechaInvlidaPor.setVisible(false);
		panel.add(lblFechaInvlidaPor);
		
		JLabel lblUnaVlida = new JLabel("una v\u00E1lida");
		lblUnaVlida.setForeground(Color.RED);
		lblUnaVlida.setBounds(222, 171, 88, 14);
		lblUnaVlida.setVisible(false);
		panel.add(lblUnaVlida);
		
		JTextArea txtrFecha = new JTextArea();
		txtrFecha.setText("Fecha");
		txtrFecha.setForeground(Color.DARK_GRAY);
		txtrFecha.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrFecha.setEditable(false);
		txtrFecha.setBackground(new Color(220, 220, 220));
		txtrFecha.setBounds(39, 155, 67, 22);
		panel.add(txtrFecha);

		JButton btnVerTodas = new JButton("A\u00F1adir Batalla");
		btnVerTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Funciones.requisitosFecha(textField_2.getText())) {
					lblUnaVlida.setVisible(false);
					lblFechaInvlidaPor.setVisible(false);
					try {
						c.EjecutarUpdate(
								"INSERT INTO `consultarbatallas`(`Usuario`, `Local`, `Visitante`, `Fecha`) VALUES ('"
										+ username + "','" + textField.getText() + "','" + textField_1.getText() + "','"
										+ textField_2.getText() + "')");
					} catch (SQLException e1) {
						ImageIcon icon = new ImageIcon("src/Imagenes/ALERT.png");
						int decision = JOptionPane.showConfirmDialog(null,
								"Upss!! Creo que hubo un fallo al\nintentar añadir la batalla, int\u00e9ntelo\nde nuevo",
								"Visualizar batallas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
						if (decision == JOptionPane.YES_OPTION) {
							
							InterfazVisualizarTodo vt = new InterfazVisualizarTodo(username);
							vt.setVisible(true);
							dispose();
							
						}
					}
				} else {
					lblUnaVlida.setVisible(true);
					lblFechaInvlidaPor.setVisible(true);
				}
			}
		});
		btnVerTodas.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnVerTodas.setBackground(Color.LIGHT_GRAY);
		btnVerTodas.setBounds(246, 210, 153, 30);
		panel.add(btnVerTodas);

		JLabel lblBatallasDe = new JLabel("A\u00F1adir batalla a la cuenta " + username);
		lblBatallasDe.setForeground(new Color(51, 51, 51));
		lblBatallasDe.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblBatallasDe.setBounds(21, 35, 393, 22);
		panel.add(lblBatallasDe);

		textField = new JTextField();
		RestrictedTextField r1 = new RestrictedTextField(textField, "abcdefghijklmnñopqrstuvwxyz1234567890");
        r1.setLimit(15);
		textField.setBounds(116, 89, 119, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		RestrictedTextField r2 = new RestrictedTextField(textField_1, "abcdefghijklmnñopqrstuvwxyz1234567890");
        r2.setLimit(15);
		textField_1.setColumns(10);
		textField_1.setBounds(137, 122, 119, 20);
		panel.add(textField_1);

		textField_2 = new JTextField();
		RestrictedTextField r3 = new RestrictedTextField(textField_2, "-1234567890");
        r3.setLimit(10);
		textField_2.setToolTipText("aaaa-mm-dd");
		textField_2.setBounds(116, 155, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		

	}
}