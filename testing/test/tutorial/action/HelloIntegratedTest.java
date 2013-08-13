/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.util.HashMap;
import java.util.Map;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author hantsy
 */
public class HelloIntegratedTest {

    MockServletContext context;

    @BeforeTest
    public void setupNonTrivialObjects() {
        context = new MockServletContext("testing");

        // Add the Stripes Filter
        Map<String, String> filterParams = new HashMap<String, String>();
        filterParams.put("ActionResolver.Packages", "tutorial.action");
        context.addFilter(StripesFilter.class, "StripesFilter", filterParams);


        // Add the Stripes Dispatcher
        context.setServlet(DispatcherServlet.class, "StripesDispatcher", null);
    }

    @Test
    public void sayHelloTest() throws Exception {
        // Setup the servlet engine
        MockRoundtrip trip = new MockRoundtrip(context, HelloActionBean.class);
        trip.setParameter("message", "Stripes!");
        trip.execute("sayHello");

        HelloActionBean bean = trip.getActionBean(HelloActionBean.class);
        Assert.assertEquals("Hello,Stripes!", bean.getMessage());
        Assert.assertEquals(trip.getDestination(), "/greeting.jsp");
    }
}
