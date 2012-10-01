package client;

import helpclasses.CommMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * SocketClient creates a connection for the client to the server
 * The SocketClient object must be constructed with a valid server name
 * and port. Make sure the port is available (e.g new SocketClient("localhost", 1337);)
 * @author Jama
 *
 */
public class SocketClient {

	Socket clientSocket;
	ObjectOutputStream out; //Objects of a classes that implement Serializable can be sent out
	ObjectInputStream in; // --//-- in
	String servName;
	int port;
	

	public SocketClient(String server, int port) 
	{
		this.servName = server;
		this.port = port;
	}

	/**
	 * Must run this to establish connection
	 */
	public void run()
	{
		try
		{
			clientSocket = new Socket(servName, port);
			System.out.println("Connected to "+servName+" in port: "+port);
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(clientSocket.getInputStream());
			
			
		}
		catch(UnknownHostException e)
		{
			System.err.println("Couldn't find host: "+e.getMessage());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Sends a message to the server, this message is an object of a class.
	 * Probably class Message, could even be a simple String.
	 * @param o The object to be sent
	 */
	public void sendMessage(CommMessage<?> o)
	{
		try
		{
			out.writeObject(o);
			out.flush();
			System.out.println("client>" + o.getMessageName());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		

		// TODO: wait for reply!

	}

	public void close()
	{
		try
		{
			in.close();
			out.close();
			clientSocket.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
