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
public class Viaje {
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Viaje(String fecha, String ruta, String servicio,int orden_parada, int parada, String llegada, String llegada_real, String salida, String salida_real) {
        int y=Integer.parseInt(fecha.substring(1,5)),
            m=Integer.parseInt(fecha.substring(6,8)),
            d=Integer.parseInt(fecha.substring(9,11));
        this.fecha = new Date(y,m,d);
        this.orden_parada = orden_parada;
        this.parada = parada;
        this.llegada = llegada;
        this.llegada_real = llegada_real;
        this.salida = salida;
        this.salida_real = salida_real;
        if ( (this.movil=transmetro.Transmetro.getMovil(ruta, servicio))==null) 
        {
            this.movil=new Movil(ruta,Short.parseShort(servicio));
        }
        movil.viajes.add(this);
    }
    
    public Viaje(String[] values)
    {
        this(   values[0],
                values[1],
                values[2],
                Integer.parseInt(values[3]),
                Integer.parseInt(values[4]),
                values[5],
                values[6],
                values[7],
                values[8]);
    }
    
    @Override
    public String toString()
    {
        return this.parada+" "+this.llegada+" "+this.salida;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METODOS">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ATRIBUTOS">
    
    Date fecha;
    int orden_parada;
    int parada;
    String  llegada,
            llegada_real,
            salida,
            salida_real;
    Movil movil;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getOrden_parada() {
        return orden_parada;
    }

    public void setOrden_parada(int orden_parada) {
        this.orden_parada = orden_parada;
    }

    public int getParada() {
        return parada;
    }

    public void setParada(int parada) {
        this.parada = parada;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getLlegada_real() {
        return llegada_real;
    }

    public void setLlegada_real(String llegada_real) {
        this.llegada_real = llegada_real;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getSalida_real() {
        return salida_real;
    }

    public void setSalida_real(String salida_real) {
        this.salida_real = salida_real;
    }

    public Movil getMovil() {
        return movil;
    }

    public void setMovil(Movil movil) {
        this.movil = movil;
    }

       
    //</editor-fold>
    
}
