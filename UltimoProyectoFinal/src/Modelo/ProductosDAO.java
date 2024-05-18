package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO productos (NombreProductos, TipodeProductos, DescripcionProductos, CantidadProductos, IDDonante, NombreONG2) VALUES (?,?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombreProductos());
            ps.setString(2, pro.getTipodeProductos());
            ps.setString(3, pro.getDescripcionProductos());
            ps.setInt(4, pro.getCantidadProductos());
            ps.setInt(5, pro.getIDDonante());
            ps.setString(6, pro.getNombreONG2());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List TablaProductos(){
    
        List<Productos> TablaPro = new ArrayList();
        String sql = "SELECT * FROM productos";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos pro = new Productos();
                pro.setIDProductos(rs.getInt("IDProductos"));
                pro.setNombreProductos(rs.getString("NombreProductos"));
                pro.setTipodeProductos(rs.getString("TipodeProductos"));
                pro.setDescripcionProductos(rs.getString("DescripcionProductos"));
                pro.setCantidadProductos(rs.getInt("CantidadProductos"));
                pro.setIDDonante(rs.getInt("IDDonante"));
                pro.setNombreONG2(rs.getString("NombreONG2"));
                TablaPro.add(pro);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return TablaPro;        
    }
    
    public boolean EliminarProductos(int IDProducto){
        String sql = "DELETE FROM productos WHERE IDProductos = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,IDProducto);
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
    
    public boolean ModificarProductos(Productos pro){
        String sql = "UPDATE productos SET NombreProductos=?, TipodeProductos=?, DescripcionProductos=?, CantidadProductos=?, IDDonante=? WHERE IDProductos=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombreProductos());
            ps.setString(2, pro.getTipodeProductos());
            ps.setString(3, pro.getDescripcionProductos());
            ps.setInt(4, pro.getCantidadProductos());
            ps.setInt(5, pro.getIDDonante());
            ps.setString(6, pro.getNombreONG2());
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
