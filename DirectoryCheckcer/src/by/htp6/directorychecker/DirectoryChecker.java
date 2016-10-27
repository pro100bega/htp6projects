package by.htp6.directorychecker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryChecker extends Thread {
	private File directory;
	private volatile boolean stopFlag;
	private String message;

	private List<String> lastDirectoryState;
	private List<String> currentDirectoryState;

	public boolean isStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	public DirectoryChecker(File directory) {
		this.stopFlag = false;
		this.directory = directory;
	}

	@Override
	public void run() {
		while (!stopFlag) {
			checkDirectory();
			try {
				sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void checkDirectory() {
		if (currentDirectoryState == null) {
			currentDirectoryState = new ArrayList<String>();
			for (String str : directory.list()) {
				currentDirectoryState.add(str);
			}
			System.out.println("Directory was initialized");
		} else {
			if (lastDirectoryState == null) {
				lastDirectoryState = new ArrayList<String>();
				refreshDirectories();
				checkIfChanged();
			} else {
				refreshDirectories();
				checkIfChanged();

			}
		}
	}

	private void refreshDirectories() {
		if (lastDirectoryState.size() != 0) {
			lastDirectoryState.clear();
		}
		lastDirectoryState.addAll(currentDirectoryState);
		currentDirectoryState.clear();
		for (String str : directory.list()) {
			currentDirectoryState.add(str);
		}
	}

	private void checkIfChanged() {
		if (currentDirectoryState.size() != lastDirectoryState.size()){
			this.message = "Directory was changed";
		}else{
			this.message = (currentDirectoryState.containsAll(lastDirectoryState)) 
				? "Directory was not changed"
				: "Directory was changed";
		}
		System.out.println(this.message);
	}
}

// Поиск добавленных файлов в директории
// if (this.directoryState != null){
// if (this.lastDirectoryState == null){
// this.lastDirectoryState = new ArrayList<>();
// addToLastDirectoryState();
// }else{
// this.lastDirectoryState.clear();
// addToLastDirectoryState();
// for (String str : this.directoryState){
// if (!(this.lastDirectoryState.contains(str))){
// System.out.println(str + "was added to directory");
// }
// }
// }
// }else{
// directoryState = this.directory.list();
// System.out.println("Directory state:");
// printDirectoryFiles();
// }