package domain;

import java.util.Date;
import java.util.List;

public class Tokens {

    private int token_id;
    private String token;
    private Users usuario;
    private Date date_expired;
    public List<Users> listaUsuarios;

    public Tokens() {
    }

    public Tokens(String token, Users usuario, Date date_expired) {
        this.token = token;
        this.usuario = usuario;
        this.date_expired = date_expired;
        listaUsuarios.add(usuario);
    }

    public Tokens(int token_id, String token, Users usuario, Date date_expired) {
        this.token_id = token_id;
        this.token = token;
        this.usuario = usuario;
        this.date_expired = date_expired;
    }

    public List<Users> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Users> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDate_expired() {
        return date_expired;
    }

    public void setDate_expired(Date date_expired) {
        this.date_expired = date_expired;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

}
