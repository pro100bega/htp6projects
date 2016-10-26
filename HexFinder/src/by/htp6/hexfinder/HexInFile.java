package by.htp6.hexfinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class HexInFile {

	private static final HexInFile instance = new HexInFile();
	
	private BufferedReader bufferedReader;
	
	private String fileName;
	
	private HexInFile() {
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static HexInFile getInstance() {
		return instance;
	}
	
	// Чтение всего файла в строку
	public String readFileToString(){
		
		// При первом чтение инициализация bufferedReadeк
		if (this.bufferedReader == null){
			try {
				bufferedReader = new BufferedReader(new FileReader(this.fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
		String text = "";
		String buffer;
		try {
			while((buffer = bufferedReader.readLine()) != null){
				text += buffer;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (!("".equals(text))){
			return text;
		}
		return null;
	}
	
	// Возвращает коллекцию строк по заданному регулярному выражению
	public List<String> findPattern(Matcher matcher){
		List<String> stringList = new ArrayList<>();
		
		while(matcher.find()){
			stringList.add(matcher.group());
		}
		if (stringList.size() != 0){
			return stringList;
		}
		return null;
	}
}
