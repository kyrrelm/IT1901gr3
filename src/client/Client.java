/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.ConnectException;

import gui.Hub;
import gui.Login;
import gui.RegisterNewUser;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import map.GenerateMap;

/**
 *
 * @author Kyrre
 */
public class Client {

	public static Login login;
    public static RegisterNewUser registerNewUser;
	public static Hub hub;
	public static SocketClient sockCli;
	public static boolean ServerUp = true;
    
	public static void main(String[] args) {
		// brukernavn s� jeg � logge meg p� mysqladmin hele tida: Superman3440/Sheep

		
		//force ipv4
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		
		sockCli = new SocketClient("localhost", 6667);
		
		try {
			sockCli.run();
		} catch (IOException e) {
			ServerUp = false;
		}
		GenerateMap.initGenerator();
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				login = new Login();
                registerNewUser = new RegisterNewUser();
				hub = new Hub();
				login.setVisible(true);

			}
		});

		//sockCli.close();

	}

}

