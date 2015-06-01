/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Simon
 */
public class WriteInTxtFile {
    
    
    
    public void schreiben() {
        Writer fw = null;
        try{
            //pfad der datei angeben
            fw = new FileWriter( "PFAD_DER_DATEI" );
            //text der geschrieben werden soll eingeben
            fw.write( "TEXT" );
            //z.b. neue zeile erstellen   zum beispiel "\n"
            fw.append( System.getProperty("line.separator") ); 
            fw.append("TEXT");
        }catch(IOException e){
            System.err.println( "Konnte Datei nicht erstellen" );
        }
        finally {
           if(fw!=null)
            try{
                fw.close(); 
            } catch ( IOException e ) {
            e.printStackTrace(); 
            }
        }    
    }   
    
    
    //code zum schreiben
        //    WriteInTxtFile abc = new WriteInTxtFile();
        //    abc.schreiben();
    
    
    
}
