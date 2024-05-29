package week3.day2;

public abstract class CanaraBank implements Payments {
	
	public void recordPaymentDetails() {
		System.out.println("payment details - from canarabank class");

	}
	
	public void cardPayments() {
		System.out.println("card Payments - from payments interface");
		
	}
	
	public void internetBanking() {
		System.out.println("internet Banking - from payments interface");
	}

}
