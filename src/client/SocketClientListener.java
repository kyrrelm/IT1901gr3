package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import server.ServerThread;

import helpclasses.*;



/**
 * This is an attempt to make the connection asynchronous, we had to make it halfway because of time constraints.
 * Meaning that if there is a timeout of larger than 10 seconds the application will simply exit with an error explaining why.
 * This rarely happens though and since there is never any significant temporary data in the application the inconvenience is minor.
 * 
 * TODO in 2013 :p
 * Give each message sent to server an unique MessageID that the client waits for or some such.
 * 
 * 
 * @author halvor
 *
 */
public class SocketClientListener extends Thread
{
	static int count = 0;
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
				else if (message.getMessageName() == CommEnum.NEWALARM)
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
	/**
	 * Gets Last Messages from the server
	 * @return LinkedList<CommMessage<?>>
	 */
	public CommMessage<?> getLatestMessage()
	{
		// hvis denne metoden blir kalt før listenToInput er ferdig -> vent litt så gjør det igjen.
		if (messageQueue.isEmpty())
		{	
			count += 100;
			System.out.println("EMPTY");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count > 10000){
				JOptionPane.showMessageDialog(Client.hub,
						"Lost connection to the server.\nRestart the client and try again,\nor contact your system administrator", " Connection Error",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);	
			}
			return getLatestMessage();
		}
		count = 0;
		return messageQueue.pop();
	}
}
