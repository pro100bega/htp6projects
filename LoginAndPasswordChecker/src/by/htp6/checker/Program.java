package by.htp6.checker;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		String login;
		String password;
		String loginRegex = "^[\\w]{3,16}$";
		String passwordRegex = "^[\\w]{6,18}$";

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter login:");
		login = LineReader.readLine(scan);

		System.out.println("Enter password:");
		password = LineReader.readLine(scan);
		
		Checker checker = new Checker(loginRegex, login);
		checker.printCheckResult("Login", login, checker.checkPatternInText());
		
		checker.resetPattern(passwordRegex);
		checker.resetText(password);
		checker.printCheckResult("Password", password, checker.checkPatternInText());
		
	}
	
	// Вспомогательный класс для чтения с клавиатуры
	static class LineReader{
		public static String readLine(Scanner scan){
			if (scan.hasNextLine()){
				return scan.nextLine();
			}else {
				return null;
			}
		}
	}
}
