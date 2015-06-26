/**
 * @author Simon
 */

/**
 *@DOKUMENTATION
 * 
 * schreibenInUserList:
 * Erstellt neuen BufferedWriter
 * nimmt die 4 Eingaben schreibt sie an Liste unten dran
 * sonst Fehlermeldung
 * 
 * schreibenInAdminList:
 * Erstellt neuen BufferedWriter
 * nimmt die 3 Eingaben schreibt sie an Liste unten dran
 * sonst Fehlermeldung
 * 
 * 
 * 
 */
package Methods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import javax.swing.JOptionPane;


public class WriteInTxtFile{
    
    
  
    Writer fw = null;

    public void schreibenInUserList(String jTextFieldUsername,String jTextFieldPassword,String jTextFielddomain) {
       FileToUser ftu1=new FileToUser();
        try{
                    String absoluteFilePath = System.getProperty("user.dir") + File.separator +"src"+File.separator+"resources" + File.separator+ "user_hanswurst.txt";
                File file = new File(absoluteFilePath);
                    //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                    //FileWriter fileW = new FileWriter (path + path2 + "user" + countUser+".txt",true);
                    FileWriter fileW = new FileWriter (absoluteFilePath,true);
                    //buffered writer, der schreibt.
                    BufferedWriter b = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(file,true)));
                    //Text der geschrieben werden soll
                    
                    
                    //aktiven user finden und die einträgecount schreiben
                    
                    
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


        }catch(IOException e){
            System.out.println("123");
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
            
             String absoluteFilePath = System.getProperty("user.dir") + File.separator +"src"+File.separator+"resources" + File.separator+ "adminList.txt";
 
        File file = new File(absoluteFilePath);
            
            
            if(file.exists()){
                System.out.println("hallo");
                    //neuer filewriter, (pfad der datei, true=wenn angehängt werden soll,false=wenn nicht angehängt sondern überschrieben
                    FileWriter fileW = new FileWriter (file,true);
                    //buffered writer, der schreibt.
                    BufferedWriter b = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(file,true)));
                
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
        Writer fileWriter = null;
        try{       
            URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "adminList.txt");
            if(testURL != null){
                 File file =  new File(testURL.toString());
            }
                File file =  new File(testURL.toString());
                FileWriter fileW = new FileWriter (file,true);
                BufferedWriter b = new BufferedWriter (fileW);
                    b.write(iD + "\n" + username + "\n" + password + "\n");
                    b.close();              
        }catch(IOException e){
            System.err.println( "Konnte Datei nicht erstellen" );
        }
        finally {
           if(fileWriter!=null)
            try{
                fileWriter.close(); 
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
                FileWriter fileW = new FileWriter (file,true);
                BufferedWriter b = new BufferedWriter (fileW);
                    b.write(schreib); 
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
