package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UsuariosDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarUsuarios(Usuarios user){
    
        String sql = "INSERT INTO donantes (Nombre,Apellidos,DNI,Email,Direccion) VALUES(?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getNombreUsuarios());
            ps.setString(2,user.getApellidosUsuarios());
            ps.setString(3,user.getDNIUsuarios());
            ps.setString(4,user.getEmailUsuarios());
            ps.setString(5,user.getDireccionUsuarios());
            ps.execute();
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;        
        }finally{
            try{
                con.close();
            }catch (SQLException e){
                System.out.println(e.toString());
            }
        }    
    }   
    
    public List TablaUsuarios(){
    
        List<Usuarios> Tablauser = new ArrayList();
        String sql = "SELECT * FROM usuarios";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuarios user = new Usuarios();
                user.setIDUsuarios(rs.getInt("IDUsuarios"));
                user.setNombreUsuarios(rs.getString("NombreUsuarios"));
                user.setApellidosUsuarios(rs.getString("ApellidosUsuarios"));
                user.setDNIUsuarios(rs.getString("DNIUsuarios"));
                user.setEmailUsuarios(rs.getString("EmailUsuarios"));
                user.setDireccionUsuarios(rs.getString("DireccionUsuarios"));
                Tablauser.add(user);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return Tablauser;        
    }
    
    public boolean EliminarUsuarios(int IDUsuarios){
        String sql = "DELETE FROM usuarios WHERE IDUsuarios = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,IDUsuarios);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarUsuarios(Usuarios user){
        String sql = "UPDATE usuarios SET NombreUsuarios=?, ApellidosUsuarios=?, DNIUsuarios=?, EmailUsuarios=?, DireccionUsuarios=? WHERE IDUsuarios=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombreUsuarios());
            ps.setString(2, user.getApellidosUsuarios());
            ps.setString(3, user.getDNIUsuarios());
            ps.setString(4, user.getEmailUsuarios());
            ps.setString(5, user.getDireccionUsuarios());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }
}


    

