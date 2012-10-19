package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.javafx.application.PlatformImpl;

public class MapPanel extends JPanel{
	private JFXPanel jfxPanel;
	private WebView webView;
	
	public MapPanel()
	{
		initComponents();
	}
	
	
	// kun for testing
	public static void main(String ...args)
	{
		SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                // Create a Swing Frame
                final JFrame frame = new JFrame();  
                frame.setMinimumSize(new Dimension(640, 480));  
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                  
                // Add the Swing JPanel and make visible
                frame.getContentPane().add(new MapPanel());  
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
	                public void run() {  
	                    Group root = new Group();  
	                    Scene scene = new Scene(root, 540, 560);
	                    webView = new WebView();
	                    root.getChildren().add(webView);
	                    jfxPanel.setScene(scene);
	                    webView.setMinSize(540, 560);
	                    webView.setMaxSize(540, 560);
	                    
	                    loadURL("http://www.google.com");
	                }  
	            });  
	}
	
	public void loadURL(String url)
	{
		WebEngine webEngine = webView.getEngine();
		webEngine.load(url);
		System.out.println("This happened");
	}
	
}
