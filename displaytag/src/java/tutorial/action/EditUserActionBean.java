/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author hantsy
 */
public class EditUserActionBean extends BaseActionBean{

    public Resolution edit(){
        return  new ForwardResolution("/editUser.jsp");
    }
}
