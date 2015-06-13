/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Simon
 */
public class ReadTxtFile extends WriteInTxtFile{
    
    private String[][] content;
 
    
    
    
    public String[][] getTextArray(){
      return content;  
    }
    public void FileReaderUser(int SpecificUserId, javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort,javax.swing.JTextArea jTextAreaDomain) throws FileNotFoundException, IOException{

        BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\user"+ SpecificUserId+".txt"));
        try {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            String line = brTest.readLine();
                while (line != null) {
                    sb1.append(line);
                        line = brTest.readLine();
                    sb2.append(line);
                        line = brTest.readLine();
                    sb3.append(line);
                        line = brTest.readLine();
                    sb4.append(line);  
                        line = brTest.readLine();

                    sb1.append("\n");
                    sb2.append("\n");
                    sb3.append("\n");
                    sb4.append("\n");
                }
            jTextAreaNummer.setText(jTextAreaNummer.getText() +sb1.toString());
            jTextAreaBenutzername.setText(jTextAreaBenutzername.getText() +sb2.toString());
            jTextAreaPasswort.setText(jTextAreaPasswort.getText() +sb3.toString());
            jTextAreaDomain.setText(jTextAreaDomain.getText() +sb4.toString());
        
    } finally {
        brTest.close();
    }
}
    public void FileReaderAdmin(javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort) throws FileNotFoundException, IOException{

        BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList - Kopie (3).txt"));
        try {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            
            
            String line = brTest.readLine();
                while (line != null) {
                    for(int i = 0;i<3;i++){
                        sb1.append(line);
                        line = brTest.readLine();
                    sb2.append(line);
                        line = brTest.readLine();
                    sb3.append(line);
                        line = brTest.readLine();

                    sb1.append("\n");
                    sb2.append("\n");
                    sb3.append("\n");
                    }
                }
                jTextAreaNummer.setText(jTextAreaNummer.getText() +sb1.toString());
                jTextAreaBenutzername.setText(jTextAreaBenutzername.getText() +sb2.toString());
                jTextAreaPasswort.setText(jTextAreaPasswort.getText() +sb3.toString());        
    } finally {
        brTest.close();
    }
}
    
}
