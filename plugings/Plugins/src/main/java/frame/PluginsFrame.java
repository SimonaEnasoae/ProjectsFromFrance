package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fil.coo.FileEvent;
import fil.coo.FileListener;
import plugin.Plugin;
/**
 * Class PluginsFrame
 * 
 * @author Enasoae Simona, Marcel Fernandez de la Pena
 *
 */
public class PluginsFrame extends JPanel implements FileListener {
	
	//ATTRIBUTES
		/**
		 * The main frame
		 */
	   protected static JFrame mainFrame;
	   /**
	    * the control panel
	    */
	   protected JPanel controlPanel; 
	   /**
	    * the text area
	    */
	   protected JTextArea textArea;
	   /**
	    * the menu in the frame
	    */
	   protected JMenu fileMenu;
	   /**
	    * the plugin 
	    */
	   protected Plugin plugin;
	   
	   //CONSTRUCTOR
	   public PluginsFrame() {
			   createAndShowGUI();	  
		}
	   
	   /**
	    * Prepares and shows the frame and its components.
	    */
	   public void createAndShowGUI() {
 		mainFrame = new JFrame("Plugins");
	    mainFrame.setSize(400,400);
	    mainFrame.setLayout( new BorderLayout());
	    
	    mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());
 
	      mainFrame.add(controlPanel);
	      textArea = new JTextArea();
 	      textArea.setBounds(600,600,600,600);
 	      mainFrame.add(textArea);
 	}
 	
	/**
	 * Creates and shows menu compontents
	 */
 	public void showMenu(){
 		//create a menu bar
 		final  JMenuBar menuBar = new JMenuBar();
 		
 		 //create menus
 	      fileMenu = new JMenu("Menu");
 	      
 	      
 	   //add menu to menubar
 	      menuBar.add(fileMenu);
 	    
 	      mainFrame.setJMenuBar(menuBar);
          mainFrame.setVisible(true);

 	}
 	
 	/**
 	 * Add new menu with plugin's name to the menubar
 	 * 
 	 * @param fileEvent event for listening on filesystem changes
 	 */
	public void fileAdded(FileEvent fileEvent) {
		File file = (File) fileEvent.getSource();
		
		String className = file.getName().substring(0, file.getName().length()-6);
		 //create menu items
	      String label = null;
	      Plugin p = null;
	      try {
				Class plugin = Class.forName("plugin."+className);
				Constructor construct = plugin.getConstructor(null);
				p = (Plugin) construct.newInstance();
				Method methLabel = plugin.getMethod("getLabel");
				Object labelObj = methLabel.invoke(p);
				label = (String) labelObj;
				

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			}
	      MyJMenuItem newMenuItem = new MyJMenuItem(label,className);

	      newMenuItem.setMnemonic(KeyEvent.VK_N);
 	      newMenuItem.setActionCommand(label);

 	     PluginFrameAction pluginFrameAction = new PluginFrameAction(textArea,p);

 	     newMenuItem.addActionListener(pluginFrameAction);
 	     
 	  //add menu items to menus
 	      fileMenu.add(newMenuItem);
		
	}
	
	/**
	 * Removes menu with the deleted's file name
	 * 
	 * @param fileEvent event for listening on filesystem changes
	 */
	public void fileRemoved(FileEvent fileEvent) {
		File file = (File) fileEvent.getSource();
		String className = file.getName().substring(0, file.getName().length()-6);
		
		for(int i=0;i<fileMenu.getMenuComponentCount() ;i++){
			MyJMenuItem auxItem = (MyJMenuItem) fileMenu.getItem(i);
			if(auxItem.getClassName().equals(className)){
				fileMenu.remove(i);
			}
		}
	}
}
			
		