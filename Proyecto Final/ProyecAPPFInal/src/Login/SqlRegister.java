package Login;
import Conexion.ConexionBD;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;

/**
 * @author 177815
 */
public class SqlRegister extends ConexionBD {
    public boolean Registrar(ConexionRegisterUser user){
        PreparedStatement ps = null;
        
        ConexionBD cx = new ConexionBD();
        cx.conectar();
        String sql ="INSERT INTO usuarios (user, password, idusuario) VALUES(?,?,?)";
        
        ps = cx.PreparedStatement(sql);
        return false;
    }
}
