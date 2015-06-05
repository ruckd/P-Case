/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_case;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 *
 * @author ruckd
 */
public class NormalUser extends User{
    
    public int iD=1;
    public static int countuser2;
    Path pathUser = Paths.get("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\user+"+countuser2+ ".txt");
    Path pathAdmin = Paths.get("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt");    
    
    public NormalUser(String iD,String userName, String userPasswd) {
        super(userName, userPasswd);
        super.adm=false;
        int iDInt=Integer.parseInt(iD);
        iDInt=countuser2;
    }
//erstellt so viele user, wieviele gespeichert sind in der adminList.txt mit dem namen:   user "nummer" List.txt
//to do: hälfte der datien erstellen die im moment erstellt werden!
    public void userToFile() throws IOException{
        
        Scanner scanner = new Scanner(pathAdmin);
                countuser2 = 1;
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if(line == null){
                    }else{
                        if(Files.exists(pathUser)){
                            countuser2=countuser2+1;
                        }else{
                        Writer userWriter;
                        userWriter = new FileWriter("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\user"+countuser2+".txt");
                        countuser2=countuser2+1;
                        }
                    } 
                }
    }
}


// User normalUser = new NormalUser(1,Bob,marlboro,false);