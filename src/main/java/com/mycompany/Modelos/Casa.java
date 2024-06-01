/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelos;

/**
 *
 * @author Luisa Soto
 */
public class Casa {

    private float precio;
    private String direccion;
    private String ciudad;
    private String pais;
    private String tipo;

    public Casa() {
    }

    public Casa(float precio, String direccion, String ciudad, String pais, String tipo) {
        this.precio = precio;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    public Propietario getPropietario() {
//        return propietario;
//    }
//
//    public void setPropietario(Propietario propietario) {
//        this.propietario = propietario;
//    }
    @Override
    public String toString() {
        return "Casa{" + "precio=" + precio + ", direccion=" + direccion + ", ciudad=" + ciudad + ", pais=" + pais + ", tipo=" + tipo + '}';
    }

}
