package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InterfazWelcome extends JFrame {

	private JPanel contentPane;

	public InterfazWelcome() {
		
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
		
		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setBounds(145, 8, 114, 45);
		txtrLogin.setForeground(Color.DARK_GRAY);
		txtrLogin.setBackground(new Color(220, 220, 220));
		txtrLogin.setFont(new Font("Segoe Print", Font.BOLD, 23));
		txtrLogin.setEditable(false);
		txtrLogin.setText("BatallasG");
		panel.add(txtrLogin);
		
		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setText("Bienvenido al gestor de batallas de rap");
		txtrContrasea.setForeground(Color.DARK_GRAY);
		txtrContrasea.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrContrasea.setBackground(new Color(220, 220, 220));
		txtrContrasea.setBounds(34, 64, 319, 22);
		panel.add(txtrContrasea);
		
		JButton btnRegistrarte = new JButton("Entrar sin clave");
		btnRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazHome h = new InterfazHome(null);
				h.setVisible(true);
			}
		});
		btnRegistrarte.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnRegistrarte.setBackground(Color.LIGHT_GRAY);
		btnRegistrarte.setForeground(Color.BLACK);
		btnRegistrarte.setBounds(237, 210, 153, 30);
		panel.add(btnRegistrarte);
		
		JTextArea txtrInertarSiMail = new JTextArea();
		txtrInertarSiMail.setText("mas completo de hoy dia.");
		txtrInertarSiMail.setForeground(Color.DARK_GRAY);
		txtrInertarSiMail.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrInertarSiMail.setEditable(false);
		txtrInertarSiMail.setBackground(new Color(220, 220, 220));
		txtrInertarSiMail.setBounds(34, 87, 330, 22);
		panel.add(txtrInertarSiMail);
		
		JTextArea txtrLaClaveDe = new JTextArea();
		txtrLaClaveDe.setText("Pulsa en entrar para acceder a batallas");
		txtrLaClaveDe.setForeground(Color.DARK_GRAY);
		txtrLaClaveDe.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrLaClaveDe.setEditable(false);
		txtrLaClaveDe.setBackground(new Color(220, 220, 220));
		txtrLaClaveDe.setBounds(34, 128, 330, 22);
		panel.add(txtrLaClaveDe);
		
		JTextArea txtrEnLasQue = new JTextArea();
		txtrEnLasQue.setText("en las que podras hacer infinidad de");
		txtrEnLasQue.setForeground(Color.DARK_GRAY);
		txtrEnLasQue.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrEnLasQue.setEditable(false);
		txtrEnLasQue.setBackground(new Color(220, 220, 220));
		txtrEnLasQue.setBounds(34, 151, 330, 22);
		panel.add(txtrEnLasQue);
		
		JTextArea txtrGestionesATu = new JTextArea();
		txtrGestionesATu.setText("gestiones a tu gusto.");
		txtrGestionesATu.setForeground(Color.DARK_GRAY);
		txtrGestionesATu.setFont(new Font("Miriam Mono CLM", Font.BOLD, 13));
		txtrGestionesATu.setEditable(false);
		txtrGestionesATu.setBackground(new Color(220, 220, 220));
		txtrGestionesATu.setBounds(34, 177, 330, 22);
		panel.add(txtrGestionesATu);
		
		JButton btnNewButton = new JButton("Acceder como root");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InterfazLogin l = new InterfazLogin();
				l.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(34, 210, 153, 30);
		panel.add(btnNewButton);
	}

}
