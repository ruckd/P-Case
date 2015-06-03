/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_case;

import java.io.File;
/**
 *
 * @author ruckd
 */
public class NormalUser extends User{
    
    public int iD=1;
    public static int countuser2 = 1;
    

    public NormalUser(String userName, String userPasswd) {
        super(userName, userPasswd);
        super.adm=false;
        iD=countuser2;
        countuser2++;
    }
    
    public void userToFile(User user, File file){
        
    }
    
    
    // User normalUser = new NormalUser(1,Bob,marlboro,false);
}
