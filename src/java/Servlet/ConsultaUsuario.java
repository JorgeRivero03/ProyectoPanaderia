/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.*;
;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge Rivero
 */
public class ConsultaUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta de Usuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de todos los usuarios"+"</h1>"
                    + "<br>" 
                    +"<a href = 'index.html'> Regresar a la pagina principal</a>"
                    );
            
            //aqui añadimos nuestra lista
            
            List<MUsuario> lista = MUsuario.getAllUsuarios();
            
            out.println("<table border = 1 >"
                    + "<tr>"
                    +   "<th>ID</th>"
                    +   "<th>Nombre</th>"
                    +   "<th>ApellidoPaterno</th>"
                    +   "<th>Contraseña</th>"
                    + "</tr>");
            
            //agregamos un for para que agregue los elementos de la lista
            for (MUsuario u:lista) {
                out.println("<tr>"
                        +"<td>"+u.getId_usu()+"</td>"
                        +"<td>"+u.getNom_usu()+"</td>"
                        +"<td>"+u.getAppat_usu()+"</td>"
                        +"<td>"+u.getPass_usu()+"</td>"
                        + "<td><a href='EditarServlet? id=e.getId_usu() '>Vamos a Editar</a></td>"
                        + "<td><a href='BorrarServlet? id=e.getId_usu() '>Vamos a Borrar</a></td>"
                        +"</tr>");
                //con esto vamos a pasar el parametro del Id
            }   
            
            out.println("</table>");
            
            out.println("</body>");
            out.println("</html>");

    }

   

  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
