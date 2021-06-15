/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class Users {


    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String pass_phrase;
    private int is_admin;
    private Date date_registered;
    private String profile_pic;
    private int registration_cponfirmed;
    public static List<Tokens> listatokens;
    private static List<Poem> listapoemas;
    
   public Users(){
       
   } 
   public Users(int user_id){
       this.user_id = user_id;
   }

    public Users(String first_name, String last_name, String email, String username, String pass_phrase, int is_admin, Date date_registered, String profile_pic, int registration_cponfirmed) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.pass_phrase = pass_phrase;
        this.is_admin = is_admin;
        this.date_registered = date_registered;
        this.profile_pic = profile_pic;
        this.registration_cponfirmed = registration_cponfirmed;
    }

    public Users(int user_id, String first_name, String last_name, String email, String username, String pass_phrase, int is_admin, Date date_registered, String profile_pic, int registration_cponfirmed) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.pass_phrase = pass_phrase;
        this.is_admin = is_admin;
        this.date_registered = date_registered;
        this.profile_pic = profile_pic;
        this.registration_cponfirmed = registration_cponfirmed;
    }
   
   
    public static List<Tokens> getListatokens() {
        return listatokens;
    }

    public static void setListatokens(List<Tokens> aListatokens) {
        listatokens = aListatokens;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass_phrase() {
        return pass_phrase;
    }

    public void setPass_phrase(String pass_phrase) {
        this.pass_phrase = pass_phrase;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public Date getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(Date date_registered) {
        this.date_registered = date_registered;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public int getRegistration_cponfirmed() {
        return registration_cponfirmed;
    }

    public void setRegistration_cponfirmed(int registration_cponfirmed) {
        this.registration_cponfirmed = registration_cponfirmed;
    }
    
     public static List<Poem> getListapoemas() {
        return listapoemas;
    }

    public static void setListapoemas(List<Poem> aListapoemas) {
        listapoemas = aListapoemas;
        }
}
