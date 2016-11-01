package by.htp6.emailfinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

public class SimilarEmailFinder {
	private static final SimilarEmailFinder instance = new SimilarEmailFinder();

	private SimilarEmailFinder() {
	}

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private BufferedReader bufferedReader;

	public static SimilarEmailFinder getInstance() {
		return instance;
	}
	
	// Чтение текста из файла в строку
	public String readFileToString() {
		if (this.bufferedReader == null) {
			try {
				bufferedReader = new BufferedReader(new FileReader(this.fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();// эта ошибка аомментировалась в предыдущем коде
			}
		}
		String text = "";
		String buffer;
		try {
			while ((buffer = bufferedReader.readLine()) != null) {
				text += buffer;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!("".equals(text))) {
			return text;
		}
		return null;
	}
	
	// Алгоритм подсчёта одинаковых имён электронной почты
	public int countSimilarEmails(List<String> stringList) {
		// Поиск выполняется только по отсортированным коллекциям
		Collections.sort(stringList);
		
		// Список не уникальных имён
		List<String> similarEmails = new ArrayList<>();
		int similarEmailsCount = 0;
		String buffer = null;
		for (String email : stringList) {
			if (buffer == null) {
				buffer = email;
				continue;
			}
			
			// Если ими почты повторяется
			if (buffer.equals(email)) {
				// Если имя уже содержится в списке не уникальных имен, наращиваем количество
				// совпадений на 1
				if (similarEmails.contains(email)) {
					similarEmailsCount++;
				} else {
					// Иначе наращиваем на 2 и добавляем имя в список не уникильных
					similarEmails.add(buffer);
					similarEmailsCount += 2;
				}
			} else {
				buffer = email;
			}
		}
		return similarEmailsCount;
	}

	// Альтернативный алгоритм подсчёта одинаковых имён электронной почты
	// в отличие от первого алгоритма, меняет исходный список имен.
	public int countSimilarEmails2(List<String> stringList) {
		List<String> uniqueEmails = new ArrayList<>();
		List<String> deletedList = new ArrayList<>();
		int initialSize = stringList.size();

		for (String email : stringList) {
			if (deletedList.contains(email)) {
				continue;
			} else {
				if (uniqueEmails.contains(email)) {
					uniqueEmails.remove(email);
					deletedList.add(email);
				} else {
					uniqueEmails.add(email);
				}
			}

		}
		stringList.retainAll(uniqueEmails);
		return initialSize - stringList.size();
	}

	public List<String> findPattern(Matcher matcher, int groupNumber) {
		List<String> emails = new ArrayList<>();

		while (matcher.find()) {
			emails.add(matcher.group(groupNumber));
		}
		return emails;
	}
}
