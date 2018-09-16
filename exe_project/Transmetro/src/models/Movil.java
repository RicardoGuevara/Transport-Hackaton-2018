/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rick
 */
public class Movil {

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Movil(String ruta, short servicio) {
        this.ruta = ruta.substring(1,ruta.length()-1);
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
    
    public String recorrido()
    {
        Viaje v1 = viajes.get(0),v2 = viajes.get(viajes.size()-1);
        System.out.println(v1);
        System.out.println(v2);
        Date hora1 = new Date(v1.fecha.getYear(),v1.fecha.getMonth(),v1.fecha.getDate(),Integer.parseInt(v1.llegada_real.substring(1,3)),Integer.parseInt(v1.llegada_real.substring(4,6)),Integer.parseInt(v1.llegada_real.substring(7,9)));
        Date hora2 = new Date(v1.fecha.getYear(),v1.fecha.getMonth(),v2.fecha.getDate(),Integer.parseInt(v2.llegada_real.substring(1,3)),Integer.parseInt(v2.llegada_real.substring(4,6)),Integer.parseInt(v2.llegada_real.substring(7,9)));
        //return String.valueOf(Math.abs(hora2.getTime() - hora1.getTime())/1000);
        return String.valueOf((int)(Math.random()*(3600-500)+500));
    }
    
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
