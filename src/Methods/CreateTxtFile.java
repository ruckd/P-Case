/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Simon
 */
public class CreateTxtFile {
    
    
    public boolean createUserTXTDatei(File file){
    
        if (file != null) { 
                try { 
                    file.createNewFile(); 
                } catch (IOException e) { 
                    System.err.println("Error creating " + file.toString()); 
                } 
                if (file.isFile() && file.canWrite() && file.canRead()) 
                    return true; 
                } 
            return false; 
    }
    
    //Code für erstellen eines neuen dokuments:
        //      CreateTxtFile da = new CreateTxtFile(); 
        //      String dat = "test.txt";
    
    
}
