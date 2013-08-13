/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.util.HashMap;
import java.util.Map;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockServletContext;
import org.testng.annotations.BeforeTest;

/**
 *
 * @author hantsy
 */
public class TestFixture {

    private static MockServletContext context;

    public void setupNonTrivialObjects() {
        TestFixture.context = new MockServletContext("testing");

        // Add the Stripes Filter
        Map<String, String> filterParams = new HashMap<String, String>();
        filterParams.put("ActionResolver.Packages", "tutorial.action");
        context.addFilter(StripesFilter.class, "StripesFilter", filterParams);
        

        // Add the Stripes Dispatcher
        context.setServlet(DispatcherServlet.class, "StripesDispatcher", null);
    }

    public static MockServletContext getServletContext() {
        return TestFixture.context;
    }
}
