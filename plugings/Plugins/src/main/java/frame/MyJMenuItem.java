package frame;

import javax.swing.JMenuItem;

import plugin.Plugin;

public class MyJMenuItem extends JMenuItem{
	String className;
	private static final long serialVersionUID = 1L;
	public MyJMenuItem (String label, String name) {
		super(label);
		this.className = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	

}
