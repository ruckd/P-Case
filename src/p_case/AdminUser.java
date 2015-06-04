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
    String path3 = System.getProperty("user.dir");
    String path4 = "/src/resources/";
    public AdminUser(String userName, String userPasswd) {        
        super(userName, userPasswd);
        super.adm = true;
       
    }

    //User adminUser = new AdminUser(1, "administrator", "1234", true);
}
