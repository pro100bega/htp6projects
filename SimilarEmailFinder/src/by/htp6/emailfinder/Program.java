package by.htp6.emailfinder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
	public static void main(String[] args) {
		String fileName = "resources/E-mails.txt";
		String regex = "([^@\\s]+)@([^@\\s]+)\\.(com|ru|by)";

		SimilarEmailFinder finder = SimilarEmailFinder.getInstance();
		finder.setFileName(fileName);

		String text = finder.readFileToString();
		if (null != text) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(finder.readFileToString());
			List<String> emails = finder.findPattern(matcher, 1);

			int similarEmailCount = finder.countSimilarEmails2(emails);

			if (similarEmailCount != 0) {
				System.out.println("E-mails has " + similarEmailCount + " similar names");
			} else {
				System.err.println("Similar e-mail names was not found");
			}
		}else {
			System.err.println("File is empty");
		}

	}
}
