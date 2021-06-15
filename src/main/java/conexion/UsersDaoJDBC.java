package conexion;

import static conexion.Conexion.*;
import domain.Users;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDaoJDBC {
    
    private Connection conexionTransaccional;

    public static final String SQL_SELECT = "SELECT idPersona,nombre,apellido FROM test.persona";
    public static final String SQL_INSERT = "INSERT INTO prueba_node.Users(first_name, last_name, email, username, pass_phrase, is_admin, date_registered, profile_pic, registration_comfirmed) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE Persona SET nombre =?, apellido =? WHERE idPersona =?";
    public static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";


    public UsersDaoJDBC(){
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
    public UsersDaoJDBC(Connection conexion){
        this.conexionTransaccional = conexion;
    }
    
//    public List<PersonaDTO> selecccionar() throws SQLException {
//        
//    }
//    
   
    public int insertar(Users usuario) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt= con.prepareStatement(SQL_INSERT);
            stmt.setString(1,usuario.getFirst_name());
            stmt.setString(2,usuario.getLast_name());
            stmt.setString(3,usuario.getEmail());
            stmt.setString(4,usuario.getUsername());
            stmt.setString(5,usuario.getPass_phrase());
            stmt.setInt(6,usuario.getIs_admin());
            stmt.setDate(7, usuario.getDate_registered());
            stmt.setString(8, usuario.getProfile_pic());
            stmt.setInt(9, usuario.getRegistration_cponfirmed());
//            stmt.setString(3, persona.getEmail());
//            stmt.setString(4, persona.getTelefono() );
            registros = stmt.executeUpdate(); // Este metodo executa la consulta SQL y nos devuelve los registros afectado 
                                              // en la base de datos , es decir retorna un entero.
            System.out.println("Registros Insertados Usuarios "+registros);
                        
        }finally{
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
    
//    public int actualizar(PersonaDTO persona) throws SQLException{
//       
//    }
//    
//    public int eliminar(PersonaDTO persona) throws SQLException{
//
//    }

   /*
    public int update(PersonaDTO persona) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
//            stmt.setString(3, persona.getEmail());
//            stmt.setString(4, persona.getTelefono());
            stmt.setInt(3, persona.getIdPersona());
            registros = stmt.executeUpdate();
            System.out.println("Registros actualizados "+registros);
        
        }finally{
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

    
    public int delete(PersonaDTO persona) throws SQLException {
                Connection con = null;
        PreparedStatement stmt = null;
        int resultado = 0;
        
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getIdPersona());
            resultado = stmt.executeUpdate();
        }finally{
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

    
    public List<PersonaDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> listaPersona = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
//                String telefono = rs.getString("telefono");
//                String email = rs.getString("email");
                persona = new PersonaDTO(idPersona, nombre, apellido);
                listaPersona.add(persona);
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
        return listaPersona;
    }
*/
}
