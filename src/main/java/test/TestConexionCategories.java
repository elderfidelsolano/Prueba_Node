/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import conexion.CategoriesDaoJDBC;
import conexion.Conexion;
import domain.Categories;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class TestConexionCategories {
    public static void main(String[] args) {
        Connection conexion = null;
        List<Categories> lista = null;
        try {
            
            conexion= Conexion.getConnection();
            CategoriesDaoJDBC categories = new CategoriesDaoJDBC(conexion);
            /*
            //LIstar Categorias
            lista= categories.select();
            for(Categories categoria1 : lista){
                System.out.print("Id Categoria = "+categoria1.getCategory_id());
                System.out.print(" Categoria = "+ categoria1.getCategory());
                System.out.println("");
                
            }
            */
            
            /*
            //Insertar Categoria
            
            Categories categoria1 = new Categories();
            categoria1.setCategory("prueba");
            categories.insertar(categoria1);
            
            */
            
            /*
            //Actualizar Categoria
            
            Categories categoria1 = new Categories();
            categoria1.setCategory_id(5);
            categoria1.setCategory("relleno");
            categories.update(categoria1);
            */
            
            categories.delete(new Categories(5));
            
        } catch (SQLException ex) {
            Logger.getLogger(TestConexionCategories.class.getName()).log(Level.SEVERE, null, ex);
        
        
        
        } 
        
    }
}
