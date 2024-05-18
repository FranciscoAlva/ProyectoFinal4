package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    
      public login log(String EmailLogin, String Password){
          login l = new login();
          String sql = "SELECT * FROM login WHERE EmailLogin = ? AND Password = ?";
          try{
              con = cn.getConnection();
              ps = con.prepareStatement(sql);
              ps.setString(1, EmailLogin);
              ps.setString(2, Password);
              rs = ps.executeQuery();
              if(rs.next()){
                  l.setIDLogin(rs.getInt("IDLogin"));
                  l.setNombreLogin(rs.getString("NombreLogin"));
                  l.setEmailLogin(rs.getString("EmailLogin"));
                  l.setPassword(rs.getString("Password"));
              }
          }catch (SQLException e){
              System.out.println(e.toString());
          }            
          return l;
      }

}
