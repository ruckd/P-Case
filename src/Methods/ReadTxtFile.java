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
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class ReadTxtFile extends WriteInTxtFile{
    
    
    public void FileReaderUser(String username, javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort,javax.swing.JTextArea jTextAreaDomain) throws FileNotFoundException, IOException{
        
        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "user_"+username+".txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
        BufferedReader brTest = new BufferedReader(new FileReader(file));
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
}else{
                JOptionPane.showMessageDialog(null, "Dieser Eintrag existiert nicht und daher kann nicht aus ihm gelesen werden!");
            }
    }
    public void FileReaderAdmin(javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort) throws FileNotFoundException, IOException{

String absoluteFilePath = System.getProperty("user.dir") + File.separator +"src"+File.separator+"resources" + File.separator+ "adminList.txt";
                File file = new File(absoluteFilePath);
                if(file.exists()){
            
        BufferedReader brTest = new BufferedReader(new FileReader(file));
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
}else{
                JOptionPane.showMessageDialog(null, "Die Adminliste existiert nicht und kann daher nicht bearbeitet werden!");
            }
    }
    public void FileReaderFAQ() throws FileNotFoundException{
        
        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "FAQ.txt");
            if(testURL != null){
                File file =  new File(testURL.toString()); 
                
                BufferedReader in = new BufferedReader(new FileReader(file));
                
                String faqs = "";
                if (in != null) {
            try {
                for (String line; (line = in.readLine()) != null;) {
                    faqs += line;
                    faqs += "\n";
                }
            } catch (IOException ie) {

            }
        }
        JOptionPane.showMessageDialog(null, faqs);
    }else{
                JOptionPane.showMessageDialog(null, "Die FAQ Datei exisitert nicht und kann daher nicht gelesen werden!");
            }
    }
            
    
}

