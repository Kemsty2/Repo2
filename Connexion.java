package projetpfa;

import java.sql.*;

public class Connexion {
    Connection con;
    // Chemin du chargement de la pilote
    String urlPilote;//"oracle.jdbc.driver.Oracledriver";
    // Chemin d'accès à la base de donnée
    String urlBaseDonnees;//="jdbc:oracle:thin:@localhost:1521:xe";
    String username;
    String pwd;
    Statement stm;
    
    public Connexion(String username,String pwd){
        // Chargement de pilote de connection
        // Connecter à la base de donnée
        this.urlPilote="oracle.jdbc.driver.Oracledriver";
        this.urlBaseDonnees="jdbc:oracle:thin:@localhost:1521:xe";
        this.username=username;
        this.pwd=pwd;
        try {
            Class.forName(urlPilote);
            System.out.println("Pilote chargée....");
        } catch (ClassNotFoundException e) {
            System.out.println(e); 
        }
        try {
            con=DriverManager.getConnection(urlBaseDonnees,this.username,this.pwd);
            stm=con.createStatement();
            //System.out.println("Connection à la base de donnée....");
        } catch (SQLException e) {
            //System.err.println(e);
        }
        
    }
    Statement getstm(){
        return stm;
    }

    
  
}

