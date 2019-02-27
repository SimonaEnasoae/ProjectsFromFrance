package fil.coo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Test;

public class FileCheckerTest {
	
	protected class MockFileListener implements FileListener {
		
		protected boolean checkFileAdded = false;
		protected boolean checkFileRemoved = false;

		//METHODS
		public void fileAdded(FileEvent fileEvent) {
			checkFileAdded = true;
		}
		
		public void fileRemoved(FileEvent fileEvent) {
			checkFileRemoved = true;
		}

	}
	public class MockFilter  implements FilenameFilter {
		
		//ATTRIBUTES
		private static final String PREFFIX = "m";

		public boolean accept(File dir, String name) {
			return name.startsWith(PREFFIX);
		}

	}
	

	protected FileChecker createFileChecker(int delay) {
		String pathname = "testDirectory";
		String file = "testDirectory/mock";
		File f = new File(pathname);
		f.mkdirs();
		File fi = new File(file);
		try {
			fi.createNewFile();
		} catch (IOException e) {}
		
		return new FileChecker(f,new MockFilter(),delay);
		
	}
	@Test
	public void testAddListener() {
		MockFileListener mockListener =new MockFileListener();
		int delay = 200;
		FileChecker fileChecker = createFileChecker(delay);
		fileChecker.addListener(mockListener);
		assertTrue(fileChecker.fileListeners.contains(mockListener));
		
		
	}
	@Test
	public void testRemoveListener() {
		MockFileListener mockListener =new MockFileListener();
		int delay = 200;
		FileChecker fileChecker = createFileChecker(delay);
		fileChecker.addListener(mockListener);
		assertTrue(fileChecker.fileListeners.contains(mockListener));
		fileChecker.removeListener(mockListener);
		assertFalse(fileChecker.fileListeners.contains(mockListener));
	}

	
	@Test
	public void testActionPerformedAdded() {
		MockFileListener mockListener =new MockFileListener();
		int delay =200;
		FileChecker fileChecker = createFileChecker(delay);
		fileChecker.addListener(mockListener);
		fileChecker.start();
		assertFalse(mockListener.checkFileAdded);

		try {
			 Thread.sleep(delay*2);
			 assertTrue(mockListener.checkFileAdded);
		} catch (InterruptedException e) {}
	
		fileChecker.stop();

	}
	@Test
	public void testActionPerformedRemoved() {
		MockFileListener mockListener =new MockFileListener();
		int delay =200;
		FileChecker fileChecker = createFileChecker(delay);
		fileChecker.addListener(mockListener);
		fileChecker.start();
		
		assertFalse(mockListener.checkFileRemoved);
		String file2 = "testDirectory/mock2";
		File fi = new File(file2);
		
		try {
			 fi.createNewFile();
			 Thread.sleep(delay*2);
			 fi.delete();
			 Thread.sleep(delay*2);
			 assertTrue(mockListener.checkFileRemoved);

		} catch (InterruptedException e) {
		}
		 catch (IOException e1) {
		}
		fileChecker.stop();

	}

}
