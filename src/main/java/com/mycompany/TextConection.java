/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luisa Soto
 */
public class TextConection {

    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/Inmobiliaria";
        String nombreUsuario = "root";
        String contraseña = "root";

    

   
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, nombreUsuario, contraseña);
            System.out.println("Conexión exitosa"+conexion);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado");

        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos");
        }
       
    }
}
