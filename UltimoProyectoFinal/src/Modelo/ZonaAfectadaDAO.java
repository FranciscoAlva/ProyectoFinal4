package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ZonaAfectadaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarZonaAfectada(ZonaAfectada Zona){
    
        String sql = "INSERT INTO zonaafectada (NombreZona, PaisZona, CiudadZona, NombreONG3) VALUES (?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Zona.getNombreZona());
            ps.setString(2, Zona.getPaisZona());
            ps.setString(3, Zona.getCiudadZona());
            ps.setString(4, Zona.getNombreONG3());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List TablaZona(){
    
        List<ZonaAfectada> TablaZo = new ArrayList();
        String sql = "SELECT * FROM zonaafectada";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ZonaAfectada Zona = new ZonaAfectada();
                Zona.setIDZona(rs.getInt("IDZona"));
                Zona.setNombreZona(rs.getString("NombreZona"));
                Zona.setPaisZona(rs.getString("PaisZona"));
                Zona.setCiudadZona(rs.getString("CiudadZona"));
                Zona.setNombreONG3(rs.getString("NombreONG3"));                
                TablaZo.add(Zona);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return TablaZo;        
    }
    
    public boolean EliminarZona(int IDZona){
        String sql = "DELETE FROM zonaafectada WHERE IDZona = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,IDZona);
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
    
    public boolean ModificarZona(ZonaAfectada Zona){
        String sql = "UPDATE zonaafectada SET NombreZona=?, PaisZona=?, CiudadZona=?, NombreONG3=? WHERE IDZona=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, Zona.getNombreZona());
            ps.setString(2, Zona.getPaisZona());
            ps.setString(3, Zona.getCiudadZona());
            ps.setString(4, Zona.getNombreONG3());
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

