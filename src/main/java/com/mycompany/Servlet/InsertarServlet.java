/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Servlet;

import jakarta.servlet.annotation.WebServlet;
import com.mycompany.Dao.CasaDAO;
import com.mycompany.Modelos.Casa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Luisa Soto
 */
@WebServlet("/insertar")
public class InsertarServlet extends HttpServlet {
    private CasaDAO casaDao;

    
    public InsertarServlet() {
        this.casaDao = new CasaDAO();
    }
    //Post, put, get, delete -> Métodos http
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String direccion=request.getParameter("direccion");
        float precio=Float.parseFloat(request.getParameter("precio"));
        String ciudad=request.getParameter("ciudad");
        String pais=request.getParameter("pais");
        String tipo=request.getParameter("tipo");
        Casa casa= new Casa(precio, direccion, ciudad, pais, tipo);
        
        casaDao.insertarCasa(casa);
        response.sendRedirect("/");
        
    }
    
    
}
