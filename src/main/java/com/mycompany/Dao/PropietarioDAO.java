/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mycompany.Modelos.Propietario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luisa Soto
 */
public class PropietarioDAO {

    private String url = "jdbc:mariadb://localhost:3306/Inmobiliaria";
    private String nombreUsuario = "root";
    private String contraseña = "root";

    private static final String INSERTAR_PROPIETARIO = "insert into Propietarios (id, nombre, nacionalidad) values (?,?,?)";
    private static final String OBTENER_PROPIETARIO = "select * from propietarios";
    private static final String OBTENER_PROPIETARIO_ID = "select nombre from Propietarios where id=?";

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

    public void insertarPropietario(Propietario nuevoPropietario) {
        try (
                 Connection conexion = conectarBase();  PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_PROPIETARIO)) {
            preparedStatement.setString(1, nuevoPropietario.getId());
            preparedStatement.setString(2, nuevoPropietario.getNombre());
            preparedStatement.setString(3, nuevoPropietario.getNacionalidad());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar un usuario: " + e.getMessage());
        }
    }

    // Se retorna un solo usuario por eso Usuario que es el objeto/modelo que se va a retornar
    public Propietario seleccionarPropietario(String id) {
        Propietario propietario = null;
        try ( Connection conexion = conectarBase();  PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_PROPIETARIO_ID)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                propietario = new Propietario();
                propietario.setId(resultSet.getString("id"));
                propietario.setNombre(resultSet.getString("nombre"));
                propietario.setNacionalidad(resultSet.getString("nacionalidad"));

            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar un usuario por cédula: " + e.getMessage());
        }
        return propietario;
    }

    // Se va a retornar una lista de usuarios por eso List<Usuario>
    public List<Propietario> seleccionarTodoPropietario() {
        // Creando una nueva lista de usuarios
        List<Propietario> propietarios = new ArrayList<>();
        try ( Connection conexion = conectarBase();  PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_PROPIETARIO)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Propietario propietario = new Propietario();
                propietario.setId(resultSet.getString("id"));
                propietario.setNombre(resultSet.getString("nombre"));
                propietario.setNacionalidad(resultSet.getString("nacionalidad"));

                propietarios.add(propietario);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
        }
        return propietarios;
    }

}
