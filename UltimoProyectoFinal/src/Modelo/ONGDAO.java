package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ONGDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarONG(ONG ONG){
    
        String sql = "INSERT INTO ong (NombreONG,CIFONG,DireccionONG,TelefonoONG, EmailONG) VALUES(?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,ONG.getNombreONG());
            ps.setString(2,ONG.getCIFONG());
            ps.setString(3,ONG.getDireccionONG());
            ps.setString(4,ONG.getTelefonoONG());
            ps.setString(5,ONG.getEmailONG());
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
    
    public List TablaONG(){
    
        List<ONG> TablaONG = new ArrayList();
        String sql = "SELECT * FROM ong";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ONG ONG = new ONG();
                ONG.setIDONG(rs.getInt("IDONG"));
                ONG.setNombreONG(rs.getString("NombreONG"));
                ONG.setCIFONG(rs.getString("CIFONG"));
                ONG.setDireccionONG(rs.getString("DireccionONG"));
                ONG.setTelefonoONG(rs.getString("TelefonoONG"));
                ONG.setEmailONG(rs.getString("EmailONG"));                
                TablaONG.add(ONG);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return TablaONG;        
    }
    
    public boolean EliminarONG(int IDONG){
        String sql = "DELETE FROM ong WHERE IDONG = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,IDONG);
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
    
    public boolean ModificarONG(ONG ONG){
        String sql = "UPDATE ong SET NombreONG=?, CIFONG=?, DireccionONG=?, TelefonoONG=?, EmailONG=? WHERE IDONG=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, ONG.getNombreONG());
            ps.setString(2, ONG.getCIFONG());
            ps.setString(3, ONG.getDireccionONG());
            ps.setString(4, ONG.getTelefonoONG());
            ps.setString(5, ONG.getEmailONG());
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
