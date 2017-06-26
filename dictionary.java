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


public class dictionary {
   
   public static void main(String args[]){
        int i;
        boolean flag = false;
        String sub = new String();
        String strf = new String();

        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            FileReader fr = new FileReader("C:\\Users\\Dell\\Documents\\dictionary_words.txt");
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
                    flag=true;
                }
        
            }
            
            bb.close();

            if(!flag){
                str=br.readLine();
               
                System.out.println("Word not found");
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    } 
}
