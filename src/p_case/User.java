package p_case;

/**
 *
 * @author ruckd
 */
public abstract class User {

    private String userName;
    private String userPasswd;
    private final int iD;
    private static int nextID = 1;

    public User(int iD, String userName, String userPasswd) {
        this.iD = nextID++;
        this.userName = userName;
        this.userPasswd = userPasswd;
    }

    public int getID() {
        return this.iD;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return this.userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

}
