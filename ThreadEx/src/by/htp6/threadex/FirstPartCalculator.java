package by.htp6.threadex;

public class FirstPartCalculator extends Thread{
	private double calculationResult;
	
	private int x;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getCalculationResult() {
		return calculationResult;
	}

	public FirstPartCalculator() {
		this.calculationResult = 0;
	}
	
	@Override
	public void run() {
		this.calculationResult = Math.pow(this.x,3) + 2 * this.x;
	}
}
