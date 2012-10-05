/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.SwingUtilities;
import client.SocketClient;

/**
 *
 * @author Kyrre
 */
public class GUI {
    
     static Login login = new Login();
     static Hub hub = new Hub();
     static SocketClient sockCli;

    public static void main(String[] args) {
    	
    	sockCli = new SocketClient("localhost", 6667);
		sockCli.run();
    	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				login.setVisible(true);
                                hub.clearPanels();
				
			}
		});
    	
    	//sockCli.close();
       
    }
}

