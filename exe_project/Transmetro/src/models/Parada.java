/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author rick
 */
public class Parada {
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Parada(int id, String nombre, float x, float y)
    {
        this.id = id;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }
    
    public Parada(String[] values)
    {
        this.id = Integer.parseInt(values[0]);
        this.nombre = values[1];
        this.x = Float.parseFloat(values[2]);
        this.y = Float.parseFloat(values[3]);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METODOS">
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ATRIBUTOS">
    
    int id;
    String nombre;
    float   x,y;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    //</editor-fold>
    
}
