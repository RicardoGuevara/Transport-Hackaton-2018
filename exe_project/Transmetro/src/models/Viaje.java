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
    public Viaje(Date fecha, int orden_parada, Parada parada, String llegada, String llegada_real, String salida, String salida_real) {
        this.fecha = fecha;
        this.orden_parada = orden_parada;
        this.parada = parada;
        this.llegada = llegada;
        this.llegada_real = llegada_real;
        this.salida = salida;
        this.salida_real = salida_real;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METODOS">
    
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ATRIBUTOS">
    
    Date fecha;
    int orden_parada;
    Parada parada;
    String  llegada,
            llegada_real,
            salida,
            salida_real;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    //</editor-fold>
    
}
