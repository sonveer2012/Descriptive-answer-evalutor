import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class feed_model_answer {
    
    
    public static void main(String args[]){
        String query,x="shanu";
         try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/descriptive_answer","root","shanu");
            Statement stmt=con.createStatement();
            query="create table model_answer(ques_no int, key_words varchar(30));";
            stmt.execute(query);
           
    }
         catch(Exception e){
             System.out.println(""+e);
         }
    }
    
}
