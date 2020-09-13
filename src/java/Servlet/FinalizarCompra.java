/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Controlador.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Rivero
 */
public class FinalizarCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //necesito la sesion de la persona que va comprar
            HttpSession sesion = request.getSession(true);
            //la fecha de la venta 
            Date dia = new Date();
            
            //obtener los atributos de la sesion de los detalles de las ventas y el stock del pan   
            
            Vector<DVenta> vectorDetalle = (Vector<DVenta>)sesion.getAttribute("detalleVenta");
            
            Vector<MPan> stockPanes = (Vector<MPan>)sesion.getAttribute("stockPanes");
            
            MPan pan = new MPan();
            float totalPagar = 0;
            
            MUsuario usuario = new MUsuario();
            EUsuario eusuario = new EUsuario();
            
            DVenta dventas = new DVenta();
            MVenta venta = new MVenta();
            
            //recorrer todo el detalle de la venta que se realixo de la venta de los panes
            
            for (DVenta dventa : vectorDetalle) {
                //operacion de que pagare
                totalPagar += dventa.getSubtotal_dventa();
            }
            
            
            //este se tiene que ajustar para que se obtenga el usuario
            dventas.setId_eusu(eusuario.getId_eusu());
            
            
            venta.setFecha_venta(dia.toString());
            venta.setTotal_venta(totalPagar);
            
            //ahora son las operaciones para registrar la venta y dventa
            
            boolean registrarVenta = venta.registrarVenta(venta, vectorDetalle);
            boolean actualizarVentaStock = pan.actualizarStock(stockPanes); 
            
            if (registrarVenta != actualizarVentaStock) {
                response.sendRedirect("Mensaje.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
