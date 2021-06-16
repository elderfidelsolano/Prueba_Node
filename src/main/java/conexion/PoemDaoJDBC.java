
package conexion;

import static conexion.Conexion.close;
import domain.Categories;
import domain.Poem;
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


public class PoemDaoJDBC {
    private Connection conexionTransaccional;

    public static final String SQL_SELECT = "SELECT poem_id, title, poem, data_submitted, categoryid, userid, date_approved FROM prueba_node.poems";
    public static final String SQL_INSERT = "INSERT INTO prueba_node.poems(title, poem, data_submitted, categoryid, userid, date_approved) VALUES(?, ?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE prueba_node.poems SET title=?, poem = ?, data_submitted= ? , categoryid=  ?, userid= ?, date_approved= ? where poem_id = ?";
    public static final String SQL_DELETE = "DELETE FROM prueba_node.poems WHERE poem_id = ?";

    public PoemDaoJDBC() {
    }

    
    public PoemDaoJDBC(Connection conexion) {
        this.conexionTransaccional = conexion;
    }

    public List<Poem> select() throws SQLException, ParseException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Poem poema = null;
        List<Poem> listapoemas = new ArrayList<>();
        Categories categoria = null;
        Users usuario = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int poem_id = rs.getInt("poem_id");
                String title = rs.getString("title");
                String poem = rs.getString("poem");
                String date_submitted = rs.getString("date_submitted");
                int categoryid = rs.getInt("categoryid");
                int userid = rs.getInt("userid");
                String date_approved = rs.getString("date_approved");

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = (Date) formato.parse(date_approved);
                Date fecha1 =(Date) formato.parse(date_submitted);
                
                usuario = new Users(userid);
                categoria = new Categories(categoryid);

                poema = new Poem(poem_id,title,poem,fecha1,categoria,usuario,fecha);
                listapoemas.add(poema); 
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
        return listapoemas;
    }

    public int insertar(Poem poema) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, poema.getTitle());
            stmt.setString(2, poema.getPoem());
            stmt.setDate(3, new java.sql.Date (poema.getDate_submitted().getTime()));
            stmt.setInt(4, poema.getCategoria().getCategory_id());
            stmt.setInt(5, poema.getUsuario().getUser_id());
            stmt.setDate(6, new java.sql.Date(poema.getDate_approved().getTime()));
            registros = stmt.executeUpdate(); 
            System.out.println("Registro Insertado Poema " + registros);

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


    public int update(Poem poema) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, poema.getTitle());
            stmt.setString(2, poema.getPoem());
            stmt.setDate(3, new java.sql.Date(poema.getDate_submitted().getTime()));
            stmt.setInt(4, poema.getCategoria().getCategory_id());
            stmt.setInt(5, poema.getUsuario().getUser_id());
            stmt.setDate(6, new java.sql.Date(poema.getDate_approved().getTime()));
            stmt.setInt(7, poema.getPoem_id());
            registros = stmt.executeUpdate();
            System.out.println("Registro actualizado de poema" + registros);

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

    public int delete(Poem poema) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, poema.getPoem_id());
            resultado = stmt.executeUpdate();
            System.out.println("Se ha eliminado el poema");
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
