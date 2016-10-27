package by.htp6.directorychecker;

import java.io.File;

public class Program {

	public static void main(String[] args) {
		String filePath = "resources1";
		File file = new File(filePath);
		DirectoryChecker directoryChecker = new DirectoryChecker(file);
		
		try {
			directoryChecker.start();
			Thread.sleep(100000);
			directoryChecker.setStopFlag(true);
			directoryChecker.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
