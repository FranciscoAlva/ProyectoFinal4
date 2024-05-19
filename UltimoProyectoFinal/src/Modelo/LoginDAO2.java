package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class LoginDAO2 {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarLogin(LoginR lg){
    
        String sql = "INSERT INTO login (NombreLogin,EmailLogin,Password) VALUES(?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,lg.getNombreLogin());
            ps.setString(2,lg.getEmailLogin());
            ps.setString(3,lg.getPassword());
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
    
    public List TablaLogin(){
    
        List<LoginR> Tablalg = new ArrayList();
        String sql = "SELECT * FROM login";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                LoginR lg = new LoginR();
                lg.setIDLogin(rs.getInt("IDLogin"));
                lg.setNombreLogin(rs.getString("NombreLogin"));
                lg.setEmailLogin(rs.getString("EmailLogin"));
                lg.setPassword(rs.getString("Password"));
                Tablalg.add(lg);
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return Tablalg;        
    }
    
    public boolean EliminarLogin(int IDLogin){
        String sql = "DELETE FROM login WHERE IDLogin = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,IDLogin);
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
    
    public boolean ModificarLogin(LoginR lg){
        String sql = "UPDATE login SET NombreLogin=?, EmailLogin=?, Password=? WHERE IDLogin=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, lg.getNombreLogin());
            ps.setString(2, lg.getEmailLogin());
            ps.setString(3, lg.getPassword());
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
