package by.htp6.hexfinder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
	public static void main(String[] args) {
		String fileName = "resources/Text.txt";
		String regex = "0x[\\da-fA-F]{1,16}";

		HexInFile hexInFile = HexInFile.getInstance();
		hexInFile.setFileName(fileName);
		
		// Текст, содержащийся в файле
		String text = hexInFile.readFileToString();
		
		if (null != text) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(text);
			List<String> stringList = hexInFile.findPattern(matcher);

			if (stringList != null) {
				System.out.println("Hex was found:");
				for (String str : stringList) {
					System.out.println(str);
				}
			} else {
				System.out.println("Hex was not found in source file");
			}
		} else {
			System.out.println("File is empty");
		}
	}
}
