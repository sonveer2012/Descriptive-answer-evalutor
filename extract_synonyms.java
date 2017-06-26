import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class extract_synonyms  {
        
	public static void main(String args[]){
		try{
                    
		FileReader fi = new FileReader("C:\\Users\\Dell\\Desktop\\synonyms_list.txt");
		//File fo = new File("F:\\Ashutosh\\discriptive answer evaluator\\model_answers.txt");
		BufferedReader br = new BufferedReader(fi);
		//FileWriter out = null;
		
		
			//in = new BufferedReader(new InputStreamReader(new FileInputStream(fi)));
			
			//fo.createNewFile();
			//out = new FileWriter(fo);
                         Class.forName("com.mysql.jdbc.Driver").newInstance();
            java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/descriptive_answer","root","shanu");
            Statement stmt=con.createStatement();
		
			String c;
			while((c = br.readLine()) != null){
				
				//System.out.println(c);
		                String word[]=new String[60];
				word = c.split("-");
                                //System.out.println(word[0]);
				if(word.length >1){
				//System.out.println("Word is = " + word[0]);
                               
				String[] synonyms = word[1].split(",");
                               
				System.out.println(synonyms[0]);
				for(int i = 0; i<synonyms.length; i++){
					synonyms[i] = synonyms[i].trim();
					String query = "insert into word_list values('"+word[0]+"','"+synonyms[i]+"')";
					stmt.executeUpdate(query);
					//System.out.println(synonyms[i]);
				}
				}
				
			}
		}
		catch(Exception e){
                    System.out.println(e+"");
                }
	
		
	}
	
}

    
    

