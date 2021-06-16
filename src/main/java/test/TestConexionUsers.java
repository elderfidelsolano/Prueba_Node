package test;

import conexion.Conexion;
import conexion.UsersDaoJDBC;
import domain.Users;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.xml.registry.infomodel.User;

public class TestConexionUsers {

    public static void main(String[] args) throws ParseException {
        Connection conexion = null;
        List<Users> lista = null;
        try {

            conexion = Conexion.getConnection();
            UsersDaoJDBC usuario = new UsersDaoJDBC(conexion);

            String startDateString = "2020-05-06 00:00:00";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = null;
            Date fecha_actualizar = new Date();
            Date fecha1 = new Date();

            try {
                startDate = (Date) df.parse(startDateString);
                fecha1 =  (Date) df.parse(fecha_actualizar.toString());
//                String newDateString = df.format(startDate);
//                System.out.println(newDateString);
            } catch (ParseException e) {
                e.printStackTrace(System.out);
            }
            //Actualizar Usuario
//            Users usuario1 = new Users();
//            usuario1.setUser_id(1);
//            usuario1.setFirst_name("Elder");
//            usuario1.setLast_name("Solano");
//            usuario1.setEmail("elder12_0543@hotmail.com");
//            usuario1.setUsername("elder");
//            usuario1.setPass_phrase("eld");
//            usuario1.setIs_admin(2);
//            usuario1.setDate_registered(fecha1);
//            usuario1.setProfile_pic("slasl");
//            usuario1.setRegistration_cponfirmed(1);
//            
//            usuario.update(usuario1);
//

//            lista = usuario.select();
//            for (Users user : lista) {
//                System.out.println(" Primer Nombre = "+user.getFirst_name());
//                System.out.println(" Apellido = "+ user.getLast_name());
//                System.out.println(" Email = "+ user.getEmail());
//                System.out.println(" Username = "+user.getUsername());
//                System.out.println(" Pass = "+ user.getPass_phrase());
//                System.out.println(" Admin ="+ user.getIs_admin());
//                System.out.println("Fecha Registro = "+ user.getDate_registered());
//                System.out.println("Perfil = "+user.getProfile_pic());
//                System.out.println(" Numero Regiitro = "+user.getRegistration_cponfirmed());
//
//            }
//            usuario.insertar(new Users("FInal", "Final", "final@hotmail.com", "final", "fin", 2, startDate, "fi", 1));
              usuario.delete(new Users(11));
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
