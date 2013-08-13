/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author hantsy
 */
public class HelloActionBean implements ActionBean{
    ActionBeanContext context;
    public void setContext(ActionBeanContext context) {
        this.context=context;
    }

    public ActionBeanContext getContext() {
        return this.context;
    }

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Resolution sayHello(){
        return new ForwardResolution("/greeting.jsp");
    }

}
