package conexion;

import static conexion.Conexion.*;
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

public class UsersDaoJDBC {

    private Connection conexionTransaccional;

    public static final String SQL_SELECT = "SELECT user_id, first_name, last_name, email, username, pass_phrase, is_admin, date_registered, profile_pic, registration_comfirmed FROM users;";
    public static final String SQL_INSERT = "INSERT INTO prueba_node.Users(first_name, last_name, email, username, pass_phrase, is_admin, date_registered, profile_pic, registration_comfirmed) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE prueba_node.users SET first_name=? , last_name = ?, email =?, username=? , pass_phrase=?, is_admin=?, date_registered = ? , profile_pic=?, registration_comfirmed = ? where user_id = ?";
    public static final String SQL_DELETE = "DELETE FROM users WHERE user_id = ?";

    public UsersDaoJDBC() {
    }

    // Se utiliza una conexion externa ya que para poder realizar un commit se necesita una sola conexion
    // por lo que se pasa la conexion en este constructir, y además se la utilizad dentro de cada uno de los
    // metodos de insertar, actualizar, eliminar y seleccionar en la linea  conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
    // donde quiere decir que si la variable this.conexionTransaccional != null que es la conexion externa es 
    // diferente de null, entonces se usa esta conexion externa en cada metodo. Ademas en el bloque finally 
    // se utiliza el: if (this.conexionTransaccional == null) {
    //                close(conn);
    //            }
    // para saber si this.conexionTransaccional == null , entonces quiere decir que esta conexion no se ha
    // iniciado por lo que debe de cerrarse la conexión porque es una conexión inicializada en el método y no 
    // una conexión externa, por lo que debe de cerrarce esta conexión interna declarada dentro del método.
    public UsersDaoJDBC(Connection conexion) {
        this.conexionTransaccional = conexion;
    }

//    public List<PersonaDTO> selecccionar() throws SQLException {
//        
//    }
//    
    public List<Users> select() throws SQLException, ParseException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Users usuario = null;
        List<Users> listausuarios = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("user_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String pass_phrase = rs.getString("pass_phrase");
                int is_admin = rs.getInt("is_admin");
                String date_registered = rs.getString("date_registered");
                String profile_pic = rs.getString("profile_pic");
                int registration_confirmed = rs.getInt("registration_comfirmed");

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = (Date) formato.parse(date_registered);

                usuario = new Users(idPersona, first_name, last_name, email, username, pass_phrase, is_admin, fecha, profile_pic, registration_confirmed);
                listausuarios.add(usuario);
            }
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
        return listausuarios;
    }

    public int insertar(Users usuario) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getFirst_name());
            stmt.setString(2, usuario.getLast_name());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getUsername());
            stmt.setString(5, usuario.getPass_phrase());
            stmt.setInt(6, usuario.getIs_admin());
            stmt.setDate(7, new java.sql.Date(usuario.getDate_registered().getTime()));
            stmt.setString(8, usuario.getProfile_pic());
            stmt.setInt(9, usuario.getRegistration_cponfirmed());
//            stmt.setString(3, persona.getEmail());
//            stmt.setString(4, persona.getTelefono() );
            registros = stmt.executeUpdate(); // Este metodo executa la consulta SQL y nos devuelve los registros afectado 
            // en la base de datos , es decir retorna un entero.
            System.out.println("Registros Insertados Usuarios " + registros);

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


    public int update(Users usuario) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getFirst_name());
            stmt.setString(2, usuario.getLast_name());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getUsername());
            stmt.setString(5, usuario.getPass_phrase());
            stmt.setInt(6, usuario.getIs_admin());
//            stmt.setDate(7, (java.sql.Date) usuario.getDate_registered());
            stmt.setDate(7, new java.sql.Date(usuario.getDate_registered().getTime()));
            stmt.setString(8, usuario.getProfile_pic());
            stmt.setInt(9, usuario.getRegistration_cponfirmed());
            stmt.setInt(10, usuario.getUser_id());
            registros = stmt.executeUpdate();
            System.out.println("Registros actualizados de usuario" + registros);

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

    public int delete(Users usuario) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getUser_id());
            resultado = stmt.executeUpdate();
            System.out.println("Se ha eliminado el usuario");
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
