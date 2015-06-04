/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class EditAndDelete {
    
    String path5 = System.getProperty("user.dir");
    String path6 = "/src/resources/";
    
    public String getPath(){
        return path5 + path6;
    }
    
    public EditAndDelete(){
    }
    public void DeleteForAdmin(String iD,String username,String password) throws IOException{
        
        FileReader f = new FileReader(path5 + path6 +"adminList.txt");
        BufferedReader brDelete = new BufferedReader(f);
        try {
            StringBuilder sb = new StringBuilder();
                String line = brDelete.readLine();
                while (line != null) {
                    if(line.matches(iD)){
                        sb.append(iD);
                        sb.append("\n");
                        sb.append(username);
                        sb.append("\n");
                        sb.append(password);
                        sb.append("\n");
                        line = brDelete.readLine();
                    }else{
                        sb.append(line);
                        sb.append("\n");
                        line = brDelete.readLine();
                    }
                }

    } finally {
        brDelete.close();
    }

    }
    public void DeleteForUser(String iD,String username,String password,String domain) throws IOException{

        
        FileReader f = new FileReader(path5 + path6 +"adminList.txt");
        BufferedReader brDelete = new BufferedReader(f);
        try {
            StringBuilder sb = new StringBuilder();
                String line = brDelete.readLine();
                while (line != null) {
                    if(line.matches(iD)){
                        sb.append("-0");
                        sb.append("\n");
                        line = brDelete.readLine();
        }else{
                        sb.append(line);
                        sb.append("\n");
                        line = brDelete.readLine();
                    }
                }
        

        
    } finally {
        brDelete.close();
    }
}
    public void EditForUser(String iD,String username,String password,String domain) throws FileNotFoundException, IOException    {
        
        BufferedWriter nooverWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt", true)));
        Path path = Paths.get("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt");    
            //schauen ob datei existiert
            if (Files.exists(path)){
                Scanner scanner = new Scanner(path);
                    while(scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        nooverWrite.write(line);
                        if(line == null ? iD == null : line.equals(iD)){
                            scanner.nextLine();
                            scanner.nextLine();
                            scanner.nextLine();
                            nooverWrite.newLine();
                            nooverWrite.write(username);        
                            nooverWrite.newLine();
                            nooverWrite.write(password);  
                            nooverWrite.newLine();
                            nooverWrite.write(domain);
                        }
                        nooverWrite.newLine();
                    }
            scanner.close();
                nooverWrite.close();
            }else{
                JOptionPane.showMessageDialog(null,"Der Username existiert nicht und kann daher nicht bearbeitet werden!");
            }
    }
    public void EditForAdmin(String iD,String username,String password) throws FileNotFoundException, IOException{

        BufferedWriter nooverWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt", true)));
        Path path = Paths.get("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt");    
            //schauen ob datei existiert
            if (Files.exists(path)){
                Scanner scanner = new Scanner(path);
                    while(scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        nooverWrite.write(line);
                        if(line == null ? iD == null : line.equals(iD)){
                            scanner.nextLine();
                            scanner.nextLine();
                            scanner.nextLine();
                            nooverWrite.newLine();
                            nooverWrite.write(username);        
                            nooverWrite.newLine();
                            nooverWrite.write(password);        
                        }
                        nooverWrite.newLine();
                    }
            scanner.close();
                nooverWrite.close();
            }else{
                JOptionPane.showMessageDialog(null,"Der Username existiert nicht und kann daher nicht bearbeitet werden!");
            }
    }
  
    }

        
        
    
    
    
    
    
    

