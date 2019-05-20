package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import ConexionBBDD.Conectar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InterfazVisualizarTodo extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private JPanel panel;
	private Conectar c;
	private DefaultTableModel modelo;

	public InterfazVisualizarTodo(String username, int num) {
		
		c = new Conectar();
		c.Conectar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240,240,240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		modelo = new DefaultTableModel();
		
		tabla = new JTable(modelo);
		tabla.setEnabled(false);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setBackground(new Color(220, 220, 220));
		tabla.setBounds(21, 84, 378, 221);
		panel.add(tabla);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (username != null) {

					InterfazVisualizar v = new InterfazVisualizar(username,num);
					v.setVisible(true);
					dispose();
					
				} else {
					
					InterfazHome h = new InterfazHome(username);
					h.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(194, 316, 216, 30);
		panel.add(btnNewButton);
		
		JLabel lblTodasLasBatallas = new JLabel("Todas las batallas");
		lblTodasLasBatallas.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblTodasLasBatallas.setForeground(new Color(51,51,51));
		lblTodasLasBatallas.setBounds(194, 11, 216, 22);
		panel.add(lblTodasLasBatallas);
		String[] local = c.EjecutarSentencia("SELECT local FROM consultarbatallas ORDER BY consultarbatallas.Fecha ASC", "local");
		String[] visitante = c.EjecutarSentencia("SELECT visitante FROM consultarbatallas ORDER BY consultarbatallas.Fecha ASC", "visitante");
		String[] fecha = c.EjecutarSentencia("SELECT fecha FROM consultarbatallas ORDER BY consultarbatallas.Fecha ASC", "fecha");
		modelo.addColumn("Local");
		modelo.addColumn("Visitante");
		modelo.addColumn("Fecha");
		for (int i = 0; i < local.length; i++) {
			
			String[] fila = {local[i], visitante[i], fecha[i]};
			modelo.addRow(fila);
			
		}
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(21, 44, 519, 261);
		panel.add(scroll);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	}

}