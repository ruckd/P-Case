/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_case;

/**
 *
 * @author ruckd
 */
public class NormalUser extends User {

    public NormalUser(int iD, String userName, String userPasswd) {
        super(iD, userName, userPasswd);
        super.adm = false;
    }
    
    // User normalUser = new NormalUser(1,Bob,marlboro,false);
}
