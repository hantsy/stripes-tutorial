/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

/**
 *
 * @author hantsy
 */
public class UserSession {

    private boolean logined;
    private String username;

    public void setLogined(boolean logined) {
        this.logined = logined;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogined() {
        return true;
    }

    public String getUsername() {
        return "Stripes";
    }
}
