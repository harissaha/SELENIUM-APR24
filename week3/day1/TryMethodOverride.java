package week3.day1;

public class TryMethodOverride extends TryMethodOverload {
	
	@Override
	public void reportStep(String msg, String status) {
		// TODO Auto-generated method stub
		System.out.println("Override is done"+" "+ status + " " + msg);
	}
	
	public static void main(String[] args) {
		TryMethodOverride obj = new TryMethodOverride();
		obj.reportStep("Message is pending", "PEND");
	}

}
