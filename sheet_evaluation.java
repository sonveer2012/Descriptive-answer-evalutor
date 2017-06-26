/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import static javaapplication3.file_utility.ANS_SHEET;
import static javaapplication3.file_utility.MODAL;


/**
 *
 * @author Ashu
 */
public class sheet_evaluation {
    
    /**
     *
     * @param file
     * @return
     */
    public static String preprocess_modal_answer(String file){
        
        file = file.replaceAll("/","//");
        file_utility.extract_keyword(file,MODAL);
        return ("This is done modal answer");
    }
    
    
    //function for processing the inserted answersheet
    
    public static String process_answer_sheet(String file){
        
        file = file.replaceAll("/","//");
        file_utility.extract_keyword(file,ANS_SHEET);
        return ("Answer sheet");
    }
}
