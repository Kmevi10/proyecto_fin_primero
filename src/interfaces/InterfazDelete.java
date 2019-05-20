package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBBDD.Conectar;
import Funciones.Funciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;

public class InterfazDelete extends JFrame {

	private JPanel contentPane;

	public InterfazDelete(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Conectar c = new Conectar();
		c.Conectar();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblBorrarBatalla = new JLabel("Borrar Batalla");
		lblBorrarBatalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarBatalla.setFont(new Font("Segoe Print", Font.BOLD, 23));
		lblBorrarBatalla.setBounds(10, 11, 437, 32);
		panel.add(lblBorrarBatalla);

		JLabel lblAquDeberPoner = new JLabel(
				"Aqu\u00ED deber\u00E1 poner el nombre del participante local de la batalla que");
		lblAquDeberPoner.setBounds(20, 54, 394, 25);
		panel.add(lblAquDeberPoner);

		JLabel lblQuieraBorrar = new JLabel("quiera borrar:");
		lblQuieraBorrar.setBounds(20, 59, 394, 40);
		panel.add(lblQuieraBorrar);

		JComboBox date = new JComboBox();
		date.setEnabled(false);
		date.setBounds(20, 272, 151, 25);
		panel.add(date);

		JComboBox visitante = new JComboBox();
		visitante.setEnabled(false);
		visitante.setBounds(20, 195, 151, 25);
		panel.add(visitante);

		JComboBox local = new JComboBox();
		String[] locales = c.EjecutarSentencia(
				"SELECT local FROM consultarbatallas WHERE Usuario LIKE '" + username + "'", "local");
		for (int i = 0; i < locales.length + 1; i++) {
			if (i == 0) {
				local.addItem("");
			} else {
				local.addItem(locales[i - 1]);
			}
		}
		local.setBounds(20, 103, 151, 25);
		panel.add(local);
		local.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (local.getSelectedIndex() > 0) {
					visitante.setModel(new DefaultComboBoxModel(
							Funciones.getVisitantes(local.getSelectedItem().toString(), username)));
					visitante.setEnabled(true);
					date.setEnabled(false);
				} else {
					visitante.setEnabled(false);
				}
			}
		});
		visitante.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (visitante.getSelectedIndex() > 0) {
					date.setModel(new DefaultComboBoxModel(Funciones.getFechas(local.getSelectedItem().toString(),
							visitante.getSelectedItem().toString(), username)));
					date.setEnabled(true);
				} else {
					date.setEnabled(false);
				}
			}
		});

		JLabel lblAquDeberPoner_1 = new JLabel(
				"Aqu\u00ED deber\u00E1 poner el nombre del participante visitante de la batalla que");
		lblAquDeberPoner_1.setBounds(20, 150, 448, 19);
		panel.add(lblAquDeberPoner_1);

		JLabel label = new JLabel("quiera borrar:");
		label.setBounds(20, 152, 448, 40);
		panel.add(label);

		JLabel lblAContinuacinDeber = new JLabel("A continuaci\u00F3n deber\u00E1 poner la fecha de la batalla:");
		lblAContinuacinDeber.setBounds(20, 242, 394, 19);
		panel.add(lblAContinuacinDeber);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazHome h = new InterfazHome(username);
				h.setVisible(true);
				dispose();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 335, 180, 30);
		panel.add(btnVolver);

		JButton button = new JButton("Ver batallas");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazVisualizar v = new InterfazVisualizar(username, 2);
				v.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Monospaced", Font.PLAIN, 11));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(360, 13, 128, 30);
		panel.add(button);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!local.getSelectedItem().equals("") && !visitante.getSelectedItem().equals("")
						&& !date.getSelectedItem().equals("")) {
					ImageIcon icon = new ImageIcon("src/Imagenes/OK.png");
					int opc = JOptionPane.showConfirmDialog(null, "¿Est\u00e1 seguro de eleminar esa batalla?",
							"Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
					if (opc == JOptionPane.YES_OPTION) {
						try {
							Conectar.EjecutarUpdate("DELETE FROM `consultarbatallas` WHERE Usuario LIKE ('" + username
									+ "') AND local LIKE ('" + local.getSelectedItem().toString()
									+ "') AND visitante LIKE ('" + visitante.getSelectedItem().toString()
									+ "') AND fecha LIKE ('" + date.getSelectedItem().toString() + "')");
						} catch (SQLException e1) {
						}
						InterfazDelete d = new InterfazDelete(username);
						d.setVisible(true);
						dispose();
					}
				} else {
					ImageIcon icon = new ImageIcon("src/Imagenes/ERROR.png");
					JOptionPane.showConfirmDialog(null,
							"No puede dejar casillas vac\u00edas, por favor, rellena todas y despu\u00e9s contin\u00fae.", "Error",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
				}
			}
		});
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnConfirmar.setBackground(Color.LIGHT_GRAY);
		btnConfirmar.setBounds(308, 335, 180, 30);
		panel.add(btnConfirmar);

	}
}
