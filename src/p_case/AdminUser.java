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
public class AdminUser extends User {

    public AdminUser(int iD, String userName, String userPasswd) {
        //this.AdminUser = new User(){};

        super(iD, userName, userPasswd);
        super.adm = true;
    }

    //User adminUser = new AdminUser(1, "administrator", "1234", true);
}
