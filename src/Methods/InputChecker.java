/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
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
    public boolean userNameSame(String usernameString) throws IOException{
      boolean bool1=false;
      BufferedReader brUsernameSame = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList - Kopie (3).txt"));
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
      BufferedReader brUsernameSame = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt"));
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
    
    

