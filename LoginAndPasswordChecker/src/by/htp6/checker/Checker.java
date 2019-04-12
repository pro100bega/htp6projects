package by.htp6.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {	
	private Pattern pattern;
	private Matcher matcher;
	
	public Checker(String regexp, String text){
		this.pattern = Pattern.compile(regexp);
		this.matcher = this.pattern.matcher(text);
	}
	
	//Проверяет наличие паттерна в тексте. Возвращает true при наличие паттерна 
		public boolean checkPatternInText(){
			if (!this.matcher.find()){
				return false;
			}
			return true;
		}
		
	// не надо в одном классе смешивать логику работу и вывод данных куда-либо
	// логика должны возвращать значения, которые можно куда-нибудь вывести
		//Печатает на экран сообщение о корректности и некоректности данных
		public void printCheckResult(String fieldName, String field, boolean checkState){
			if (!checkState){
				System.err.println(fieldName + " \"" + field + "\" is incorrect ");
			} else {
				System.out.println(fieldName + " \"" + field + "\" is correct");
			}
		}
		
		//Задает новый паттерн
		public void resetPattern(String pattern){
			this.pattern = Pattern.compile(pattern);
		}
		
		//Задает новый текст
		public void resetText(String text){
			this.matcher = this.pattern.matcher(text);
		}
	
}
