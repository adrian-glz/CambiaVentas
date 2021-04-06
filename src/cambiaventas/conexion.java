package cambiaventas;

//import static CambiaVentas.Main.sucursalglobal;
import static cambiaventas.CambiaVenta.sucursalglobal;
import static cambiaventas.Main.IPSUCURSAL;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * 
 * @author AGONZALEZ
 */
public class conexion {

    public String url = "jdbc:jtds:sqlserver://" + IPSUCURSAL;
    public String user = "usounds";
    public String pass = "madljda";

    public Connection Conectar() {
        Connection link = null;
        System.out.println("imprimiendo ruta" + url);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conexion exitosa!!!!!");
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor deseado ,Verificar conexion a red por cable, wifi" + ex);
        }
        return link;
    }

}
