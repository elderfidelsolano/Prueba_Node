package test;

import conexion.Conexion;
import conexion.PoemDaoJDBC;
import domain.Categories;
import domain.Poem;
import domain.Users;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConexionPoem {

    public static void main(String[] args) {
        Connection conexion = null;
        List<Poem> lista = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            conexion = Conexion.getConnection();
            PoemDaoJDBC poema = new PoemDaoJDBC(conexion);
            /* 
            //Buscar Poemas.
            lista= poema.select();
            for(Poem poema1: lista){
                System.out.print("Id poema = "+poema1.getPoem_id()+" , ");
                System.out.print("Titulo = "+poema1.getTitle()+" , ");
                System.out.print("Poema = "+poema1.getPoem()+" , ");
                System.out.print("Fecha = "+formato.format(poema1.getDate_submitted())+" , ");
                System.out.print("Categoria = "+poema1.getCategoria().getCategory_id()+" , ");
                System.out.print("Usuario = "+poema1.getUsuario().getUser_id()+" , ");
                System.out.print("Fecha Final = "+ formato.format(poema1.getDate_approved())+" , ");
                System.out.println(" ");
            }*/
 /*  
           //Insertar Poema
           String fecha_c= "2021-05-06 00:00:00";
           String fecha_d = "2021-06-06 00:00:00";
           Date fecha_1 =formato.parse(fecha_c);
           Date fecha_2 = formato.parse(fecha_d);
           Poem poema1 = new Poem();
           Categories categoria = new  Categories(3);
           Users usuario= new   Users(10);
           poema1.setTitle("Arde en tus ojos");
           poema1.setPoem("Arde en tus ojos un misterio, virgen esquiva y compañera");
           poema1.setDate_submitted(fecha_1);
           poema1.setCategoria(categoria);
           poema1.setUsuario(usuario);
           poema1.setDate_approved(fecha_2);
           
           poema.insertar(poema1);
             */

 /*
         //Actualizar Poema.
         String fecha_c= "2021-04-05 10:10:00";
         String fecha_d= "2021-04-05 10:10:00";
         Date fecha_1=formato.parse(fecha_c);
         Date fecha_2 = formato.parse(fecha_d);
         Categories categoria = new Categories(2);
         Users usuario = new Users(9);
         Poem poemaAct = new Poem();
         poemaAct.setPoem_id(6);
         poemaAct.setTitle("Arde tus ojos 1");
         poemaAct.setPoem("Arde en tus ojos un misterio, virgen esquiva y compañera");
         poemaAct.setDate_submitted(fecha_1);
         poemaAct.setCategoria(categoria);
         poemaAct.setUsuario(usuario);
         poemaAct.setDate_approved(fecha_2);
         
         poema.update(poemaAct);  */
            poema.delete(new Poem(6));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

}
