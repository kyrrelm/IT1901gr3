package server;

import helpclasses.CommMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerThread extends Thread
{
	
	private Socket connection;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private int number;
	private boolean stop = false;
	private boolean loggedIn = false;
	
	public ServerThread(Socket socket, int threadNumber)  
	{
		super("ServerThread");
		this.number = threadNumber;
		this.connection = socket;
		System.out.println("DEBUG #1: Serverthread made -- threadNumber: " + threadNumber);
		System.out.println("Connection received from " + connection.getInetAddress().getHostName());
		
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
			
			
			// har fjernet muligheten for å sende rene strenger.
			//sendMessage("Connection successful");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run()
	{
		while (!stop)
		{
			// check if connection is to be stopped
			
			// check if there are unsent messages.
			//   -- dunno if needed, if the thread always waits until a reply is sent before accepting new messages...
			// check if there are unread messages.
	        try {
				CommMessage<?> message = (CommMessage<?>) in.readObject();
				
				CommMessage<?> reply = ServerUnpacker.unpackServerMessage(message, this);
				
				if (reply != null)
				{
					sendMessage(reply);
					System.out.println("Server thread #" + number + " sent reply to msg: " + message.getMessageName());
				}
				//
				//System.out.println(message.getMessageName());
				//sendMessage(message);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Class not recognized");
			} catch (IOException e) {
				//e.printStackTrace();
				System.err.println("Socket closed!");
				stopThread();
			}
	        
	        
	        // sleep for a while!
	        try {
				ServerThread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		close();

	}


	public void sendMessage(CommMessage<?> msg)
	{
		try
		{
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg.getMessageName());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void stopThread()
	{
		stop = true;
	}
	
	public void close()
	{
		
		
		out = null;
		in = null;
		connection = null;
	}
	
	public void setLoggedIn(boolean b)
	{
		loggedIn = b;
	}
	
	public boolean getLoggedIn()
	{
		return this.loggedIn;
	}

}
