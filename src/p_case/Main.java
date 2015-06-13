/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_case;


import Methods.EditAndDelete;
import Methods.FileToUser;
import Methods.ReadTxtFile;
import Screens.Login;
import java.io.IOException;

/**
 *
 * @author Simon
 * gutes pw:   AbC1&z8c
 *          
 *   
 *
 */
public class Main{
    
    public static void main(String args[]) throws IOException {
        //new Login().setVisible(true);    
        
        FileToUser abc = new FileToUser();
        String b = "Username6";
        abc.getSpecificUseriD(b);
    }   
}
