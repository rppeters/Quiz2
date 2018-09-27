package pkgTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pkgFinance.Car;

class CarTest {

	@Test 
	public void calculateMonthlyPayment_Test() throws Exception {
		
		float carCost = 35000;
		float downPayment = 0;
		int loanLength = 60;
		float interestRate = (float)0.1;
		
		Car car1 = new Car(carCost, downPayment, loanLength, interestRate);
		float monthlyPayment = car1.calculateMonthlyPayment();
		float expectedPayment = (float)743.65;
		assertEquals(monthlyPayment, expectedPayment);
		
		//Other expectedPayments coming from: https://www.ifsautoloans.com/car-loan-interest/
		downPayment = 5000;
		Car car2 = new Car(carCost, downPayment, loanLength, interestRate);
		monthlyPayment = car2.calculateMonthlyPayment();
		expectedPayment = (float)637.41;
		assertEquals(monthlyPayment, expectedPayment);
		
		loanLength = 72;
		Car car3 = new Car(carCost, downPayment, loanLength, interestRate);
		monthlyPayment = car3.calculateMonthlyPayment();
		expectedPayment = (float)555.78;
		assertEquals(monthlyPayment, expectedPayment);
		
		interestRate = (float)0.05;
		Car car4 = new Car(carCost, downPayment, loanLength, interestRate);
		monthlyPayment = car4.calculateMonthlyPayment();
		expectedPayment = (float)483.14;
		assertEquals(monthlyPayment, expectedPayment);
	}
	
	@Test
	public void calculateTotalInterest_Test() throws Exception {
		
		float carCost = 35000;
		float downPayment = 0;
		int loanLength = 60;
		float interestRate = (float)0.1;
		
		Car car1 = new Car(carCost, downPayment, loanLength, interestRate);
		float totalInterest = car1.calculateTotalInterest();
		float expectedInterest = (float)9619.0; //should be $9,618.79
		assertEquals(totalInterest, expectedInterest);
		
		//expectedInterests coming from: https://investinganswers.com/calculators/loan/loan-interest-calculator-how-much-interest-will-i-pay-my-lender-3191
		downPayment = 10000;
		Car car2 = new Car(carCost, downPayment, loanLength, interestRate);
		totalInterest = car2.calculateTotalInterest();
		expectedInterest = (float)6870.8; //website said $6,870.57
		assertEquals(totalInterest, expectedInterest);
		
		loanLength = 72;
		Car car3 = new Car(carCost, downPayment, loanLength, interestRate);
		totalInterest = car3.calculateTotalInterest();
		expectedInterest = (float)8346.8; //website said $8,346.51	
		assertEquals(totalInterest, expectedInterest);
		
		interestRate = (float)0.05;
		Car car4 = new Car(carCost, downPayment, loanLength, interestRate);
		totalInterest = car4.calculateTotalInterest();
		expectedInterest = (float)3988.64; //website said $3,988.88
		assertEquals(totalInterest, expectedInterest);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
