/**
 * @author Simon
 * 
 */

/**
 * @DOKUMENTATION
 *
 * 
 * OpenFile:
 * String angemeldeter User
 *      wenn "admin" öffne OpenAdminFile
 *      sonst OpenUserFile
 * OpenUserFile:
 * öffnet FileReaderUser
 * 
 * OpenAdminFile:
 * öffnet FileReaderAdmin
 * 
 * getAllUserCount:
 * zählt registrierte User (Einträge AdminList /3)
 * 
 * getAllEintraegeCount:
 * zählt Einträge vom User
 * 
 * newFileForUser:
 * Erstellt neue Datei für User
 * 
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
import javax.swing.JOptionPane;

public class FileToUser {

    int UserCount = 1;
    int EintraegeCount = 1;
    int UseriD = 1;
    String activeUser;

    public String setActiveUser(String activeUser) {
        return this.activeUser = activeUser;
    }

    public String getActiveUser() {
        return this.activeUser;
    }

    public void OpenFile(String username, javax.swing.JTextArea jTextAreaNummer, javax.swing.JTextArea jTextAreaBenutzername, javax.swing.JTextArea jTextAreaPasswort, javax.swing.JTextArea jTextAreaDomain) throws IOException {
        if (username.equals("admin")) {
            OpenAdminFile(jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort);
        } else {
            OpenUserFile(username, jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort, jTextAreaDomain);
        }
    }

    public void OpenUserFile(String username, javax.swing.JTextArea jTextAreaNummer, javax.swing.JTextArea jTextAreaBenutzername, javax.swing.JTextArea jTextAreaPasswort, javax.swing.JTextArea jTextAreaDomain) throws IOException {
        ReadTxtFile rtxtf = new ReadTxtFile();
        rtxtf.FileReaderUser(username, jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort, jTextAreaDomain);
    }

    public void OpenAdminFile(javax.swing.JTextArea jTextAreaNummer, javax.swing.JTextArea jTextAreaBenutzername, javax.swing.JTextArea jTextAreaPasswort) throws IOException {
        ReadTxtFile rtxtf = new ReadTxtFile();
        rtxtf.FileReaderAdmin(jTextAreaNummer, jTextAreaBenutzername, jTextAreaPasswort);
    }

    public int getAllUserCount() throws FileNotFoundException, IOException {
        String absoluteFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources" + File.separator + "adminList.txt";
        File file = new File(absoluteFilePath);

        BufferedReader brTest = new BufferedReader(new FileReader(file));
        int lineCount = 1;
        String line = brTest.readLine();
        while (line != null) {
            line = brTest.readLine();
            lineCount++;
        }
        UserCount = lineCount / 3;
        return UserCount;
    }

    public int getEintraegeCount(String username) throws FileNotFoundException, IOException {
        String absoluteFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources" + File.separator + "user_" + username + ".txt";
        File file = new File(absoluteFilePath);
        BufferedReader brTest = new BufferedReader(new FileReader(file));
        int lineCount = 1;
        String line = brTest.readLine();
        while (line != null) {
            line = brTest.readLine();
            lineCount++;
        }
        EintraegeCount = lineCount / 4;
        return EintraegeCount;
    }

    public void newFileForUser(String username) throws FileNotFoundException, IOException {
        try {
            String absoluteFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources" + File.separator + "user_" + username + ".txt";
            File file = new File(absoluteFilePath);

            if (file.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Sie haben sich erfolgreich Registriert!");
            } else {
                JOptionPane.showMessageDialog(null, "Die Registrierung ist fehlgeschlagen!");
            }

        } catch (IOException e) {
            System.out.println("newFileToUser error");
        }
    }

}
