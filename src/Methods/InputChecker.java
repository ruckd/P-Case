/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class InputChecker extends ReadTxtFile{
    private String pwChecked;
    private String usernameChecked;
    public InputChecker(){
    }
    public InputChecker(String usernameChecked, String pwChecked) {
        this.usernameChecked = usernameChecked;
        this.pwChecked = pwChecked;
        
    }
    public boolean passwordChecker(String password) {
		int anzahlKleinBuchstaben = 0;
		int anzahlGrossBuchstaben = 0;
		int anzahlZiffern = 0;
		int anzahlSonderzeichen = 0;
		for (int i = 0; i < password.length(); i++) { 		
			char c = password.charAt(i); 			
			if (Character.isDigit(c)) {
				anzahlZiffern++;
			}
			if (Character.isLowerCase(c)) {
				anzahlKleinBuchstaben++;
			}
			if (Character.isUpperCase(c)) {
				anzahlGrossBuchstaben++;
			}
			if (!Character.isLetterOrDigit(c)) {
				anzahlSonderzeichen++;
			}
		}
		return password.length() >= 8 && anzahlZiffern >= 2
				&& anzahlKleinBuchstaben >= 1 && anzahlGrossBuchstaben >= 1
				&& anzahlSonderzeichen >= 1;
	}
//to do!
    public boolean userNameSame(String usernameString) throws IOException{
      boolean bool1=true;
      FileReader f = new FileReader(super.path + super.path2 +"adminList.txt");
       BufferedReader b = new BufferedReader(new FileReader(super.path + super.path2 +"adminList.txt"));
       String cnt=b.readLine();
            //solange die zeile nicht leer ist,zeile lesen.
            while(cnt != null){
                    String cnt2 = b.readLine();
                //eingabe username mit gelesener zeile vergleichen    
                if(usernameString.equals(cnt2)){
                //bool1=true;
                }else{
                // bool1=false;
           }
           }
            return bool1;
    }

//to do!    
    public boolean usernamePasswordCheckerSame(String username,String password) throws IOException{
        boolean usernamePasswordChecker=false;
        InputChecker usernamepasswordchecker = new InputChecker();
        int lineCounter=0;
        FileReader fileR = new FileReader(super.path + super.path2 +"adminList.txt");
        BufferedReader bufferedR = new BufferedReader(new FileReader(super.path + super.path2 +"adminList.txt"));
        String lineStringusername=bufferedR.readLine();
        String lineStringpassword = bufferedR.readLine();
        
    //username und passwort vergleichen ob zusammenpassen
        
        //username checken ob schon vorhanden´
        if(usernamepasswordchecker.userNameSame(username)){
        //wenn true, dann passwort checken    
            
            //solange die zeile ungleich username ist, zeilenanzahl zählen
            while(lineStringusername != username){
                bufferedR.readLine();
                lineCounter++;
            }
                //Filereader schließen
                fileR.close();
                //sobald die zeilenzahl eine mehr als username ist
                for(int i= 0;i==lineCounter+1;i++){
                    lineStringpassword=bufferedR.readLine();
                }
                //Filereader schließen
                fileR.close();
                    //wenn passwort mit string übereinstimmt,bool ->true
                    if(lineStringpassword==password){
                    usernamePasswordChecker=true;
                }
                //wenn username und passwort nicht zusammen passen,fehlermeldung
                else{
                    JOptionPane.showMessageDialog(null,"Benutzername und Passwort stimmen nicht überein!");
                }
        }
        //wenn username nicht gleich, fehlermeldung
            else{
                JOptionPane.showMessageDialog(null,"Dieser Username existiert nicht!");
            }
        //Filereader schließen
        fileR.close();
        
        
        
        return usernamePasswordChecker;
    }
}
    
    

