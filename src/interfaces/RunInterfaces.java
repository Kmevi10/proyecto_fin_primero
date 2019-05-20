package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class RunInterfaces extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazWelcome frame = new InterfazWelcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
