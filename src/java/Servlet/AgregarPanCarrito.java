/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jorge Rivero
 */
public class AgregarPanCarrito extends HttpServlet {

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
            
            //obtener la sesion del usuario que realizara las compras de los panes 
            
            HttpSession sesion = request.getSession();
            
            //obtener el vector de los panes y el detalle de compra de los panes
            
            Vector<DVenta> vectorDetalle = null;
            Vector<MPan> stockPanes = null;
            
            //si la sesion es valida debemos de obtener sus atributos para
            //saber que panes han escogido o los han agregado al carrito
            
            if (sesion.getAttribute("detalleVenta") != null) {
                //que si hay panes en el cc
                vectorDetalle = (Vector<DVenta>)sesion.getAttribute("detalleVenta");
                stockPanes = (Vector<MPan>)sesion.getAttribute("stockPanes");
            }else{
                //hay que crear los detalles de venta y stock
                vectorDetalle = new Vector<DVenta>();
                stockPanes = new Vector<MPan>();
            }
            
            //obtenemos los parametros de los formularios de la venta
            int codigo, cantidad;
            
            codigo = Integer.parseInt(request.getParameter("id"));
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            MPan pan = new MPan();
            pan = pan.buscarPan(codigo);
            
            float subtotal = 0;
            subtotal = cantidad *pan.getPre_pan();
            
            //obtener el detalle de la venta del pan
            
            DVenta detalleVentas = new DVenta();
            detalleVentas.setId_venta(vectorDetalle.size());
            
            detalleVentas.setId_pan(codigo);
            detalleVentas.setSubtotal_dventa(subtotal);
            detalleVentas.setCant_dventa(cantidad);
            
            //se agrega al vector
            
            vectorDetalle.add(detalleVentas);
            sesion.setAttribute("detalleVenta", vectorDetalle);
            
            //actualizar el stock de los panes
            
            pan.setStock_pan(pan.getStock_pan()-cantidad);
            stockPanes.add(pan);
            sesion.setAttribute("stockPanes", stockPanes);
            
            response.sendRedirect("MostrarCarritoPanes.jsp");
            

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
            Logger.getLogger(AgregarPanCarrito.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AgregarPanCarrito.class.getName()).log(Level.SEVERE, null, ex);
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
