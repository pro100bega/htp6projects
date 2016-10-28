package by.htp6.threadex;

import java.util.Scanner;

public class Program {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int x;
		
		System.out.println("Enter the x:");
		x = scan.nextInt();
		
		FirstPartCalculator firstPartCalculator = new FirstPartCalculator();
		SecondPartCalculator secondPartCalculator = new SecondPartCalculator();
		
		firstPartCalculator.setX(x);
		secondPartCalculator.setX(x);
		
		firstPartCalculator.start();
		secondPartCalculator.start();
		
		
		
		try {
			firstPartCalculator.join();
			secondPartCalculator.join();
			
			double firstPartResult = firstPartCalculator.getCalculationResult();
			double secondPartResult = secondPartCalculator.getCalculationResult();
			
			System.out.printf("Result = %.2f" , firstPartResult / secondPartResult);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}
}
