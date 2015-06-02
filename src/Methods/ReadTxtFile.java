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
public class ReadTxtFile extends WriteInTxtFile {
    
    private String[][] content;
    private String x;
    
    public String[][] getTextArray(){
      return content;  
    }
    public void FileReaderAdmin(javax.swing.JTextArea jTextArea) throws FileNotFoundException, IOException{
    //Pfad der Datei angeben            
        FileReader f = new FileReader(super.path + super.path2 +"adminList.txt");
        BufferedReader b = new BufferedReader(f);
        int n = 0;
        String cnt=b.readLine();
            //solange die zeile nicht leer ist,zeile lesen.
            while( cnt != null){
                n++;
                cnt = b.readLine();
            }
                //reader schliessen
                f.close();
                //stringarray erstellen mit "n" speicherplatz
                content=new String[n/4][4];
                //reader wieder öffnen
                f = new FileReader(super.path + super.path2 +"adminList.txt");
                b = new BufferedReader(f);
                //das was in der zeile steht, an stelle "i" des StringArray speichern
                for(int i = 0;i<n/5;i++){
                        for(int j=0;j<4;j++){
                            for(int k = 0;k<4;k++){
                                content[i][k] = b.readLine();
                            //code ausgeben  BEMERKUNG: eine zeile am anfang zu viel
                                jTextArea.setText(jTextArea.getText() + "" +content[i][k]);
                            }
                           //neue zeile nach den 4 daten(nr,username,pw,domain)
                            jTextArea.setText(jTextArea.getText() +"\n");
                        }    
                }
                    f.close();                   
    }
    public void FileReaderUser(javax.swing.JTextArea jTextArea) throws FileNotFoundException, IOException{
    //Pfad der Datei angeben            
        FileReader f = new FileReader(super.path + super.path2 + "user" + "variable" +".txt");
        BufferedReader b = new BufferedReader(f);
        int n = 0;
        String cnt=b.readLine();
            //solange die zeile nicht leer ist,zeile lesen.
            while( cnt != null){
                n++;
                cnt = b.readLine();
            }
                //reader schliessen
                f.close();
                //stringarray erstellen mit "n" speicherplatz
                content=new String[n/4][4];
                //reader wieder öffnen
                f = new FileReader(super.path + super.path2 + "user" + "varible" +".txt");
                b = new BufferedReader(f);
                //das was in der zeile steht, an stelle "i" des StringArray speichern
                for(int i = 0;i<n/5;i++){
                        for(int j=0;j<4;j++){
                            for(int k = 0;k<4;k++){
                                content[i][k] = b.readLine();
                            //code ausgeben  BEMERKUNG: eine zeile am anfang zu viel
                                jTextArea.setText(jTextArea.getText() + "" +content[i][k]);
                            }
                            //neue zeile nach den 4 daten(nr,username,pw,domain)
                            jTextArea.setText(jTextArea.getText() +"\n");
                        }    
                }
                    f.close();
    }
    //code zum lesen
        //    ReadTxtFile def = new ReadTxtFile();
        //    def.Filereaderexample();
    
    
    
}
