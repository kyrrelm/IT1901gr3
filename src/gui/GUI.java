package gui;

import javax.swing.SwingUtilities;

// @author Kyrre

public class GUI {
    
     static Login login = new Login();
     static Hub hub = new Hub();

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				login.setVisible(true);
				
			}
		});
    }
}
