/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.action;

import net.sourceforge.stripes.action.ActionBeanContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author hantsy
 */
public class HelloActionBeanTest {

    @Test
    public void sayHello(){
        HelloActionBean hello=new HelloActionBean();
        hello.setContext(new  ActionBeanContext());
        hello.setMessage("Stripes!");
        hello.sayHello();
        Assert.assertEquals("Hello,Stripes!", hello.getMessage());
        
    }

}
