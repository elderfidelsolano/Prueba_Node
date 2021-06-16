
package conexion;

import static conexion.Conexion.close;
import domain.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoJDBC {
    
    private Connection conexionTransaccional;
    public static final String SQL_SELECT = "SELECT category_id, category FROM prueba_node.categories";
    public static final String SQL_INSERT = "INSERT INTO categories(category) VALUES(?)";
    public static final String SQL_UPDATE = "UPDATE categories SET category=? where category_id= ?";
    public static final String SQL_DELETE = "DELETE FROM prueba_node.categories WHERE category_id = ?";

    public CategoriesDaoJDBC() {
    }

    
    public CategoriesDaoJDBC(Connection conexion) {
        this.conexionTransaccional = conexion;
    }
    
    public List<Categories> select() throws SQLException, ParseException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Categories> listacategorias = new ArrayList<>();
        Categories categoria = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int category_id = rs.getInt("category_id");
                String categoria1 = rs.getString("category");
 
                categoria = new Categories(category_id,categoria1);
                listacategorias.add(categoria); 
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
        return listacategorias;
    }
    
    
    
     public int insertar(Categories categoria) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, categoria.getCategory());
            registros= stmt.executeUpdate();
            System.out.println("Registro Insertado Categoria " + registros);

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
     
     
    public int update(Categories categoria) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, categoria.getCategory());
            stmt.setInt(2, categoria.getCategory_id());
            registros = stmt.executeUpdate();
            System.out.println("Registro actualizado de categoria" + registros);

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
    public int delete(Categories categoria) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, categoria.getCategory_id());
            resultado = stmt.executeUpdate();
            System.out.println("Se ha eliminado la categoria "+ resultado);
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
