package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
// Pool de Conexiones
public class Conexion {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/prueba_node?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicRetrieval=true";
    public static final String USUARIO = "root";
    public static final String PASSWORD = "admin";
// Se declara un metodo estatico para crear las conexiones utilizadno las clases BasicDataSource, donde
// se definen algunos parametros como URL,USUARIO,PASSWORD y la cantidad de conexiones a utilizar que en 
// este caso serian 5.
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(USUARIO);
        ds.setPassword(PASSWORD);
        // Se define el tamaño inicial del pol de conexiones
        ds.setInitialSize(7);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet resultado) throws SQLException {
        resultado.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();

    }

}
