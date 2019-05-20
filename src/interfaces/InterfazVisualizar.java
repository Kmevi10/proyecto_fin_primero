package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.Conectar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class InterfazVisualizar extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	
	public InterfazVisualizar(String username, int num) {
		Conectar c = new Conectar();
		c.Conectar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		tabla = new JTable(modelo);
		tabla.setEnabled(false);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setBackground(new Color(220, 220, 220));
		tabla.setBounds(21, 77, 378, 192);
		panel.add(tabla);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num == 1) {
					InterfazHome h = new InterfazHome(username);
					h.setVisible(true);
					dispose();
				} else {
					InterfazDelete d = new InterfazDelete(username);
					d.setVisible(true);
					dispose();
				}
					
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(21, 316, 227, 30);
		panel.add(btnNewButton);
		
		JLabel lblTodasLasBatallas = new JLabel("Batallas de " + username + ":");
		lblTodasLasBatallas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodasLasBatallas.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblTodasLasBatallas.setForeground(new Color(51, 51, 51));
		lblTodasLasBatallas.setBounds(28, 11, 553, 22);
		panel.add(lblTodasLasBatallas);
		
		JButton btnVerTodas = new JButton("Ver todas");
		btnVerTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazVisualizarTodo vt = new InterfazVisualizarTodo(username, num);
				vt.setVisible(true);
				dispose();
			}
		});
		btnVerTodas.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnVerTodas.setBackground(Color.LIGHT_GRAY);
		btnVerTodas.setBounds(344, 316, 224, 30);
		panel.add(btnVerTodas);
		String[] local = c.EjecutarSentencia("SELECT local FROM consultarbatallas WHERE Usuario LIKE ('" + username + "') ORDER BY consultarbatallas.Fecha ASC", "local");
		String[] visitante = c.EjecutarSentencia("SELECT visitante FROM consultarbatallas WHERE Usuario LIKE ('" + username + "') ORDER BY consultarbatallas.Fecha ASC", "visitante");
		String[] fecha = c.EjecutarSentencia("SELECT fecha FROM consultarbatallas WHERE Usuario LIKE ('" + username + "') ORDER BY consultarbatallas.Fecha ASC", "fecha");
		modelo.addColumn("Local");
		modelo.addColumn("Visitante");
		modelo.addColumn("Fecha");
		for (int i = 0; i < local.length; i++) {
			
			String[] fila = {local[i], visitante[i], fecha[i]};
			modelo.addRow(fila);
			
		}
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(21, 44, 547, 261);
		panel.add(scroll);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
}
