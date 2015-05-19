/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_case;

/**
 *
 * @author Robin
 */
public class AccesData {

    String user;
    String password;

    public AccesData() {

    }

    public AccesData(String user, String password) {
        this.user = user;
        this.password = password;

    }

    public void setUser(String s) {
        this.user = s;

    }

    public void setPassword(String s) {
        this.password = s;
    }

    @Override

    public String toString() {
        return user + password;
    }

    public static void main(String[] args) {
        AccesData data1 = new AccesData();
        data1.setPassword("1234");
        data1.setUser("admin");

  
    }
}
