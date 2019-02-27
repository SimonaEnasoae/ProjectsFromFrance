package filters;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import plugin.Plugin;

public class PluginFilter implements FilenameFilter {

	//ATTRIBUTE
		/**
		 * String with suffix to verify .class files
		 */
		private static final String SUFFIX = ".class";

		//METHODS
		/**
		 * method which defines the filter's condition
		 * 
		 * @param dir is the directory where the file is located
		 * @param name is the filename
		 * @return true if the name parameter ends with specified suffix, false otherwise
		 */
		public boolean accept(File dir, String name) {
			boolean suffix = name.endsWith(SUFFIX);
			if( suffix == false) {
				return false;
			}
			String nameClass = name.substring(0, name.length()- 6);
			try {
				Class plugin = Class.forName("plugin."+nameClass);
				
				Constructor constructor = plugin.getConstructor();
								
				
				if (! (plugin.Plugin.class).isAssignableFrom(plugin)) {
					return false ;
				}
				Package p = plugin.getPackage();
				if(!p.getName().equals("plugin")) {
					return false;
				}
				
				Method methTransform = plugin.getMethod("transform", String.class);
				Method methGetLabel = plugin.getMethod("getLabel");
				Method methHelpMessage = plugin.getMethod("helpMessage");
				
			} catch (NoSuchMethodException e) {
				return false;
			} catch (SecurityException e) {
				return false;
			}
			 catch (ClassNotFoundException e) {
				 return false;
			}
			
			return true;
			
		}

}
