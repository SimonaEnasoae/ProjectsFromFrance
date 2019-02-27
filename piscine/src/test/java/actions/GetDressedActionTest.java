package actions;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import actions.foreseeable.ForeseeableAction;
import actions.foreseeable.GetDressedAction;

public class GetDressedActionTest extends ForeseeableActionTest{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			
			
        File file = new File("../mess.log");
 		FileOutputStream fos = new FileOutputStream(file);
 		PrintStream ps = new PrintStream(fos);
 		System.setOut(ps);
 	    
	}
	public ForeseeableAction createAction(int n){
		return new GetDressedAction(n);
	}

}
