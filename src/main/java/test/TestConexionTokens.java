/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mysql.cj.xdevapi.ExprParser;
import conexion.Conexion;
import conexion.TokensDaoJDBC;
import domain.Tokens;
import domain.Users;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class TestConexionTokens {

    public static void main(String[] args) {
        Connection conexion = null;
        List<Tokens> lista = null;
        try {
            conexion = Conexion.getConnection();
            TokensDaoJDBC token = new TokensDaoJDBC(conexion);

                //Listar tokens
            lista=token.select_id(new Users(2));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Date fecha = (Date) formato.(token_expires);
            
            for(Tokens rs : lista){
                System.out.print("Token iD = "+ rs.getToken_id()+ ", ");
                System.out.print("Token = "+rs.getToken()+ ", ");
                System.out.print("Id Usuario ="+ rs.getUsuario().getUser_id()+ ", ");
                System.out.print("Fecha ="+  formato.format(rs.getDate_expired()));
                System.out.println(" ");
            }
                /*Insertar token
            String fecha_c= "2021-04-05)";
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_f=formato.parse(fecha_c);
            Users usuariotemp = new Users(5);
            Tokens tokentemp = new Tokens();
            tokentemp.setToken("all");
            tokentemp.setUsuario(usuariotemp);
            tokentemp.setDate_expired(fecha_f);
            token.insertar(tokentemp);*/
                
                //Actualizar token
                /*
            String fecha_c= "2021-04-05)";
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_f=formato.parse(fecha_c);
            Users usuarioAct = new Users(6);
            Tokens tokenAct = new Tokens();
            tokenAct.setToken_id(7);
            tokenAct.setToken("part");
            tokenAct.setUsuario(usuarioAct);
            tokenAct.setDate_expired(fecha_f);
            token.update(tokenAct);
            */
                /*
                //Eliminar token
            token.delete(new Tokens(7));*/
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ParseException ex) {
            Logger.getLogger(TestConexionTokens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
