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
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Path;

/**
 *
 * @author Simon
 */
public class FileToUser {
    
    int UserCount=1;
    int EintraegeCount=1;
    int UseriD=1;
    String activeUser;
    
    
    

    public void setActiveUser(String activeUser){
        this.activeUser=activeUser;
    }
    public String getActiveUser(){
        return this.activeUser;
    }
   
    public void OpenFile(String username,javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort,javax.swing.JTextArea jTextAreaDomain) throws IOException{
        if(username.equals("admin")){
            OpenAdminFile(jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort);
        }else{
            OpenUserFile(username,jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort, jTextAreaDomain);
        }
    }    
        public void OpenUserFile(String username,javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort,javax.swing.JTextArea jTextAreaDomain) throws IOException{
        ReadTxtFile rtxtf = new ReadTxtFile();
        rtxtf.FileReaderUser(username,jTextAreaNummer,jTextAreaBenutzername,jTextAreaPasswort,jTextAreaDomain);
    }
        public void OpenAdminFile(javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort) throws IOException{
        ReadTxtFile rtxtf = new ReadTxtFile();
        rtxtf.FileReaderAdmin(jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort);
    }    
    
    public int getAllUserCount() throws FileNotFoundException, IOException{
        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "adminList.txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
            }
                File file =  new File(testURL.toString());
        BufferedReader brTest = new BufferedReader(new FileReader(file));
      int lineCount = 1;
        String line = brTest.readLine();
                while (line != null) {
                        line = brTest.readLine();
                        lineCount++;
                }    
                UserCount = lineCount/3;
                return UserCount;
    }
    public int getEintraegeCount(String username) throws FileNotFoundException, IOException{
        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "user_"+username+".txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
            }
                File file =  new File(testURL.toString());
        BufferedReader brTest = new BufferedReader(new FileReader(file));
        int lineCount = 1;
        String line = brTest.readLine();
                while (line != null) {
                        line = brTest.readLine();
                        lineCount++;    
                }      
                EintraegeCount = lineCount/4;
                return EintraegeCount;
    }
    
    public void newFileForUser(String username) throws FileNotFoundException, IOException{
            URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "user_"+username+".txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
            }
                File file =  new File(testURL.toString());
        Writer userWriter = new FileWriter(file);
        }   
    
    
    
}