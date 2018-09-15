package maploader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
  
/** 
 * SwingFXWebView 
 */  
public class NavegadorPrueba extends JPanel {  
     
    private Stage stage;  
    private WebView browser;  
    private JFXPanel jfxPanel;  
    private JButton swingButton;  
    private WebEngine webEngine;  
    public static String ruta;
  
    public NavegadorPrueba(String ruta){  
        
        changePag(ruta);
        initComponents();  
    }  
  
    public static void main(String ...args){  
        // Run this later:
        SwingUtilities.invokeLater(new Runnable() {  
            @Override
            public void run() {  
                final JFrame frame = new JFrame();  
                 
                frame.getContentPane().add(new NavegadorPrueba(ruta));  
                 
                frame.setMinimumSize(new Dimension(640, 480));  
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                frame.setVisible(true);  
            }  
        });     
    }  
     
    private void initComponents(){  
         
        jfxPanel = new JFXPanel();  
        createScene();  
         
        setLayout(new BorderLayout());  
        add(jfxPanel, BorderLayout.CENTER);  
         
        swingButton = new JButton();  
        swingButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        webEngine.reload();
                    }
                });
            }
        });  
        swingButton.setText("Reload");  
         
        add(swingButton, BorderLayout.SOUTH);  
    }     
     
    public void changePag(String ruta){
        
        java.io.File file = new java.io.File(ruta);
        
        if(transmetro.Transmetro.DEBUG) System.out.println("sistema operativo: "+System.getProperty("os.name"));
        
        this.ruta = ((System.getProperty("os.name").equals("Mac OS X"))? "file://":"file:///")+java.net.URI.create(file.getAbsolutePath()).toString();
        if(transmetro.Transmetro.DEBUG)System.out.println("parámetro: "+ruta);
        if(transmetro.Transmetro.DEBUG)System.out.println("Valor actual: "+this.ruta);
    }
    
    private void createScene() {  
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  
                 
                stage = new Stage();  
                 
                stage.setTitle("Hello Java FX");  
                stage.setResizable(true);  
   
                Group root = new Group();  
                Scene scene = new Scene(root,80,20);  
                stage.setScene(scene);  
                 
                // Set up the embedded browser:
                browser = new WebView();
                webEngine = browser.getEngine();
                webEngine.load(ruta);
                
                  System.out.println("BROwser: "+ browser.getEngine().getLocation());        
                        
                ObservableList<Node> children = root.getChildren();
                children.add(browser);                     
                 
                jfxPanel.setScene(scene);  
            }  
        });  
    }
}
