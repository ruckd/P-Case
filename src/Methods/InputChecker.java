/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

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
    public boolean userNameChecker(String username){
       
       ReadTxtFile usernamechecker = new ReadTxtFile();
    //schauen ob username existiert
       return true; 
    }
//to do!    
    public boolean usernamePasswordChecker(String password,String username){
        ReadTxtFile usernamepasswordchecker = new ReadTxtFile();
    //username und passwort vergleichen ob zusammenpassen
        return true;
    }
}
    
    

