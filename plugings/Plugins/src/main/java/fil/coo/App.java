package fil.coo;

import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.Timer;

import filters.PluginFilter;
import frame.PluginsFrame;
import plugin.Plugin;

/**
 * Class App
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
    	
    	String workingDir = System.getProperty("user.dir");
    	File file = new File(workingDir+"/repository");
    	PluginFilter filter= new PluginFilter();
    	PluginsFrame  pluginsFame = new PluginsFrame();     

    	FileChecker actLis= new FileChecker(file,filter,200);
    	FileObserver fileObserver = new FileObserver();
    	actLis.addListener(fileObserver);
        actLis.addListener(pluginsFame);
    	actLis.start();
    	pluginsFame.showMenu();

    	 while(true)
     	{}
		
    }
    
}
