/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jorge Rivero
 */
public class MUsuario {
    private  int id_usu, priv_usu;
    private String nom_usu, appat_usu, user_usu, pass_usu;
    
    
    
    
    
    
    
    //crear el constructor
    
    public MUsuario(){
        
    }
    //metodo para agregar un nuevo usuario
    public static int GuardarUsuario(MUsuario u) throws ClassNotFoundException{
        int  estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        

        try{
        
            con = Conexion.getConexion();
            String q ="insert into MUsuario (nom_usu, appat_usu, user_usu, pass_usu, priv_usu) values (?, ?, ?, ?, 0)";
            
          ps = con.prepareStatement(q);
          
          ps.setString(1, u.getNom_usu());
          
          ps.setString(2, u.getAppat_usu());
          
          ps.setString(3, u.getUser_usu());
          
          ps.setString(4, u.getPass_usu());
          
          estatus = ps.executeUpdate();
          

          con.close();
        
        }catch(SQLException ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
            
        }
        return estatus;
    
    }
    //metodo para eleminar un usuario
    
    public static int Eliminar(int id) throws ClassNotFoundException{
    
        int estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
        
            con = Conexion.getConexion();
            String q = "delete from Datos where id=? ";
            ps = con.prepareStatement(q);
            ps.setInt(1, id);
            estatus = ps.executeUpdate();
            con.close();
        
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        }
        return estatus;
        
    
    }
    
    
    
    //metodo para actualizar un usuario
    public static int ActualizarDatos(MUsuario u){
    
        int estatus = 0;
         
        
        try{
        Connection con = Conexion.getConexion();
        String sql ="Update Datos set nombre = ?, password: ?, apellidoPaterno= ?, usuario = ?, where id = ?";
        
         PreparedStatement ps = con.prepareStatement(sql);
          
          ps.setString(1, u.getNom_usu());
          
          ps.setString(2, u.getAppat_usu());
          
          ps.setString(3, u.getUser_usu());
          
          ps.setString(4, u.getPass_usu());
          
          ps.setInt(5, u.getId_usu());
          
          estatus = ps.executeUpdate();
          

          con.close();
        
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
            
        
        }
        return estatus;
    }
    //metodo para consultar a todos los usuario
    
    public static List<MUsuario> getAllUsuarios(){
    
        List<MUsuario> lista = new ArrayList<MUsuario>(); 
        try{
        
            Connection con = Conexion.getConexion();
            String sql = "select * from Datos ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                MUsuario u = new MUsuario();
                    u.setId_usu(rs.getInt(sql));
                    u.setNom_usu(rs.getString(2));
                    u.setUser_usu(rs.getString(3));
                    u.setPass_usu(rs.getString(4));
                    
                    lista.add(u);
                    
            }
            
            con.close();
            
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
            
        
        }
        return lista;
    
    }





    //metodo para buscar un usuario por id
    public static MUsuario getUsuarioId(int id){
    
        MUsuario u = new MUsuario();
        
        try{
            Connection con = Conexion.getConexion();
            String sql = "Select * from Datos where id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            //consulta
            
            ResultSet rs = ps.executeQuery();
            //ahora tenemos que buscar en todos los datos de la
            //tabla para eso usamos un if
            if (rs.next()) {
                //se vuelve aplicar el encapsulamientos
                //nos quedan de nuevo 10 min 
                //mando el nuevo enlace
                //empezammoscon el objeto u de usuario
                
                u.setId_usu(rs.getInt(1));
                u.setNom_usu(rs.getString(2));
                u.setPass_usu(rs.getString(3));
                u.setAppat_usu(rs.getString(4));
                u.setPriv_usu(rs.getInt(5));
                
                con.close();
            }
        
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        
        }
        return u;
    
    }
    
    
    //metodo para verificar usuario
    
    public MUsuario verificarUsuario(String user, String pass) throws ClassNotFoundException{
        MUsuario u = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConexion();
            String q = "select * from MUsuario where user usu = ? and pass usu = ?";
            ps = con.prepareStatement(q);
            //enviar los parametros de user y pass
            ps.setString(1, user);
            ps.setString(2, pass);
            //ejecutamos el query
            rs = ps.executeQuery();
            //buscar adentro de la tabla de musuarios los datos queridos
            while(rs.next()){
                u = new MUsuario();
                u.setId_usu(rs.getInt("id_usu"));
                u.setNom_usu(rs.getString("nom_usu"));
                u.setAppat_usu(rs.getString("appat_usu"));
                u.setUser_usu(rs.getString("user_usu"));
                u.setPass_usu(rs.getString("pass_usu"));
                u.setPriv_usu(rs.getInt("priv_usu"));
                break;
            }
        }catch(SQLException e){
            System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            u = null;
        }finally{
            //vamos a cerrar conexiones
            try{
                rs.close();
                ps.close();
                con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return u;
    }
    
    //metodos getters and setters

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getAppat_usu() {
        return appat_usu;
    }

    public void setAppat_usu(String appat_usu) {
        this.appat_usu = appat_usu;
    }

    public String getUser_usu() {
        return user_usu;
    }

    public void setUser_usu(String user_usu) {
        this.user_usu = user_usu;
    }

    public String getPass_usu() {
        return pass_usu;
    }

    public void setPass_usu(String pass_usu) {
        this.pass_usu = pass_usu;
    }

    public int getPriv_usu() {
        return priv_usu;
    }

    public void setPriv_usu(int priv_usu) {
        this.priv_usu = priv_usu;
    }
    
 
}
