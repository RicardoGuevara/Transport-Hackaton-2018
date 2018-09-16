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
public class Movil {

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Movil(String ruta, short servicio) {
        this.ruta = ruta;
        this.servicio = servicio;
        viajes = new ArrayList<Viaje>();
        transmetro.Transmetro.moviles.add(this);
    }
    
    public Movil(String ruta, short servicio, Viaje viaje) 
    {
        this(ruta,servicio);
        viajes.add(viaje);
    }
    
    @Override
    public String toString()
    {
        return this.getRuta()+" "+this.getServicio();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METODOS">
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ATRIBUTOS">
    
    String ruta;
    short servicio;
    ArrayList<Viaje> viajes;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public short getServicio() {
        return servicio;
    }

    public void setServicio(short servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }
    
    
    //</editor-fold>
    
}
