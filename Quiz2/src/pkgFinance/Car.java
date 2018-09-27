package pkgFinance;

import java.math.BigDecimal;

public class Car {
	
	private float carCost;
	private float downPayment;
	private int loanLength;
	private float interestRate;

	public Car(float carCost, float downPayment, int loanLength, float interestRate) throws Exception {
		//Handle exceptions (not sure if needed but why not)
		if (carCost < 0) {
			throw new Exception("Invalid carCost");
		} else {
			this.carCost = carCost;
		}
		
		if (downPayment < 0) {
			throw new Exception("Invalid downPayment");
		} else {
			this.downPayment = downPayment;
		}
		
		if (loanLength < 0) {
			throw new Exception("Invalid loanLength");
		} else {
			this.loanLength = loanLength;
		}
		
		if (interestRate < 0) {
			throw new Exception("Invalid interestRate");
		} else {
			this.interestRate = interestRate;
		}
	}
	
	public float calculateMonthlyPayment() {
		float principal = carCost - downPayment;
		float equationDividend = ((interestRate / 12) * principal); 
		float equationDivisor = (float)(1 - Math.pow((1 + (interestRate / 12)), (-1) * loanLength));
		float monthlyPayment = equationDividend / equationDivisor;
		
		BigDecimal bd = new BigDecimal(Float.toString(monthlyPayment));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
	}
	
	public float calculateTotalInterest() {
		float principal = carCost - downPayment;
		float totalPayment = calculateMonthlyPayment() * loanLength;
		float totalInterest = totalPayment - principal;
		
		BigDecimal bd = new BigDecimal(Float.toString(totalInterest));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
	}
	
}
