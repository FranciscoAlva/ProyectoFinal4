package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class DonanteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarDonante(Donante cl){
    
        String sql = "INSERT INTO donantes (Nombre,Apellidos,DNI,Email,Direccion) VALUES(?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,cl.getNombre());
            ps.setString(2,cl.getApellidos());
            ps.setString(3,cl.getDNI());
            ps.setString(4,cl.getEmail());
            ps.setString(5,cl.getDireccion());
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
    
    public List TablaDonantes(){
    
        List<Donante> TablaDo = new ArrayList();
        String sql = "SELECT * FROM donantes";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Donante don = new Donante();
                don.setID(rs.getInt("ID"));
                don.setNombre(rs.getString("Nombre"));
                don.setApellidos(rs.getString("Apellidos"));
                don.setDNI(rs.getString("DNI"));
                don.setEmail(rs.getString("Email"));
                don.setDireccion(rs.getString("Direccion"));
                TablaDo.add(don);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return TablaDo;        
    }
    
    public boolean EliminarDonantes(int ID){
        String sql = "DELETE FROM donantes WHERE ID = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,ID);
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
    
    public boolean ModificarDonantes(Donante cl){
        String sql = "UPDATE donantes SET Nombre=?, Apellidos=?, DNI=?, Email=?, Direccion=? WHERE ID=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getApellidos());
            ps.setString(3, cl.getDNI());
            ps.setString(4, cl.getEmail());
            ps.setString(5, cl.getDireccion());
            ps.executeUpdate();
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
