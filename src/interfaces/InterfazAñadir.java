package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import Atxy2k.CustomTextField.RestrictedTextField;
import ConexionBBDD.Conectar;
import Funciones.Funciones;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InterfazAñadir extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public InterfazAñadir(String username) {

		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		Conectar c = new Conectar();
		c.Conectar();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 371);
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
		btnNewButton.setBounds(21, 281, 153, 30);
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

		JTextArea txtrFecha = new JTextArea();
		txtrFecha.setText("Fecha:");
		txtrFecha.setForeground(Color.DARK_GRAY);
		txtrFecha.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrFecha.setEditable(false);
		txtrFecha.setBackground(new Color(220, 220, 220));
		txtrFecha.setBounds(39, 155, 67, 22);
		panel.add(txtrFecha);

		JLabel lblBatallasDe = new JLabel("A\u00F1adir batalla a la cuenta " + username);
		lblBatallasDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatallasDe.setForeground(new Color(51, 51, 51));
		lblBatallasDe.setFont(new Font("Segoe Print", Font.BOLD, 19));
		lblBatallasDe.setBounds(21, 11, 393, 67);
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
		r2.setLimit(10);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAo.setBounds(21, 188, 101, 14);
		panel.add(lblAo);

		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setBounds(165, 188, 101, 14);
		panel.add(lblMes);

		JLabel lblDa = new JLabel("D\u00EDa");
		lblDa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDa.setBounds(313, 188, 101, 14);
		panel.add(lblDa);

		JComboBox y = new JComboBox();
		y.addItem("");
		y.setBounds(21, 213, 101, 22);
		panel.add(y);

		JComboBox m = new JComboBox();
		m.setEnabled(false);
		m.setBounds(165, 213, 101, 22);
		panel.add(m);

		JComboBox d = new JComboBox();
		d.setEnabled(false);
		d.setBounds(313, 213, 101, 22);
		panel.add(d);

		for (int i = anio; i < anio + 10; i++) {
			y.addItem(i);
		}
		y.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (y.getSelectedIndex() > 0) {
						m.setModel(new DefaultComboBoxModel(
								Funciones.getMeses(anio, y.getSelectedItem().toString(), mes)));
						m.setEnabled(true);
					} else {
						m.setEnabled(false);
					}
				}
			}
		});
		m.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					if (m.getSelectedIndex() > 0) {
						if (m.getSelectedItem().toString() != null && y.getSelectedItem().toString() != null) {
							d.setModel(new DefaultComboBoxModel(
									Funciones.getDias(m.getSelectedItem().toString(), y.getSelectedItem().toString())));
							d.setEnabled(true);
						} else {
							d.setEnabled(false);
						}
					}
				}
			}
		});

		JButton btnVerTodas = new JButton("A\u00F1adir Batalla");
		btnVerTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = y.getSelectedItem() + "-" + m.getSelectedItem() + "-" + d.getSelectedItem();
				try {
					c.EjecutarUpdate(
							"INSERT INTO `consultarbatallas`(`Usuario`, `Local`, `Visitante`, `Fecha`) VALUES ('"
									+ username + "','" + textField.getText() + "','" + textField_1.getText() + "','"
									+ date + "')");
				} catch (SQLException e1) {
					System.out.println("No se pudo ejecutar la cl\u00e1usula.");
				}
			}
		});
		btnVerTodas.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnVerTodas.setBackground(Color.LIGHT_GRAY);
		btnVerTodas.setBounds(261, 281, 153, 30);
		panel.add(btnVerTodas);

	}

}