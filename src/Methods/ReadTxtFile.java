/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Simon
 */
public class ReadTxtFile {
    
    
    
    public void Filereaderexample() throws FileNotFoundException, IOException{
        
    //Pfad der Datei angeben            
        FileReader f = new FileReader("PFAD_DER_DATEI");
        BufferedReader b = new BufferedReader(f);
        int n = 0;
        String cnt=b.readLine();
            while( cnt != null){
                n++;
                cnt = b.readLine();
            }
                f.close();
                String[] content=new String[n];
                f = new FileReader("PFAD_DER_DATEI");
                b = new BufferedReader(f);
                for(int i = 0;i<n;i++){
                    content[i] =b.readLine();
                }
                    f.close();
                    for(String x:content){
                        System.out.print(x+" - ");
                    }
    }
    
    //code zum lesen
        //    ReadTxtFile def = new ReadTxtFile();
        //    def.Filereaderexample();
    
    
    
}
