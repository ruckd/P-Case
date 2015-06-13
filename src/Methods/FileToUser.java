/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

/**
 *
 * @author Simon
 */
public class FileToUser {
    
    int UserCount=1;
    int EintraegeCount=1;
    int UseriD=1;
    
    public void OpenUserFile(String Username, javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort,javax.swing.JTextArea jTextAreaDomain) throws IOException{
        int SpecificUserId = getSpecificUseriD(Username);
        ReadTxtFile rtxtf = new ReadTxtFile();
        rtxtf.FileReaderUser(SpecificUserId,jTextAreaNummer,jTextAreaBenutzername,jTextAreaPasswort,jTextAreaDomain);
    }
    public void OpenAdminFile(javax.swing.JTextArea jTextAreaNummer,javax.swing.JTextArea jTextAreaBenutzername,javax.swing.JTextArea jTextAreaPasswort) throws IOException{
        ReadTxtFile rtxtf = new ReadTxtFile();
        rtxtf.FileReaderAdmin(jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort);
    }    

    
    public int getAllUserCount() throws FileNotFoundException, IOException{
        BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList - Kopie (3).txt"));
        String line = brTest.readLine();
                while (line != null) {
                    for(int i = 0;i<3;i++){
                        brTest.readLine();
                        brTest.readLine();
                        brTest.readLine();
                        line = brTest.readLine();
                        UserCount = UserCount+1;
                    }
                }      
                return UserCount;
    }
    public int getSpecificUseriD(String Username) throws FileNotFoundException, IOException{
        
    
        BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList - Kopie (3).txt"));
        String line = brTest.readLine();
            
        int a = getAllUserCount()*3;
        for(int i = 0;i<a;i++){

             if(line == null ? Username != null : !line.equals(Username)){
                    line = brTest.readLine();
                    UseriD = UseriD+1;
                    }
        }
        int usId = (UseriD-2)/3;
        return usId;
    }
    public int getEintraegeCount(int UseriD) throws FileNotFoundException, IOException{
        BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList2.txt"));
        String line = brTest.readLine();
                while (line != null) {
                    for(int i = 0;i<3;i++){
                        brTest.readLine();
                        brTest.readLine();
                        brTest.readLine();
                        brTest.readLine();
                        line = brTest.readLine();
                        EintraegeCount = EintraegeCount+1;
                    }
                }      
                return EintraegeCount;
    }
    public void newFileForUser() throws FileNotFoundException, IOException{
        getAllUserCount();
        for(int i = 0;i<UserCount;i++){
            int newUserCount = UserCount+1;
        Writer userWriter = new FileWriter("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\user"+newUserCount+".txt");
        }   
    }
    
    
}