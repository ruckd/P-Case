/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Simon
 */
public class ReadTxtFile extends WriteInTxtFile{
    
    private String[][] content;
 
    
    
    
    public String[][] getTextArray(){
      return content;  
    }
    
    
    
       
    public void FileReaderUser(javax.swing.JTextArea jTextArea) throws FileNotFoundException, IOException{

        BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = brTest.readLine();
                while (line != null) {
                    for(int i = 0;i<4;i++){
                        sb.append(line);
                        sb.append("-");
                        line = brTest.readLine();
                    }
                    sb.append("\n");
                }
            jTextArea.setText(jTextArea.getText() +sb.toString());
        
    } finally {
        brTest.close();
    }
}
    public void FileReaderAdmin(javax.swing.JTextArea jTextArea) throws FileNotFoundException, IOException{

        BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\Simon\\Desktop\\Wirtschaftsinformatik\\2_Semester\\PROJECTWorkspace\\P-Case\\build\\classes\\resources\\adminList.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = brTest.readLine();
                while (line != null) {
                    
                    for(int i = 0;i<3;i++){
                        sb.append(line);
                        sb.append("-");
                        line = brTest.readLine();
                    }
                    sb.append("\n");
                }
            jTextArea.setText(jTextArea.getText() +sb.toString());
        
    } finally {
        brTest.close();
    }
}

    //code zum lesen
        //    ReadTxtFile def = new ReadTxtFile();
        //    def.Filereaderexample();    
}
