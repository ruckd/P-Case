/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultStyledDocument;

/**
 *
 * @author Simon
 */
public class WriteInTxtFile{
    
    
  
    Writer fw = null;

    public void schreibenInUserList(String jTextFieldUsername,String jTextFieldPassword,String jTextFielddomain) {
       FileToUser ftu1=new FileToUser();
        try{
            URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "user_"+ftu1.getActiveUser()+".txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
                    //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                    //FileWriter fileW = new FileWriter (path + path2 + "user" + countUser+".txt",true);
                    FileWriter fileW = new FileWriter ("C:\\Users\\nt-user1\\Documents\\NetBeansProjects\\P-Case\\src\\resources\\user0.txt",true);
                    //buffered writer, der schreibt.
                    BufferedWriter b = new BufferedWriter (fileW);
                    //Text der geschrieben werden soll
                    
                    b.newLine();
                    b.write(ftu1.getEintraegeCount(ftu1.getActiveUser()));        
                    b.newLine();
                    b.write(jTextFieldUsername);
                    b.newLine();
                    b.write(jTextFieldPassword);
                    b.newLine();
                    b.write(jTextFielddomain);
                    b.newLine();

                    //schließen
                    b.close();
            //wenn datei nicht existiert wird sie hier erstellt
                }else{
                    
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
    public void schreibenInAdminList(String jTextFieldUsername,String jPasswordFieldPassword,String jPasswordFieldPasswordCheck) {
        //neuen leeren writer erstellen
        Writer fw = null;
        InputChecker inputCheck = new InputChecker();
        try{
            
            
            URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "adminList.txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
            
                    //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                    FileWriter fileW = new FileWriter (file,true);
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
                            FileToUser ftu1=new FileToUser();
                            b.newLine();
                            b.write(""+ftu1.getAllUserCount());
                            b.newLine();
                            b.write(jTextFieldUsername);
                            b.newLine();
                            b.write(jPasswordFieldPassword);
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
                    JOptionPane.showMessageDialog(null,"Die Adminlistendatei wurde gelöscht oder verschoben und kann nicht gefunden werden!");
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
    
    
    //wieso das untere???
    
    public void schreibenInAdminListNoCheck(String iD,String username,String password) throws IOException{
        Writer fw = null;
        try{       
            URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "adminList.txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
            }
                File file =  new File(testURL.toString());
                
                //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                FileWriter fileW = new FileWriter (file,true);
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
            URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "adminList.txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
            }
                File file =  new File(testURL.toString());
                //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                FileWriter fileW = new FileWriter (file,true);
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


}
