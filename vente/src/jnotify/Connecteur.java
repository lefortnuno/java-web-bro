/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnotify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author -TROFEL-
 */
public class Connecteur {
    Connection con;
    public Connecteur(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.err.println(e); //Afficher les erreurs
        }
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bddvente","root","");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    Connection ObtenirConnections (){return con;}
}
