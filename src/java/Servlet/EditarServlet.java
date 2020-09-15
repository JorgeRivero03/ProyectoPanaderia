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
public class EditarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tabla para editar usuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabla para actualizar los datos de usuarios</h1>");
            
            String eseid;
            eseid = request.getParameter("id");
            int id = Integer.parseInt(eseid);
            
            MUsuario u = MUsuario.getUsuarioId(id);
            //aqui estara la tabla ggg
            out.println("<form action='EditarServlet2' methos='post'"
                    +"name=editar>"
                    +"<table border=1>"
                    +"<tr>"
                    +"<td></td>"
                    +"<td><input type='hidden' name='id2' value=''"+u.getId_usu()+"></td>"
                    + "</tr>"
                    +"<tr>"
                    +"<td>Nombre:</td>"
                    +"<td><input type='text' name='nombre2' value=''"+u.getNom_usu()+"></td>"
                    + "</tr>"
                    +"<tr>"
                    +"<td></td>"
                    +"<td><input type='text' name='apellidoPaterno2' value=''"+u.getAppat_usu()+"></td>"
                    + "</tr>"
                    +"<tr>"
                    +"<td></td>"
                    +"<td><input type='text' name='password2' value=''"+u.getPass_usu()+"></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td colspan='?'><input type='submit' value='Guardar Cambios'</td>"
                    + "</tr>"
                    +"</table>"
                    + "</form>");
            
            //aqui el servlet realiza la accion aunque pudo haber sido jsp
            
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
