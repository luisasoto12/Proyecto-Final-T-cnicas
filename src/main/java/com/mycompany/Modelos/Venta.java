/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelos;

import java.sql.Date;

/**
 *
 * @author Luisa Soto
 */
public class Venta {
    Propietario propietario;
    Casa casa;
    Date fecha;
    float precio;
    
    public Venta() {
    }

    public Venta(Propietario propietario, Casa casa, Date fecha, float precio) {
        this.propietario = propietario;
        this.casa = casa;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    
}
