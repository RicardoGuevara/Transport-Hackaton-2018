/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transmetro;

import gui.Log;

/**
 *
 * @author rick
 */
public class Transmetro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        flipScreen(new Log()); // ventana de log in
    }
    
    public static boolean DEBUG = true;
    
    //<editor-fold defaultstate="collapsed" desc="CAMBIO DE PANTALLAS">
    
    private static javax.swing.JFrame   actScreen, // ventana actual
                                        antScreen; // ventana anterior
    
    /**
     * Cambio de entorno gráfico
     * @param screen _ nueva pantalla visible
     */
    public static void flipScreen(javax.swing.JFrame screen)
    {
        try 
        {
            antScreen = actScreen;
            antScreen.dispose();
        }
        catch (NullPointerException npe)
        {
            antScreen = actScreen;
            if (DEBUG)
            {
                System.out.println("Ventana anterior vacía"); 
                npe.printStackTrace();
            }
        }
        actScreen = screen;
        
        java.awt.EventQueue.invokeLater(
                new Runnable() 
                {
                    public void run() { actScreen.setVisible(true); }
                });
    }
    
    /**
     * revertir un cambio de entorno gráfico
     */
    public static void flipScreen()
    {
        flipScreen(antScreen);
    }
    
    //</editor-fold>
    
}
