/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mycompany.Modelos.Casa;
import com.mycompany.Modelos.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisa Soto
 */
public class VentaDAO {
    private String url = "jdbc:mariadb://localhost:3306/Inmobiliaria";
    private String nombreUsuario = "root";
    private String contraseña = "root";

    private static final String INSERTAR_VENTA = "INSERT INTO Ventas (propietario_id, casa_id, fecha_adquision, precio_casa) VALUES (?,?,?,?)";

    protected Connection conectarBase() {
        Connection conexion = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url, nombreUsuario, contraseña);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado");

        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos");
        }
        return conexion;
    }
    public void insertarVenta(Venta nuevaVenta) {
        try (Connection conexion = conectarBase();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_VENTA)) {

            // Aquí se asume que los IDs de propietario y casa son String, adaptar si es necesario
            preparedStatement.setString(1, nuevaVenta.getPropietario().getId());
            preparedStatement.setString(2, nuevaVenta.getCasa().getDireccion());
            preparedStatement.setDate(3, new java.sql.Date(nuevaVenta.getFecha().getTime()));
            preparedStatement.setFloat(4, nuevaVenta.getPrecio());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar una venta: " + e.getMessage());
        }
    }
    
}
