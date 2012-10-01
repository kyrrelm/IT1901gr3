package server;

import helpclasses.CommMessage;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * SocketServer listens to any connections made on its port. A SocketServer object must be constructed with a
 * valid, available port number as parameter. This connection uses ObjectStream which means that any class that 
 * implements the Serializable interface can be sent without being broken down. Care must be taken to preserve
 * proper casting on the other end.
 * 
 * v.01: Foundation laid for Client-server communication
 * 
 * NOTE: In order for multiple connections to be handled simultaneously, a new thread
 * must be created for each connection. THIS HASN'T BEEN IMPLEMENTED
 * @author Jama
 *
 */
public class SocketServer {

	ServerSocket servSocket;
	int port;
	int backlog = 10; //The number of clients we can place in the connection queue, set to 10 for now TODO
	ArrayList<ServerThread> threads = new ArrayList<ServerThread>();

	public SocketServer(int port) 
	{
		this.port = port;
	}

	public void run()
	{
		try
		{
			servSocket = new ServerSocket(port, backlog);
			System.out.println("Waiting for connection");
			
			ServerThread tempThread;
			int threadNumber = 0;
			while (true)
			{
				tempThread = new ServerThread(servSocket.accept(), threadNumber);
				tempThread.start();
				threads.add(tempThread);
				threadNumber ++;
			}

			//this is where a thread fork would happen
			
			//Testing echo TODO
			/*
			try {
				message = (CommMessage<?>) in.readObject();
				System.out.println(message.getMessageName());
				sendMessage(message);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Class not recognized");
			}
			*/
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	

	public void close()
	{
		try
		{
			for (ServerThread thread: threads)
			{
				thread.close();
			}
			servSocket.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
