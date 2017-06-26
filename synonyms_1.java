
import java.util.Scanner;

import com.mysql.jdbc.Connection;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaapplication3.database_connection;

public class synonyms_1  {
        
	public static Connection conn = (Connection) database_connection.connect("dae","root","");
	
	static void convert_file_keyword(String path){
		File f = new File(path);
		String c = null;
		try{
		  
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			while((c=in.readLine())!=null){
				String[] words = c.split(" ");
				
				for(int i = 0 ; i< words.length; i++){
					String word = word_replacement(words[i]);
					if(word==null)
					   System.out.println(words[i]);
					else{
						if(word!=null)
							System.out.println(word);
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
			System.out.println(e.getMessage()+"\n"+e.getStackTrace());
			return null;
		}
	}

	
}
