package p_case;

import java.io.File;

/**
 *
 * @author ruckd
 */
public abstract class User {

    private final String userName;
    private final String userPasswd;
    protected boolean adm;

    public User(String userName, String userPasswd) {
        
        this.userName = userName;
        this.userPasswd = userPasswd;  
        this.adm =true;
    }
}
