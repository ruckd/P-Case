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
    File file;



    
    
    public void schreibenInUserList(String jTextFieldUsername,String jTextFieldPassword,String jTextFielddomain) {
       try{
            
                File file = new File(path + path2 + "user" + countUser+".txt");
            //wenn es die datei bereits gibt mache das:
                if (file.exists()) {
                    
                    //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                    //FileWriter fileW = new FileWriter (path + path2 + "user" + countUser+".txt",true);
                    FileWriter fileW = new FileWriter (path + path2 + "adminList2.txt",true);
                    //buffered writer, der schreibt.
                    BufferedWriter b = new BufferedWriter (fileW);
                    //Text der geschrieben werden soll
                    
                    String domain = jTextFielddomain;
                    String username =jTextFieldUsername;
                    String password = jTextFieldPassword;
                    b.write(countUser + "\n" + username + "\n" + password + "\n" + domain + "\n");

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
    }
    public void schreibenInAdminList(String jTextFieldUsername,String jPasswordFieldPassword,String jPasswordFieldPasswordCheck) {
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
                    
                  
                    if(inputCheck.userNameSame(jTextFieldUsername)==true){
                        JOptionPane.showMessageDialog(null, "Dieser Username existiert bereits!");
                    }else{
                    //checken ob passwörter gleich sind
                      if(jPasswordFieldPassword.equals(jPasswordFieldPasswordCheck)){
                        //checken ob passwort "unsicher" ist
                        if(inputCheck.passwordChecker(jPasswordFieldPassword)!=true){
                            JOptionPane.showMessageDialog(null, "Bitte benutzen Sie ein sicheres Passwort!");   
                        }else{
                            String usernameString = jTextFieldUsername;
                            String pwString = jPasswordFieldPassword;
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
    public void schreibenInAdminListNoCheck(String iD,String username,String password) throws IOException{
        Writer fw = null;
        try{            
                File file = new File(path + path2 + "adminList.txt");
                //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                FileWriter fileW = new FileWriter (path + path2 + "adminList.txt",true);
                //buffered writer, der schreibt.
                BufferedWriter b = new BufferedWriter (fileW);
                //Text der geschrieben werden soll
                    b.write(iD + "\n" + username + "\n" + password + "\n"); 
                    //schließen
                    b.close();              
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
    public void schreibenInAdminListNoCheck(String schreib){
        Writer fw = null;
        try{            
                File file = new File(path + path2 + "adminList.txt");
                //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                FileWriter fileW = new FileWriter (path + path2 + "adminList.txt",true);
                //buffered writer, der schreibt.
                BufferedWriter b = new BufferedWriter (fileW);
                //Text der geschrieben werden soll
                    b.write(schreib); 
                    //schließen
                    b.close();              
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
