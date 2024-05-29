package week3.day1;

public class TryMethodOverload {
	public void reportStep(String msg, String status) {
		System.out.println("Output is: " + msg + " " + status);

	}
	
	public void reportStep(String msg, String status, boolean snap) {
		System.out.println("Output is: " + msg + " " + status+" "+ snap);

	}
	public static void main(String[] args) {
		TryMethodOverload obj = new TryMethodOverload();
		obj.reportStep("Message Received", "Approved");
		obj.reportStep("Message Received", "Approved", true);
	}
}

