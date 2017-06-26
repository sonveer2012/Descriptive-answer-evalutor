
import java.io.BufferedReader;
import java.io.FileReader;
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





public class autocorrect {
    
    
    
    
    public static int dictionary_check(String str){
      String strf = new String();
      
      String filename="C:\\Users\\Dell\\Desktop\\dictionary\\dictionary_words"+str.substring(0,1).toUpperCase()+".txt";
      int flag=0;
        try{
        FileReader fr = new FileReader(filename);
            BufferedReader bb = new BufferedReader(fr);
             while((strf = bb.readLine()) != null)
            {
               // i = strf.indexOf(":");
                //sub = strf.substring(0,i);
                
                
                if(str.compareTo(strf)<0)
                    break;
                        
                if(str.equals(strf))
                {
                    System.out.println(strf);
                    flag=1;
                }
        
            }
            
            bb.close();

           /* if(flag==0){
             
               
                System.out.println("Word not found");
            }
                   */
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;

}
    
    public static void add_letters(String str){
        
        int i,j,len;
        String str1="", str2="", str3;
        char ch='a';
        len=str.length();
        
        for(j=1;j<=26;j++){
            
        
        str3=ch+str;
        dictionary_check(str3);
   
       // System.out.println(str3);
        for(i=1;i<=len;i++){
          str1=str.substring(0,i);
          str2=str.substring(i,len);
          str3=str1+ch+str2;
          dictionary_check(str3);
          /*if(dictionary_check(str3)!=1){
                add_letters(str);
      remove_letters(str);
        switch_adj(str);
        substitute_letter(str);
          }*/
              
          //str2=str.substring()
         // System.out.println(str3);
        }
        ch++;
      }
    }
    
    public static void remove_letters(String str){
        
        int i,j,len;
        String str1="", str2="", str3;
        char ch='a';
        len=str.length();
         str3=str.substring(1,len);
        dictionary_check(str3);
        //System.out.println(str3);
         /* if(dictionary_check(str3)!=1){
                add_letters(str);
      remove_letters(str);
        switch_adj(str);
        substitute_letter(str);
          }
         */
        for(i=1;i<len;i++){
        str1=str.substring(0,i);
          str2=str.substring(i+1,len);
            str3=str1+str2;
           // dictionary_check(str3);
            //System.out.println(str3);
             /* if(dictionary_check(str3)!=1){
                add_letters(str);
      remove_letters(str);
        switch_adj(str);
        substitute_letter(str);
            */
          
        }  
    }
    
    public static void switch_adj(String str){
        int i,j,len;
        String str1="", str2="", str3;
        char ch1,ch2;
        len=str.length();
        for(i=0;i<len-1;i++){
            str1=str.substring(0,i);
            ch1= str.charAt(i);
            ch2=str.charAt(i+1);
            str2=str.substring(i+2);
            str3=str1+ch2+ch1+str2;
            //dictionary_check(str3);
           // System.out.println(str3);
              /*if(dictionary_check(str3)!=1){
                add_letters(str);
      remove_letters(str);
        switch_adj(str);
        substitute_letter(str);
            
          }*/
        } 
        
    }
    public static void substitute_letter(String str){
         int i,j,len;
        String str1="", str2="", str3;
        char ch;
        len=str.length();
        for(j=0;j<len;j++){
                str1=str.substring(0,j);
                str2=str.substring(j+1);
                ch='a';
                for(i=1;i<=26;i++){
                str3=str1+ch+str2;
               dictionary_check(str3);
              //  System.out.println(str3);
                 /* if(dictionary_check(str3)!=1){
                add_letters(str);
      remove_letters(str);
        switch_adj(str);
        substitute_letter(str);
          }
                 */
                ch++;
                  }
            }
    }
    
    public static void read_file(){
        String str= new String();
        try{
        FileReader fr = new FileReader("C:\\Users\\Dell\\Desktop\\test.txt");
            BufferedReader bb = new BufferedReader(fr);
            while((str = bb.readLine()) != null){
               if(dictionary_check(str)==1)
            System.out.println(str);
        else{
        add_letters(str);
      remove_letters(str);
        switch_adj(str);
        substitute_letter(str);
        }   
               System.out.println("\n");
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    
    
    {
        
        String str="conection",str1="",str2="",str3;
        char ch='a',ch1,ch2;
     
      //add a letter
        int i,len,j;
        len=str.length();
     read_file();
      
        //remove letter
       
        //switch two adjacent letters
        
       
       
        //substitute letters
        
        
        
        
            
        
        
        
    } 
    
    
    
    
    
    
    
    
  
 }
