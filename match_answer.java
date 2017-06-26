import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class match_answer {
  public static void main(String args[]){
      String str="",str1="";
      int len=0;
    int i,j,k;
    try{
      FileReader fr=new FileReader("C:\\Users\\Dell\\Desktop\\model answer.txt");
      BufferedReader br =new BufferedReader(fr);
     while((str=br.readLine())!=null){
         
         i=0;
         len=str.length();
         while(len!=0){
         j= str.indexOf('.');
         str1=str.substring(i,j);
         
          str=str.substring(j+1);
         System.out.println(str1);
          len=str.length();
         }
      }
      
  }
    catch(Exception e){
        
    }
    
  }  
    
}
