/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge Rivero
 */
public class GuardarUsuario extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try (PrintWriter out = response.getWriter()) {
            MUsuario u = new MUsuario();
            String eseid, nombre, apellidoPaterno, password;
            eseid = request.getParameter("id2");
            int id = Integer.parseInt(eseid);
            nombre = request.getParameter("nombre2");
            apellidoPaterno = request.getParameter("apellidoPaterno2");
            password = request.getParameter("password2");
            
            u = new MUsuario();
            u.setId_usu(id);
            u.setNom_usu(nombre);
            u.setAppat_usu(apellidoPaterno);
            u.setPass_usu(password); 
            
              //querry
            
            int estado = 0;
        try {
            estado = MUsuario.GuardarUsuario(u);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GuardarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                    if (estado > 0) {
                        out.println("<h1>Se a registrado el usuario</h1>");
                        
                        request.getRequestDispatcher("index.html");
                        
                        response.sendRedirect("ConsultaUsuario");
                        
                    }else{
                       out.println("<h1>No se a guardado na , bueno eso creo verdad jajaj, la neta no c pk programo si estoy pan bb</h1>");
                    }
                    
            
            

        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GuardarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuardarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
