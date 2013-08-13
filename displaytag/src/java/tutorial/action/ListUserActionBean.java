/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.action;

import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import tutorial.dao.Users;
import tutorial.model.User;

/**
 *
 * @author hantsy
 */
public class ListUserActionBean extends BaseActionBean {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    

    @DefaultHandler
    public Resolution listUsers(){
        users=Users.getUserList();
        return new ForwardResolution("/userList.jsp");
    }

}
