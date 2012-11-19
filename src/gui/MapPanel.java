package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.javafx.application.PlatformImpl;
/**
 * A JPanel with a sub JFXPanel showing the local web page map.html
 * @author halvor
 *
 */
public class MapPanel extends JPanel{
	private JFXPanel jfxPanel;
	private WebView webView;
	private WebEngine webEngine;
	
	
	public final static String localURL = "map/kart.html";
	
	public MapPanel()
	{
		
		initComponents();
	}
	
	
	// kun for testing
	public static void main(String ...args)
	{
		//force ipv4
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                // Create a Swing Frame
                final JFrame frame = new JFrame();  
                frame.setMinimumSize(new Dimension(547, 563));  
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                  
                // Add the Swing JPanel and make visible
                //frame.getContentPane().add(new MapPanel());  
                
                
                JPanel lolPanel = new JPanel();
                lolPanel.setPreferredSize(new Dimension(540, 560));
                frame.getContentPane().add(lolPanel);
                
                lolPanel.add(new MapPanel());
                
                
                frame.setVisible(true);
            }  
        }); 
	}
	
	private void initComponents()
	{
		jfxPanel = new JFXPanel();
		
		createScene();
		
		setLayout(new BorderLayout());
		add(jfxPanel, BorderLayout.CENTER);
		setBackground(new Color(0, 0, 0));
	}
	
	private void createScene()
	{
		PlatformImpl.startup(
	            new Runnable() {
	            	
	            	@Override
	                public void run() {  
	                    Group root = new Group();  
	                    Scene scene = new Scene(root, 540, 540);
	                    webView = new WebView();
	                    root.getChildren().add(webView);
	                    jfxPanel.setScene(scene);
	                    webView.setMinSize(540, 540);
	                    webView.setMaxSize(540, 540);
	                    
	                    //URL url = getClass().getResource("/" + localURL);
	            		//System.out.println(url.toExternalForm());
	            		//System.out.println("LOL?");
	            		//String path = 
	            		URL url = null;
	            		String filePath = new File(MapPanel.class.getProtectionDomain().getCodeSource().getLocation().getPath()).toURI().toString();
	            		// trim bort /. fra filePath
	            		//System.out.println(filePath);
	            		if (filePath.charAt(filePath.length()-2) == '.')
	            			filePath = filePath.substring(0, filePath.length() - 2);
	            		
	            		//System.out.println(filePath);
						try {
							url = new URL(filePath + gui.MapPanel.localURL);
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return;
						}
						//System.out.println(url.toString());
						
	            		webEngine = webView.getEngine();
	            		webEngine.load(url.toExternalForm());
	                    
	                    

	                }

	            	 
	            	
	            });  
	}
	
	public void reload()
	{
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				webEngine.reload();
				
			}
			
		});
	}
	
}
