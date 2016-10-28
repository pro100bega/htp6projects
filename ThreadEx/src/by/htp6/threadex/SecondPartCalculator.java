package by.htp6.threadex;

public class SecondPartCalculator extends Thread{
	
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

	public SecondPartCalculator() {
		this.calculationResult = 0;
	}
	
	@Override
	public void run() {
		this.calculationResult = (Math.pow(this.x,2) + 2 * this.x - Math.pow(2,this.x))/3;
	}
	
}
