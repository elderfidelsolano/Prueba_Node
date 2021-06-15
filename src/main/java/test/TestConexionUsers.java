package test;

import conexion.Conexion;
import conexion.UsersDaoJDBC;
import domain.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConexionUsers {

    public static void main(String[] args) throws ParseException {
        try {
            Connection conexion = null;
            conexion = Conexion.getConnection();
            UsersDaoJDBC usuario = new UsersDaoJDBC(conexion);
            String startDateString = "2020/05/06";
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date startDate = null;
            try {
                startDate = (Date) df.parse(startDateString);
//                String newDateString = df.format(startDate);
//                System.out.println(newDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            usuario.insertar(new Users("Allan", "Jaramillo", "allan@hotmail.com", "allan", "all", 2, startDate, "las", 1));

        } catch (SQLException ex) {
            Logger.getLogger(TestConexionUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
