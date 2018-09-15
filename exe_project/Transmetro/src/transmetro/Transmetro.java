/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transmetro;

import gui.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Movil;
import models.Parada;

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
        new Transmetro().simular_bd("CONSULTA_DERLY.sql");
        try {Thread.sleep(3000);} catch (Exception e) {if(DEBUG)System.out.println("error del thread principal");e.printStackTrace();}
        flipScreen(new Log()); // ventana de log in
    }
    
    public static int error;
    
    public static boolean DEBUG = true;
    public static ArrayList<Movil> moviles;
    public static ArrayList<Parada> paradas;
    
    //<editor-fold defaulstate="collapsed" desc="SIMULAR BBDD">
    
    private void simular_bd(String sql_file)
    {   
        try 
        {
            start_all(sql_file);
        }
        catch (java.io.FileNotFoundException ioe) 
        {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRÓ EL ARCHIVO SQL", "Archivo inexistente", 0);
            if(transmetro.Transmetro.DEBUG)System.out.println("no se encontró el archivo");
            if(transmetro.Transmetro.DEBUG)ioe.printStackTrace();
        }
        catch (java.io.IOException ioe) 
        {
            if(transmetro.Transmetro.DEBUG)System.out.println("error de archivo");
            if(transmetro.Transmetro.DEBUG)ioe.printStackTrace();
        }
    }
    
    private void start_all(String fr) throws java.io.IOException , java.io.FileNotFoundException
    {
        Runnable paradas = new Runnable() 
        {
            @Override
            public void run()
            {
                try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fr)))
                {
                    FileWriter fw = new FileWriter("out_paradas");
                    BufferedWriter writer = new BufferedWriter(fw);
                    String line;
                    String[] values;
                    while((line=reader.readLine())!=null)
                    {
                        if(!line.contains("insert into")) {writer.write(line);writer.newLine();continue;};
                        if(line.contains("HistoriaViajes")) break;
                        if(line.contains("NULL")) { ++error;   continue; };
                        writer.write(line);writer.newLine();
                        line = line.substring(line.indexOf("("), line.indexOf(")"));
                        values = line.split(",");
                        
                        
                        
                    }
                    reader.close();
                }
                catch (Exception e)
                {
                    if(transmetro.Transmetro.DEBUG) System.out.println("Error en el hilo de separado de paradas");
                    if(transmetro.Transmetro.DEBUG) e.printStackTrace();
                }
            }
        };
        
        Runnable historias = new Runnable() 
        {
            @Override
            public void run()
            {
                try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fr)))
                {
                    FileWriter fw = new FileWriter("out_historias");
                    BufferedWriter writer = new BufferedWriter(fw);
                    String line;
                    String[] values;
                    while((line=reader.readLine())!=null)
                    {
                        if(!line.contains("HistoriaViajes")|| !line.contains("insert into")) continue;
                        if(line.contains("NULL")) { ++error;   continue; };
                        writer.write(line);;writer.newLine();
                        line = line.substring(line.indexOf("("), line.indexOf(")"));
                        values = line.split(",");
                        
                    }
                    reader.close();
                }
                catch (Exception e)
                {
                    if(transmetro.Transmetro.DEBUG) System.out.println("Error en el hilo de separado de paradas");
                    if(transmetro.Transmetro.DEBUG) e.printStackTrace();
                }
            }
        };
        
        try 
        {
            paradas.run();
            historias.run();
            Thread.sleep(3000);
            write_new_db(new java.io.FileReader("out_paradas"),new java.io.FileReader("out_historias"));
        }
        catch (Exception e)
        {
            if(transmetro.Transmetro.DEBUG) {System.out.println("error de threading o transcripción");e.printStackTrace();}
        }
    }
    
    private void write_new_db(java.io.FileReader paradas,java.io.FileReader historias)
    {
        try (BufferedReader reader1 = new BufferedReader(paradas);BufferedReader reader2 = new BufferedReader(historias))
        {
            java.io.FileWriter fw = new FileWriter("nuevosql.sql");
            
            //escribir headers y paradas
            BufferedWriter esc = new BufferedWriter(fw);
            String txt;
            while((txt=reader1.readLine())!=null){esc.write(txt);esc.newLine();}
            esc.close();
            
            fw = new FileWriter("nuevosql.sql",true);
            
            //escribir historias
            esc = new BufferedWriter(fw);
            while((txt=reader2.readLine())!=null){esc.write(txt);esc.newLine();}
            esc.close();
        }
        catch (Exception e)
        {
            if(transmetro.Transmetro.DEBUG) System.out.println("Error en el hilo de transcripción");
            if(transmetro.Transmetro.DEBUG) e.printStackTrace();
        }
    }
    
    //</editor-fold>
    
    
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
