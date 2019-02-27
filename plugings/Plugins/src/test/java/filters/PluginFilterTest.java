package filters;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class PluginFilterTest {

	
	@Test
	public void testAccept() {
		String workingDir = System.getProperty("user.dir");
    	File rep = new File(workingDir+"/testDriectory");
    	
    	File file = new File(workingDir+"/testDirectory/PluginTest.class");
    	String name = file.getName();
    	PluginFilter pluginFilter = new PluginFilter();
    	    	
    	assertTrue(pluginFilter.accept(rep, name));
	}

}
