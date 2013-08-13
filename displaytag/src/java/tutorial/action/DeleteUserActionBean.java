/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import tutorial.dao.Users;

/**
 *
 * @author hantsy
 */
public class DeleteUserActionBean extends BaseActionBean {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resolution delete() {
        Users.deleteUser(id);
        return new RedirectResolution(ListUserActionBean.class);
    }
}
