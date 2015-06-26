/**
 * @author Simon
 *
 */

/**
 * @DOKUMENTATION
 *
 * DeleteForUser:
 * Datei des angemeldeten Users finden/ prüfen ob sie existiert.
 * Bei Existenz:
 *      StringListe erstellen
 *      String mit Zeile der Datei
 *      Solange nicht NULL -> String an Liste -> String = nächste Zeile
 *      Index des zu löschenden Eintrags in der Liste => diese+3 Zeilen löschen
 *      Größe der Liste bestimmen, jedes 4er Paket ein neuer Index (Neue Nummerierung der Liste)
 *      Schreiben der Liste in Datei
 *      overWriter schließen
 * Else:
 *      Fehlermeldung
 * 
 * EditForUser:
 * Datei des angemeldeten Users finden/ prüfen ob sie existiert.
 * Bei Existenz:
 *      StringListe erstellen
 *      String mit Zeile der Datei
 *      Solange nicht NULL -> String an Liste -> String = nächste Zeile
 *      Index des zu bearbeitenden Eintrages in der Liste => nur nächste 3 bearbeiten
 *      Schreiben der Liste in Datei
 *      overWriter schließen
 * Else:
 *      Fehlermeldung
 * 
 * 
 * DeleteForAdmin:
 * Datei des angemeldeten Users finden/ prüfen ob sie existiert.
 * Bei Existenz:
 *      StringListe erstellen
 *      String mit Zeile der Datei
 *      Solange nicht NULL -> String an Liste -> String = nächste Zeile
 *      Index des zu löschenden Eintrags in der Liste => diese+2 Zeilen löschen
 *      Größe der Liste bestimmen, jedes 3er Paket ein neuer Index (Neue Nummerierung der Liste)
 *      Schreiben der Liste in Datei
 *      overWriter schließen
 * Else:
 *      Fehlermeldung
 * 
 * EditForAdmin:
 * Datei des angemeldeten Users finden/ prüfen ob sie existiert.
 * Bei Existenz:
 *      StringListe erstellen
 *      String mit Zeile der Datei
 *      Solange nicht NULL -> String an Liste -> String = nächste Zeile
 *      Index des zu bearbeitenden Eintrages in der Liste => nur nächste 2 bearbeiten
 *      Schreiben der Liste in Datei
 *      overWriter schließen
 * Else:
 *      Fehlermeldung
 *
 *
 *
 *
 */
package Methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditAndDelete {

    public EditAndDelete() {
    }

    public void DeleteForUser(String iD) throws IOException {
        FileToUser ftu = new FileToUser();
        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "user_" + ftu.getActiveUser() + ".txt");
        if (testURL != null) {
            File file = new File(testURL.toString());
            if (file.exists()) {
                BufferedReader brTest = new BufferedReader(new FileReader(file));

                ArrayList<String> userData = new ArrayList<String>();
                String line = brTest.readLine();
                while (line != null) {
                    userData.add(line);
                    line = brTest.readLine();
                }
                int zuLoeschendeNummer = userData.indexOf(iD);
                for (int i = 0; i < 4; i++) {
                    userData.remove(zuLoeschendeNummer);
                }
                int groesseListe = userData.size();
                for (int i = 0; i * 4 < groesseListe; i++) {
                    String abc = Integer.toString(i);
                    int dreierZaehler = i * 4;
                    userData.set(dreierZaehler, abc);
                }
                
                //schreiben der liste!!
                BufferedWriter overWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
                

                for (int i = 0; i < groesseListe; i++) {
                    overWriter.write(userData.get(i));
                    overWriter.write("\n");
                }
                overWriter.close();
            } else {
                JOptionPane.showMessageDialog(null, "Der Eintrag existiert nicht und kann daher nicht bearbeitet werden!");
            }
        }

    }

    public void EditForUser(String iD, String username, String password, String domain) throws FileNotFoundException, IOException {
        FileToUser ftu = new FileToUser();
        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "user_" + ftu.getActiveUser() + ".txt");
        if (testURL != null) {
            File file = new File(testURL.toString());
            BufferedReader brTest = new BufferedReader(new FileReader(file));
            ArrayList<String> userData = new ArrayList<String>();

            String line = brTest.readLine();
            while (line != null) {
                userData.add(line);
                line = brTest.readLine();
            }
            int zuLoeschendeNummer = userData.indexOf(iD);
            userData.set(zuLoeschendeNummer + 1, username);
            userData.set(zuLoeschendeNummer + 2, password);
            userData.set(zuLoeschendeNummer + 3, domain);

            BufferedWriter overWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(testURL.toString(), false)));

            overWrite.write(userData.toString());
            overWrite.close();

        } else {
            JOptionPane.showMessageDialog(null, "Der Eintrag existiert nicht und kann daher nicht bearbeitet werden!");
        }

    }

    public void DeleteForAdmin(String iD) throws IOException {

        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "adminList.txt");
        if (testURL != null) {
            File file = new File(testURL.toString());
            BufferedReader brTest = new BufferedReader(new FileReader(file));

            ArrayList<String> userData = new ArrayList<String>();
            String line = brTest.readLine();
            while (line != null) {
                userData.add(line);
                line = brTest.readLine();
            }
            int zuLoeschendeNummer = userData.indexOf(iD);
            for (int i = 0; i < 3; i++) {
                userData.remove(zuLoeschendeNummer);
            }
            int groesseListe = userData.size();
            for (int i = 0; i * 3 < groesseListe; i++) {
                String abc = Integer.toString(i);
                int dreierZaehler = i * 3;
                userData.set(dreierZaehler, abc);
            }
            BufferedWriter noOverWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
            //schreiben der liste!!
            for (int i = 0; i < groesseListe; i++) {

                noOverWriter.write(userData.get(i));
                noOverWriter.write("\n");

            }

            noOverWriter.close();
        } else {
            JOptionPane.showMessageDialog(null, "Der Eintrag existiert nicht und kann daher nicht bearbeitet werden!");
        }

    }

    public void EditForAdmin(String iD, String username, String password) throws FileNotFoundException, IOException {

        URL testURL = ClassLoader.getSystemResource("resources" + File.separator + "adminList.txt");
        if (testURL != null) {

            if (iD.equals("0") ^ username.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Der Benutzername des Administrators admin kann nicht verändert werden!");
            } else {
                File file = new File(testURL.toString());
                BufferedWriter nooverWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(testURL.toString(), true)));
                BufferedReader brTest = new BufferedReader(new FileReader(file));
                ArrayList<String> userData = new ArrayList<String>();
                String line = brTest.readLine();
                while (line != null) {
                    userData.add(line);
                    line = brTest.readLine();
                }
                int zuLoeschendeNummer = userData.indexOf(iD);
                userData.set(zuLoeschendeNummer + 1, username);
                userData.set(zuLoeschendeNummer + 2, password);
                BufferedWriter overWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(testURL.toString(), false)));

                overWrite.write(userData.toString());
                overWrite.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Der Eintrag existiert nicht und kann daher nicht bearbeitet werden!");
        }
    }
}
