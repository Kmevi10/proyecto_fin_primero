package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class InterfazVisualizar extends JFrame {
	public InterfazVisualizar() {
		setEnabled(false);
		
		Color fondo = new Color(220,220,220);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(fondo);
		tabbedPane.setBounds(71, 53, 299, 154);
		panel.add(tabbedPane);
	}
}
