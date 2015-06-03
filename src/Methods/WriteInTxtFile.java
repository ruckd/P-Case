/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JOptionPane;
import p_case.NormalUser;

/**
 *
 * @author Simon
 */
public class WriteInTxtFile{
    
    
    int countUser;
    String path = System.getProperty("user.dir");
    String path2 = "/src/resources/";
    Writer fw = null;
    



    
    
    public void schreibenUserList() {
           
        try{
        
                File file = new File(path + path2 + "user" + countUser+".txt");
            //wenn es die datei bereits gibt mache das:
                if (file.exists()) {
                    //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                    FileWriter fileW = new FileWriter (path + path2 + "user" + countUser+".txt",true);
                    //buffered writer, der schreibt.
                    BufferedWriter b = new BufferedWriter (fileW);
                    //Text der geschrieben werden soll
                    /*
                        String s;
                        s = "TEXT";
                        b.write(s);
                        b.newLine();
                    
                 */
                    //schließen
                    b.close();
            //wenn datei nicht existiert wird sie hier erstellt
                }else{
                    writeNewUserFile();
                    countUser++;
                }

        }catch(IOException e){
            System.err.println( "Konnte Datei nicht erstellen" );
        }
        finally {
           if(fw!=null)
            try{
                fw.close(); 
            } catch ( IOException e ) {
            }
        }    
    }
    public void writeNewUserFile() throws IOException{
        fw = new FileWriter(path + path2 + "user"+countUser+".txt");
        countUser++;
    }
    public void schreibenAdminList(javax.swing.JTextField jTextFieldUsername,javax.swing.JPasswordField jPasswordFieldPassword,javax.swing.JPasswordField jPasswordFieldPasswordCheck) {
        //neuen leeren writer erstellen
        Writer fw = null;
        InputChecker inputCheck = new InputChecker("a","b");
        try{
            
                File file = new File(path + path2 + "adminList.txt");
            //wenn es die datei bereits gibt mache das:
                if (file.exists()) {
                    //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                    FileWriter fileW = new FileWriter (path + path2 + "adminList.txt",true);
                    //buffered writer, der schreibt.
                    BufferedWriter b = new BufferedWriter (fileW);
                    //Text der geschrieben werden soll
                    
                  
                    if(inputCheck.userNameSame(jTextFieldUsername.getText())==true){
                        JOptionPane.showMessageDialog(null, "Dieser Username existiert bereits!");
                    }else{
                    //checken ob passwörter gleich sind
                      if(jPasswordFieldPassword.getText().equals(jPasswordFieldPasswordCheck.getText())){
                        //checken ob passwort "unsicher" ist
                        if(inputCheck.passwordChecker(jPasswordFieldPassword.getText())!=true){
                            JOptionPane.showMessageDialog(null, "Bitte benutzen Sie ein sicheres Passwort!");   
                        }else{
                            String usernameString = jTextFieldUsername.getText();
                            String pwString = jPasswordFieldPassword.getText();
                            b.write(usernameString);
                            b.newLine();
                            b.write(pwString);
                            b.newLine();
                            JOptionPane.showMessageDialog(null,"Sie haben sich erfolgreich registriert!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Die eingegebenen Passwörter stimmen nicht überein!");
                    }
                    //schließen
                    b.close();
                    }
            //wenn datei nicht existiert wird sie hier erstellt
                }else{
                    fw = new FileWriter(path + path2 + "adminList.txt");
                }

        }catch(IOException e){
            System.err.println( "Konnte Datei nicht erstellen" );
        }
        finally {
           if(fw!=null)
            try{
                fw.close(); 
            } catch ( IOException e ) {
            }
        }    
    }   
    
    //code zum schreiben
        //    WriteInTxtFile abc = new WriteInTxtFile();
        //    abc.schreiben();

}
