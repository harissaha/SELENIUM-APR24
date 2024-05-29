package week3.day2;

public class Amazon extends CanaraBank implements Payments {

	public void cashOnDelivery() {
		System.out.println("cashOnDelivery - from payments interface");

	}

	public void upiPayments() {
		System.out.println("upi Payments - from payments interface");

	}

	public static void main(String[] args) {
		Amazon obj = new Amazon();
		obj.cardPayments();
		obj.internetBanking();
		obj.recordPaymentDetails();
		obj.cashOnDelivery();
		obj.upiPayments();
	}
}
