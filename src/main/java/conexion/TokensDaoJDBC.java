
package conexion;

import static conexion.CategoriesDaoJDBC.driver;
import static conexion.Conexion.close;
import static conexion.UsersDaoJDBC.SQL_DELETE;
import static conexion.UsersDaoJDBC.SQL_INSERT;
import static conexion.UsersDaoJDBC.SQL_SELECT;
import static conexion.UsersDaoJDBC.SQL_UPDATE;
import domain.Tokens;
import domain.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TokensDaoJDBC {
    private Connection conexionTransaccional;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String SQL_SELECT = "SELECT token_id, token, user_id, token_expires FROM prueba_node.tokens;";
    public static final String SQL_INSERT = "INSERT INTO prueba_node.tokens(token, user_id, token_expires) VALUES(?,?,?)";
    public static final String SQL_UPDATE = "UPDATE prueba_node.tokens SET token=?, user_id=?, token_expires=? where token_id = ?";
    public static final String SQL_DELETE = "DELETE FROM prueba_node.tokens WHERE token_id =?";

    public TokensDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    public List<Tokens> select() throws SQLException, ParseException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Tokens token = null;
        Users usuario = null;
        List<Tokens> listatokens = new ArrayList<>();
        

        try {
            Class.forName(driver);
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int token_id = rs.getInt("token_id");
                String tokens = rs.getString("token");
                int id_usuario = rs.getInt("user_id");
                String token_expires = rs.getString("token_expires");

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = (Date) formato.parse(token_expires);
                usuario = new Users(id_usuario);
                token = new Tokens(token_id, tokens, usuario, fecha);
                listatokens.add(token);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TokensDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(pst);

                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return listatokens;
    }
    
    
    public int insertar(Tokens token) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            Class.forName(driver);
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, token.getToken());
            stmt.setInt(2, token.getUsuario().getUser_id());
            stmt.setDate(3, new java.sql.Date(token.getDate_expired().getTime()));
           
            registros = stmt.executeUpdate(); // Este metodo executa la consulta SQL y nos devuelve los registros afectado 
            // en la base de datos , es decir retorna un entero.
            System.out.println("Registros Token Insertados Correctamente " + registros);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TokensDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;

    }
    
     public int update(Tokens token) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            Class.forName(driver);
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, token.getToken());
            stmt.setInt(2, token.getUsuario().getUser_id());
            stmt.setDate(3, new java.sql.Date(token.getDate_expired().getTime()));
            stmt.setInt(4, token.getToken_id());
            registros = stmt.executeUpdate();
            System.out.println("Registros actualizados de tokens" + registros);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TokensDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;

    }

    public int delete(Tokens token) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            Class.forName(driver);
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, token.getToken_id());
            resultado = stmt.executeUpdate();
            System.out.println("Se ha eliminado el token ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TokensDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }
    
}
