package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class SedesDAO {
    
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
 
    public boolean RegistrarSedes(Sedes sd){
    
        String sql = "INSERT INTO sedes (DireccionSedes,EmailSedes,TelefonoSedes,ResponsableSedes) VALUES(?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,sd.getDireccionSedes());
            ps.setString(2,sd.getEmailSedes());
            ps.setString(3,sd.getTelefonoSedes());
            ps.setString(4,sd.getResponsableSedes());
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
    
    public List TablaSedes(){
    
        List<Sedes> Tablasd = new ArrayList();
        String sql = "SELECT * FROM sedes";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Sedes sd = new Sedes();
                sd.setIDSedes(rs.getInt("IDSedes"));
                sd.setDireccionSedes(rs.getString("DireccionSedes"));
                sd.setEmailSedes(rs.getString("EmailSedes"));
                sd.setTelefonoSedes(rs.getString("TelefonoSedes"));
                sd.setResponsableSedes(rs.getString("ResponsableSedes"));
                Tablasd.add(sd);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return Tablasd;        
    }
    
    public boolean EliminarSedes(int IDSedes){
        String sql = "DELETE FROM sedes WHERE IDSedes = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,IDSedes);
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
    
    public boolean ModificarSedes(Sedes sd){
        String sql = "UPDATE sedes SET DireccionSedes=?, EmailSedes=?, TelefonoSedes=?, ResponsableSedes=? WHERE IDSedes=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, sd.getDireccionSedes());
            ps.setString(2, sd.getEmailSedes());
            ps.setString(3, sd.getTelefonoSedes());
            ps.setString(4, sd.getResponsableSedes());
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
