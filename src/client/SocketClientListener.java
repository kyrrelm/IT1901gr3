package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import server.ServerThread;

import helpclasses.*;

public class SocketClientListener extends Thread
{
	ObjectInputStream in;
	LinkedList<CommMessage<?>> messageQueue;
	boolean stop = false;
	public SocketClientListener(ObjectInputStream in)
	{
		this.in = in;
		messageQueue = new LinkedList<CommMessage<?>>();
		
	}
	@Override
	public void run()
	{
		listenToInput();
	}
	public void stopThread()
	{
		stop = true;
	}
	
	private void listenToInput()
	{
		while(!stop)
		{
			try {
				CommMessage<?> message = (CommMessage<?>) in.readObject();
				
				
				if (message.getMessageName() == CommEnum.NEWMESSAGES)
				{
					ClientUnpacker.unpackClientMessage(message);
				}
				else
					messageQueue.add(message);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Class not recognized");
			} catch (IOException e) {
				//e.printStackTrace();
				System.err.println("Socket closed!");
				stopThread();
			}
			
			/** TRUKKE DET HER TRENGS!
			// sleep for a while!
	        try {
				ServerThread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
		}
	}
	
	public CommMessage<?> getLatestMessage()
	{
		// hvis denne metoden blir kalt før listenToInput er ferdig -> vent litt så gjør det igjen.
		if (messageQueue.isEmpty())
		{
			System.out.println("EMPTY");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return getLatestMessage();
		}
		System.out.println("NOT EMPTY!");
		return messageQueue.pop();
	}
}
