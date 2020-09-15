/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge Rivero
 */
public class EditarServlet2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String eseid, nombre, apellidoPaterno, password;
            eseid = request.getParameter("id2");
            int id = Integer.parseInt(eseid);
            nombre = request.getParameter("nombre2");
            apellidoPaterno = request.getParameter("apellidoPaterno2");
            password = request.getParameter("password2");
            
            //ahora hago mi objeto 
            
            MUsuario u = new MUsuario();
            u.setId_usu(id);
            u.setNom_usu(nombre);
            u.setAppat_usu(apellidoPaterno);
            u.setPass_usu(password); 
            
            
            //con esto se cumple lo de encapsulamiento
            
            //querry
            
            int estado = MUsuario.ActualizarDatos(u);
            
                    if (estado > 0) {
                        response.sendRedirect("ConsultarServlet");
                    }else{
                        out.println("<h1>NO c pudo realizar ninguna acción. revise todo o si no pues algo salio mal bro</h1>");
                    }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("</body>");
            out.println("</html>");
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
