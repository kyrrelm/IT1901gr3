/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import gui.Hub;
import gui.Login;

import javax.swing.SwingUtilities;

/**
 *
 * @author Kyrre
 */
public class Client {
    
     public static Login login;
     public static Hub hub;
     public static SocketClient sockCli;

    public static void main(String[] args) {
    	
    	sockCli = new SocketClient("localhost", 6667);
	sockCli.run();
        login = new Login();
        hub = new Hub();
    	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				login.setVisible(true);
				
			}
		});
    	
    	//sockCli.close();
       
    }
    
}

