/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.Arrays;

/**
 *
 * @author Ashu
 */
public class file_utility {
        
    /**
     *
     */
    
    public static final int MODAL = 1;
    public static final int ANS_SHEET = 0;
    public static Connection conn = (Connection) database_connection.connect("dae","root","");
	
	static void extract_keyword(String path,int type){
		File f = new File(path);
                
		String c;
		try{
		  
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                        while((c=in.readLine())!=null){
                                    
                           //java split on the basis of the regular expression
                           //in regular expression . means anything
                           String[] lines = c.split("\\.");
                           
                           for (String line : lines) {
                                
                                String[] words = line.split(" ");
                                
                                for (String word1 : words) {
                                    System.out.print(word1+" ");
                                    String word = word_replacement(word1);
                                    if (word==null) {
                                        System.out.println(word1);
                                    } else {
                                        System.out.println(word);
                                    }
                                }
                            }
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
    	static String word_replacement(String word){
		String query = "select word_replacement from word_list where word='"+word+"'";
		ResultSet rs = database_connection.getResult(conn, query);
		try{
			if(rs.next()){
				return rs.getString("word_replacement");
			}
			else{
				return word;
			}
		}catch(Exception e){
			System.out.println(e.getMessage()+"\n"+Arrays.toString(e.getStackTrace()));
			return null;
		}
	}
        
        static void modal_ans_store(String word){
            
        }   
        
        static void check_answer(String word){
            
        }
        
}
