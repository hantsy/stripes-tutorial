/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

/**
 *
 * @author hantsy
 */
public class BaseActionBean implements ActionBean {
    ActionBeanContext context;

    public void setContext(ActionBeanContext context) {
        this.context=context;
    }

    public ActionBeanContext getContext() {
        return this.context;
    }

}
