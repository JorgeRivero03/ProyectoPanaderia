/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Jorge Rivero
 */
import java.util.*;
import java.sql.*;

public class MPan {
    private int id_pan, id_cpan, id_csp, stock_pan;
    private String  nom_pan;
    private float  pre_pan;
    
    public MPan(){
    
    }
    //metodo para agregar un nuevo pan
    public static int GuardarPan(MPan p) throws ClassNotFoundException{
        int  estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        

        try{
        
            con = Conexion.getConexion();
            String q ="insert into MPan (id_pan, id_cpan, id_csp, stock_pan, pre_pan, nombre) values (?, ?, ?, ?, ?)";
            
          ps = con.prepareStatement(q);
          
          ps.setInt(1, p.getId_pan());
          
          ps.setInt(2,p.getId_cpan() );
          
          ps.setInt(3, p.getId_csp() );
          
          ps.setInt(4, p.getStock_pan());
          
          ps.setFloat(5, p.getPre_pan());
          
          ps.setString(6, p.getNom_pan());
          
          estatus = ps.executeUpdate();
          

          con.close();
        
        }catch(SQLException ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
            
        }
        return estatus;
    
    }
    //metodo para eleminar un pan
    
    public static int EliminarPan(int id) throws ClassNotFoundException{
    
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
    public static int ActualizarPan(MPan p){
    
        int estatus = 0;
         
        
        try{
        Connection con = Conexion.getConexion();
        String sql ="Update Datos set nombre = ?, precio= ?, where id = ?, id_pan =?, id_cspan=?, stockPan = ?";
        
         PreparedStatement ps = con.prepareStatement(sql);
          
          
          
          ps.setInt(1, p.getId_pan());
          
          ps.setInt(2,p.getId_cpan() );
          
          ps.setInt(3, p.getId_csp() );
          
          ps.setInt(4, p.getStock_pan());
          
          ps.setFloat(5, p.getPre_pan());
          

          
          estatus = ps.executeUpdate();
          

          con.close();
        
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
            
        
        }
        return estatus;
    }
    //metodo para consultar a todos los panes
    
    public static List<MPan> getAllPan(){
    
        List<MPan> lista = new ArrayList<MPan>(); 
        try{
        
            Connection con = Conexion.getConexion();
            String sql = "select * from Datos ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                MPan p = new MPan();
                    p.setId_pan(rs.getInt(sql));
                    p.setId_cpan(rs.getInt(2));
                    p.setId_csp(rs.getInt(3));
                    p.setStock_pan(rs.getInt(4));
                    p.setPre_pan(rs.getFloat(5));
                    p.setNom_pan(rs.getString(6));
                    
                    lista.add(p);
                    
            }
            
            con.close();
            
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
            
        
        }
        return lista;
    
    }
    public Vector<MPan> listaPanes() throws ClassNotFoundException{
        Vector<MPan> lp = new Vector<MPan>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConexion();
            String q = "select * from MPan";
            rs = ps.executeQuery();
            //buscar todos los panes de la tabla
            while(rs.next()){
            //instancia de panesitos
            MPan pan = new MPan();
            pan.setId_pan(rs.getInt("id_pan"));
            pan.setNom_pan(rs.getString("nom_pan"));
            pan.setPre_pan(rs.getFloat("pre_pan"));
            pan.setStock_pan(rs.getInt("stock_pan"));
            pan.setId_cpan(rs.getInt("id_cpan"));
            pan.setId_csp(rs.getInt("id_csp"));
            //agrego a la lista
            lp.add(pan);
            }
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            lp = null;
        }finally{
            //cerramos conexiones
             try{
                rs.close();
                ps.close();
                con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return lp;
    }
    //metodo para buscar un pan por codigo
    
    public MPan buscarPan(int idpan) throws ClassNotFoundException{
        MPan pan = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
        con = Conexion.getConexion();
        String q = "select * from MPan where id_pan = ?";
        ps = con.prepareStatement(q);
        ps.setInt(1, idpan);
        while(rs.next()){
            pan = new MPan();
            pan.setId_pan(rs.getInt("id_pan"));
            pan.setNom_pan(rs.getString("nom_pan"));
            pan.setPre_pan(rs.getFloat("pre_pan"));
            pan.setStock_pan(rs.getInt("stock_pan"));
            pan.setId_cpan(rs.getInt("id_cpan"));
            pan.setId_csp(rs.getInt("id_csp"));
        }
        
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            pan = null;
        }finally{
            //cerramos conexiones
             try{
                rs.close();
                ps.close();
                con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return pan;
        
    }
    //metodo para actualizar el stock osi
    
    public boolean actualizarStock(Vector <MPan> vpan) throws ClassNotFoundException{
        boolean actualizo = false;
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = Conexion.getConexion();
            //tenemos que recorrer el vector para actualizar el stock de cada pan
            for(MPan pan : vpan){
                String q = "Update MPan set = ? where id_pan = ?";
                ps = con.prepareStatement(q);
                ps.setInt(1, pan.stock_pan);
                ps.setInt(2, pan.id_pan);
                //comprobacion del booleano
                if(ps.executeUpdate() == 1){
                    actualizo = true;
                }else{
                    actualizo = false;
                    break;
                }
            }
            
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            actualizo = false;
        }finally{
            //cerramos conexiones
             try{
                ps.close();
                con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return actualizo;
    }
    
    public int getId_pan() {
        return id_pan;
    }

    public void setId_pan(int id_pan) {
        this.id_pan = id_pan;
    }

    public int getId_cpan() {
        return id_cpan;
    }

    public void setId_cpan(int id_cpan) {
        this.id_cpan = id_cpan;
    }

    public int getId_csp() {
        return id_csp;
    }

    public void setId_csp(int id_csp) {
        this.id_csp = id_csp;
    }

    public int getStock_pan() {
        return stock_pan;
    }

    public void setStock_pan(int stock_pan) {
        this.stock_pan = stock_pan;
    }

    public String getNom_pan() {
        return nom_pan;
    }

    public void setNom_pan(String nom_pan) {
        this.nom_pan = nom_pan;
    }

    public float getPre_pan() {
        return pre_pan;
    }

    public void setPre_pan(float pre_pan) {
        this.pre_pan = pre_pan;
    }
    
    
}
