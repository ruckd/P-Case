/**
 *
 * @author Simon
 */

/**
 *@DOKUMENTATION
 *
 * passwordChecker:
 * Prüft Passwort auf mindestens:
 *       acht Zeichen,
 *       zwei Ziffern,
 *       einen Groß- und einen Kleinbuchstaben 
 *       ein Sonderzeichen
 * sonst Fehlermeldung
 * 
 * userNameSame:
 * prüft in Admin Liste ob User Name schon existiert
 * sonst Fehlermeldung
 * 
 * usernamePasswordCheckerSame:
 * prüft ob User Name, Passwort kombination existiert
 * sonst Fehlermeldung
 * 
 * 
 * 
 * 
 */


package Methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;


public class InputChecker extends ReadTxtFile{
    private String pwChecked;
    private String usernameChecked;
    public InputChecker(){
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
    public boolean userNameSame(String usernameString) throws IOException{
      boolean bool1=false;

            
            String absoluteFilePath = System.getProperty("user.dir") + File.separator +"src"+File.separator+"resources" + File.separator+ "adminList.txt";
                File file =  new File(absoluteFilePath);
      BufferedReader brUsernameSame = new BufferedReader(new FileReader(file));
      try{
          StringBuilder sbUsernameSame = new StringBuilder();
          String lineString = brUsernameSame.readLine();
          while(lineString != null){
              if(lineString.matches(usernameString)){
                  if(bool1==false){
                  JOptionPane.showMessageDialog(null,"Dieser Username existiert bereits!");
                  bool1 = true;
                  sbUsernameSame.append("");
                //lineString = brUsernameSame.readLine();
                  return bool1;
                  }
              }else{
                  bool1 =false;
                  sbUsernameSame.append("");
                  lineString=brUsernameSame.readLine();
              }
          }
      }finally{
          brUsernameSame.close();
      }
        return bool1;
    }
    public boolean usernamePasswordCheckerSame(String username,String password) throws IOException{
        boolean bool1=false;
 String absoluteFilePath = System.getProperty("user.dir") + File.separator +"src"+File.separator+"resources" + File.separator+ "adminList.txt";
                File file =  new File(absoluteFilePath);
      BufferedReader brUsernameSame = new BufferedReader(new FileReader(file));
      try{
          StringBuilder sbUsernameSame = new StringBuilder();
          String lineString = brUsernameSame.readLine();
          while(lineString != null){
                if(lineString.matches(username)){
                    lineString=brUsernameSame.readLine();
                    if(lineString.matches(password)){
                        if(bool1==false){
                            bool1 = true;
                            sbUsernameSame.append("");
                //lineString = brUsernameSame.readLine();
                  return bool1;
                        }
                    }
                }else{
                    
                    bool1 =false;
                    sbUsernameSame.append("");
                    lineString=brUsernameSame.readLine();
              }
          }
      }finally{
          brUsernameSame.close();
      }
        return bool1;
    }
    
}
    
    

