/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Servlet;

import com.mycompany.Dao.PropietarioDAO;
import jakarta.servlet.annotation.WebServlet;
import com.mycompany.Modelos.Propietario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Luisa Soto
 */
@WebServlet("/insertarP")
public class InsertarServlet1 extends HttpServlet {

    private PropietarioDAO propietarioDAO;

    public InsertarServlet1() {
        this.propietarioDAO = new PropietarioDAO();
    }

    //Post, put, get, delete -> Métodos http
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String nacionalidad = request.getParameter("nacionalidad");
        Propietario propietario = new Propietario(id, nombre, nacionalidad);
        
        propietarioDAO.insertarPropietario(propietario);
        response.sendRedirect("/");

    }

}   
    

