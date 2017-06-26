import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class read_model {
  static  String stop_words[]={"a","about","above","after","again",
"against","all","am","an","and","any","are","aren't","as","at","be","because","been","before","being","below","between","both","but","by","can't","cannot","could","couldn't",
"did","didn't","do","does","doesn't","doing","don't","down","during","each","few","for","from","further","had","hadn't","has","hasn't","have","haven't","having","he","he'd","he'll","he's","her","here",
"here's","hers","herself","him","himself","his","how","how's","i","i'd","i'll","i'm","i've","if","in","into","is","isn't","it","it's","its","itself","let's","me","more","most","mustn't","my","myself","no","nor","not","of",
"off","on","once","only","or","other","ought","our","ours", "ourselves","out","over","own","same","shan't","she","she'd","she'll","she's","should","shouldn't","so","some","such","than","that","that's","the","their","theirs",
"them","themselves","then","there","there's","these","they","they'd","they'll","they're","they've","this","those","through","to","too","under","until","up","very","was","wasn't","we","we'd","we'll","we're","we've","were",
"weren't","what","what's","when","when's","where","where's","which","while","who","who's","whom","why","why's","with","won't","would","wouldn't","you","you'd","you'll","you're","you've","your","yours","yourself","yourselves"};
    int arr_len=174;
    static String[] question_words =new String[100];
    static int ques_arr_length;
    
    
    public static int search_stop_words(String word){
        
        int i=0,j=173,mid;
        mid=(i+j)/2;
        String str1="",str2="";
        str2=word.toUpperCase();
        while(i<=j){
            str1=stop_words[mid].toUpperCase();
            if(str1.equals(str2))
                return 1;
            else
                if(str1.compareTo(str2)>0)
                    j=mid-1;
             else
                    i=mid+1;
            mid=(i+j)/2;
            }
       // if(str1.equals(str2))
         //       return 1;
        
        return 0;
    }
    
 public static void read_model_answer(){
     String str="",str1="",type_paper="model",str2="",sen_type=" ";
      int len=0;
    int i,j,k,ctr=0;
    try{
      FileReader fr=new FileReader("C:\\Users\\Dell\\Desktop\\model answer.txt");
      BufferedReader br =new BufferedReader(fr);
     while((str=br.readLine())!=null){
         
         i=0;
       //  System.out.println(str);
         str2=str.substring(0,1);
         System.out.println(str2);
         if(str2.equals("Q")){
             
            // ctr=Integer.parseInt(str.substring(1,2));
             str=str.substring(3);
            
             System.out.println(str);
             sen_type="ques";
              
         }
         else{  
         ctr=Integer.parseInt(str.substring(0,1));
         str=str.substring(2);
         sen_type="ans";
         }
         
         len=str.length();
         while(len!=0){
         j= str.indexOf('.');
        // if(j<0)
          //   j=str.indexOf('?');
         str1=str.substring(0,j);
         //System.out.println("shanu jhxjnd");
         if(sen_type.equals("ans"))
         extract_keywords(str1,ctr,type_paper);
         else
            extract_keywords_ques(str1);
         System.out.println("jckfvcf");
          str=str.substring(j+1);
          System.out.println("xbnabxnacnmscdnc");
        // System.out.println(str1);
          len=str.length();
         }
      }
      
  }
    catch(Exception e){
        
        System.out.println(e+"yaha par kya");
        System.out.println(e.getMessage());
    }
    
  }  
    
 public static void extract_keywords_ques(String str){
     String str1="";
     System.out.println(str + "cbdbdf");
     int len=str.length(),j,ctr=0;
     while(len!=0){
         
          j=str.indexOf(' ');
          if(j<0){
              if(search_stop_words(str)==0){
                  question_words[ctr]=str;
              ctr++;
          }
              break;
          }
          
         str1=str.substring(0,j);
         str1=str1.trim();
         str=str.substring(j+1);
       //  System.out.println(str);
         len=str.length();
       //  System.out.println("iociecd");
         
         if(search_stop_words(str1)==0){
             //System.out.println("!:slkdj  "+ ctr);
             question_words[ctr]=str1;
         //System.out.println("!:slkdj  "+ ctr);
             ctr++;
     }
         }
      //System.out.println("xjnkajn");
         ques_arr_length=ctr;
         System.out.println(""+ctr);
    
     
 }
 
   public static void extract_keywords(String str, int ctr,String type_paper){
     String str1="";
     int len=str.length(),i=0,j,k;
    System.out.println("kya pata"+ques_arr_length);
     while(len!=0){
         j=str.indexOf(' ');
         if(j<0){
              if(search_stop_words(str)==0){
                  
                  for(k=0;k<ques_arr_length;k++){
                      if(str.equals(question_words[k]))
                          break;
                  }
                  if(k>=ques_arr_length)
               insert_into_table(ctr,str);
               
              }
                
                  
              break;
         }
   
         str1=str.substring(0,j);
         str1.trim();
         str=str.substring(j+1);
       
         len=str.length();
        if(search_stop_words(str1)==0){
            for(k=0;k<ques_arr_length;k++){
                      if(str1.equals(question_words[k]))
                          break;
                  }
            if(k>=ques_arr_length)
            insert_into_table(ctr,str1);
        }
             
     }
     
     
 }   
   
   /*   public static void extract_keywords_answer(String str, int ctr){
     
     
 }
   */

   
  public static  void create_table(String doc_name){
      String query="";
       int ctr=0,exist_table=0;
       try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/descriptive_answer","root","shanu");
            Statement stmt=con.createStatement();
           // String query="Select 1 from "+doc_name+" LIMIT 1;";
            
            
            
            String query1="Select * from table_count;";
            ResultSet rs=stmt.executeQuery(query1);
            
            while(rs.next()){
                ctr=rs.getInt("count");
            }
            ctr++;
            String table_name="model_answer";
            query="create table "+table_name+"(ques_no int, key_words varchar(30), match_key int);";
            stmt.execute(query);
             query1="update table_count set count="+ctr+";";
             stmt.executeUpdate(query1);
           
    }
         catch(Exception e){
             System.out.println(""+e);
              read_answer_paper();
              cal_marks();
             set_default();
             System.exit(0);
         }
   }
 
 public static void insert_into_table(int q_no, String key_word){
     String query,doc_name="model_answer";
     
     try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/descriptive_answer","root","shanu");
            Statement stmt=con.createStatement();
            query="insert into "+doc_name+" values("+q_no+",'"+key_word+"',0);";
            stmt.execute(query);
           
    }
         catch(Exception e){
             System.out.println(""+e);
            
         }
 }  
 
 public static int search_mysql(String word, int q_no){
     try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/descriptive_answer","root","shanu");
            Statement stmt=con.createStatement();
            String query= "Select * from model_answer where ques_no="+q_no+" and key_words='"+word+"'and match_key=0; ";
            System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                query="Update model_answer set match_key=1 where ques_no="+q_no+" and key_words='"+word+"';";
                System.out.println(query);
                stmt.executeUpdate(query);
                System.out.println(word);
                return 1;
            }
            
             
     }
     catch(Exception e){
         System.out.println(e+"");
     }
     
     
  return 0; 
 } 
 
 public static void read_answer_paper(){
    int i,ctr,j,len,len1,k, match=0;
    String str="", str1="",str2="",type_paper="answer";
     try{
     FileReader fi= new FileReader("C:\\Users\\Dell\\Desktop\\answer paper.txt");
     BufferedReader br =new BufferedReader(fi);
    
           
      while((str=br.readLine())!=null){
         System.out.println("shanu");
         i=0;
         ctr=Integer.parseInt(str.substring(0,1));
         str=str.substring(2);
         len=str.length();
         
         while(len!=0){
             
         j= str.indexOf('.');
         str1=str.substring(i,j);
         
         
         len1=str1.length();
         while(len1!=0){
         k=str1.indexOf(' ');
         if(k<0){
              if(search_stop_words(str1)==0)
                  match+=search_mysql(str1,ctr);
              
              break;
         }
   
         str2=str1.substring(0,k);
        str2= str2.trim();
         str1=str1.substring(k+1);
       
         len1=str1.length();
        if(search_stop_words(str2)==0){
            System.out.println(str2);
            match+=search_mysql(str2,ctr);
            
        }
     }
         str=str.substring(j+1);
         System.out.println(str1);
          len=str.length();
         }
      }
   
     
 } 
     catch(Exception e){
         
     }
     
     
     
     System.out.println(""+match);
     }  
 
 
 public static void set_default(){
         try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/descriptive_answer","root","shanu");
            Statement stmt=con.createStatement();
            String query="update model_answer set match_key=0;";
            stmt.executeUpdate(query);
         }
         catch(Exception e){
             
         }
 } 
 
 
 public static void cal_marks(){
     int full_marks=10,tot=0,corr=0,marks=0;
      try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/descriptive_answer","root","shanu");
            Statement stmt=con.createStatement();
            String query="select count(key_words),sum(match_key)from model_answer group by ques_no;";
           ResultSet rs= stmt.executeQuery(query);
           
           while(rs.next()){
               corr=rs.getInt("sum(match_key)");
               tot=rs.getInt("count(key_words)");
               marks+=(corr*full_marks)/tot;
            }
           
           System.out.println(marks+"");
         }
         catch(Exception e){
             
         }
     
 }
 
 public static void main(String args[]){
     
     create_table("bjnj");
    read_model_answer();
    read_answer_paper();
    cal_marks();
  set_default();
    
     
 }   
    
    
}
