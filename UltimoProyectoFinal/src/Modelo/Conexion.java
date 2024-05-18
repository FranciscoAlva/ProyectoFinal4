package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
     Connection con;
     
     public Connection getConnection(){
        try{
            String miBD = "jdbc:mysql://localhost:3306/proyectofinalparte3?serverTimezone=UTC";
            con = DriverManager.getConnection(miBD,"proyectofinalpar","proyectofinalpar");
            return con;
        }catch (SQLException e){
            System.out.println("e.toString");
        }
        
        return null;
    } 

}
