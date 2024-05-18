package ultimoproyectofinal;

import Vista.Aplicacion;
import com.jtattoo.plaf.aero.AeroLookAndFeel;;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class UltimoProyectoFinal {

    
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        new Aplicacion().setVisible(true);
        
        UIManager.setLookAndFeel(new AeroLookAndFeel());
        
    }
    
}
