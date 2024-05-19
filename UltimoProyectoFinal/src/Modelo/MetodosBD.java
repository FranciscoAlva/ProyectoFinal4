package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MetodosBD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel ModeloTabla;

    public void BuscarDonantes(String valor, String filtro, JTable tabla) {

        String[] columnas = {"ID", "Nombre", "Apellidos", "DNI", "Email", "Direccion"};
        String[] registros = new String[6];
        ModeloTabla = new DefaultTableModel(null, columnas);
        String sql;
        Connection conect = null;

        if (filtro.equals("Nombre")) {
            sql = "SELECT ID, Nombre, Apellidos, DNI, Email, Direccion"
                    + "FROM donantes WHERE Nombre LIKE '%" + valor + "%'";
        } else if (filtro.equals("Apellidos")) {
            sql = "SELECT ID, Nombre, Apellidos, DNI, Email, Direccion"
                    + "FROM donantes WHERE Apellidos LIKE '%" + valor + "%'";
        } else {

            sql = "SELECT ID, Nombre, Apellidos, DNI, Email, Direccion"
                    + "FROM donantes WHERE Email LIKE '%" + valor + "%'";
        }

        try {            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                registros[0]=rs.getString("ID");
                registros[1]=rs.getString("Nombre");
                registros[2]=rs.getString("Apellidos");
                registros[3]=rs.getString("DNI");
                registros[4]=rs.getString("Email");
                registros[5]=rs.getString("Direccion");
                
                ModeloTabla.addRow(registros);
            }
            
                tabla.setModel(ModeloTabla);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR AL BUSCAR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if(conect!=null){
                try{
                    conect.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e, "ERROR DE CONEXION",JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}
