package game.util;

import java.util.*;
import java.util.logging.Logger;

public class ListChoser {
	  public final static ListChoser SINGLETON = new ListChoser();
	  private ListChoser() {}
	/**
	 * show the elements from the list
	 * @param list a list with object of type T
	 * @param  <T> it is a parameterize method
	 */
	public static <T> void showMeniu( List<T> list){
		int index=0;
		for (T object:list){
			index+=1;
			System.out.println(index+" "+object.toString()+"\n");
		}
	}
	/**
	 * read a number and return the object with the index given
	 * @param str String , message to show
	 * @param list- a list with objects of type T
	 * @param  <T> it is a parameterize method
	 * @return an element from the list
	 */
	public static <T> T chose(String str, List<T> list){
		int index=0;
		showMeniu(list);
		String nr=Integer.toString(list.size());
		System.out.println(str);
		index = ScannerInt.readInt(list.size()+1);
		if( index == 0 ){
			return null;
		}
		else{
			return list.get(index-1);
		}	
	}

}
