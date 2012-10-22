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
		// brukernavn s� jeg � logge meg p� mysqladmin hele tida: Superman3440/Sheep

		sockCli = new SocketClient("localhost", 6667);
		sockCli.run();
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				login = new Login();
				hub = new Hub();
				login.setVisible(true);

			}
		});

		//sockCli.close();

	}

}

