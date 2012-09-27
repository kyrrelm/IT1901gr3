package server;

import helpclasses.CommMessage;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
	Socket connection = null;
	ObjectOutputStream out;
	ObjectInputStream in;
	int port;
	int backlog = 10; //The number of clients we can place in the connection queue, set to 10 for now TODO
	//String message;
	CommMessage message;

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
			connection = servSocket.accept();
			System.out.println("Connection received from " + connection.getInetAddress().getHostName());

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			sendMessage("Connection successful");

			//this is where a thread fork would happen

			//Testing echo TODO
			try
			{
				message = (CommMessage)in.readObject();
				if (message == null)
				{
					System.err.println("null error");
					return;					
				}
					
				sendMessage(message);
			}
			catch(ClassNotFoundException e)
			{
				System.err.println("Class of a serialized object cannot be found.");
			}catch (InvalidClassException e)
			{
				System.err.println("Something is wrong with a class used by serialization.");
			}catch (IOException e)
			{
				System.err.println("Any of the usual Input/Output related exceptions.");
			}
			//end test
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg)
	{
		try
		{
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public void sendMessage(CommMessage msg)
	{
		try
		{
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void close()
	{
		try
		{
			in.close();
			out.close();
			servSocket.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
