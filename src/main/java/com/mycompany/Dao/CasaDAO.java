/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mycompany.Modelos.Casa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisa Soto
 */
public class CasaDAO {

    private String url = "jdbc:mariadb://localhost:3306/Inmobiliaria";
    private String nombreUsuario = "root";
    private String contraseña = "root";

    private static final String INSERTAR_CASA = "insert into Casas (direccion, precio, ciudad, pais, tipo) values (?,?,?,?,?)";
    private static final String OBTENER_CASA = "select * from casas";
    private static final String OBTENER_CASA_DIRECCION = "select precio from Casas where direccion=?";

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

    public void insertarCasa(Casa nuevaCasa) {
        try (
                 Connection conexion = conectarBase();  PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_CASA)) {
            preparedStatement.setString(1, nuevaCasa.getDireccion());
            preparedStatement.setFloat(2, nuevaCasa.getPrecio());
            preparedStatement.setString(3, nuevaCasa.getCiudad());
            preparedStatement.setString(4, nuevaCasa.getPais());
            preparedStatement.setString(5, nuevaCasa.getTipo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar un usuario: " + e.getMessage());
        }
    }

    // Se retorna un solo usuario por eso Usuario que es el objeto/modelo que se va a retornar
    public Casa seleccionarCasa(String direccion) {
        Casa casa = null;
        try ( Connection conexion = conectarBase();  PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_CASA_DIRECCION)) {
            preparedStatement.setString(1, direccion);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                casa = new Casa();
                casa.setDireccion(resultSet.getString("direccion"));
                casa.setPrecio(resultSet.getFloat("precio"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setTipo(resultSet.getString("tipo"));

            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar un usuario por cédula: " + e.getMessage());
        }
        return casa;
    }

    // Se va a retornar una lista de usuarios por eso List<Usuario>
    public List<Casa> seleccionarTodasCasas() {
        // Creando una nueva lista de usuarios
        List<Casa> casas = new ArrayList<>();
        try ( Connection conexion = conectarBase();  PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_CASA)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Casa casa = new Casa();
                casa.setDireccion(resultSet.getString("direccion"));
                casa.setPrecio(resultSet.getInt("precio"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setTipo(resultSet.getString("tipo"));

                casas.add(casa);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
        }
        return casas;
    }
}
