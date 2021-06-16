/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.List;

public class Poem {
    private int poem_id;
    private String title;
    private String poem;
    private Date date_submitted;
    private Categories categoria;
    private Users usuario;
   /* private List<Users> listaUsuarios;
    private List<Categories> listaCategorias;*/
    private Date date_approved;

    public Poem() {
    }

    public Poem(int poem_id) {
        this.poem_id = poem_id;
    }

    public Poem(String title, String poem, Date date_submitted, Categories categoria, Users usuario, Date date_approved) {
        this.title = title;
        this.poem = poem;
        this.date_submitted = date_submitted;
        this.categoria = categoria;
        this.usuario = usuario;
        /*
        this.listaUsuarios = listaUsuarios;
        this.listaCategorias = listaCategorias;*/
        this.date_approved = date_approved;
    }

  

    public Poem(int poem_id, String title, String poem, Date date_submitted, Categories categoria, Users usuario, Date date_approved) {
        this.poem_id = poem_id;
        this.title = title;
        this.poem = poem;
        this.date_submitted = date_submitted;
        this.categoria = categoria;
        this.usuario = usuario;
        /*
        this.listaUsuarios = listaUsuarios;
        this.listaCategorias = listaCategorias;*/
        this.date_approved = date_approved;
    }

  
    

    public int getPoem_id() {
        return poem_id;
    }

    public void setPoem_id(int poem_id) {
        this.poem_id = poem_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoem() {
        return poem;
    }

    public void setPoem(String poem) {
        this.poem = poem;
    }

    public Date getDate_approved() {
        return date_approved;
    }

    public void setDate_approved(Date date_approved) {
        this.date_approved = date_approved;
    }

    public Categories getCategoria() {
        return categoria;
    }

    public void setCategoria(Categories categoria) {
        this.categoria = categoria;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
/*
    public List<Users> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Users> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Categories> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categories> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
*/
    public Date getDate_submitted() {
        return date_submitted;
    }

    public void setDate_submitted(Date date_submitted) {
        this.date_submitted = date_submitted;
    }
            
                                                                                                                                                                    
}
