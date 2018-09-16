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
    public Parada(int id, String nombre, String x, String y)
    {
        this.id = id;
        this.nombre = nombre.substring(1,nombre.length()-1);
        
        x= (x.startsWith("-"))? x.substring(0,3)+"."+x.substring(3):x.substring(0,2)+"."+x.substring(2);
        y= (x.startsWith("-"))? y.substring(0,3)+"."+y.substring(3):y.substring(0,2)+"."+y.substring(2);
        
        if (Float.parseFloat(x)<0) 
        {
            this.x=Float.parseFloat(x);
            this.y=Float.parseFloat(y);
        }
        else
        {
            this.y=Float.parseFloat(y);
            this.x=Float.parseFloat(x);
        }
        transmetro.Transmetro.paradas.add(this);
    }
    
    public Parada(String[] values)
    {
        this(Integer.parseInt(values[0]),values[1],values[2],values[3]);
    }
    
    @Override
    public boolean equals(Object ob)
    {
        return this.id == Integer.parseInt((String)ob);
    }
    
    public String toString()
    {
        return this.nombre + this.x + " " +this.y;
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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    //</editor-fold>

    
}
