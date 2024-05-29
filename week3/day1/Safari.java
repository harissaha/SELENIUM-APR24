package week3.day1;

public class Safari extends Browser {

	public void takeSnap() {

		System.out.println("Take Snap - From Safari");

	}

	public void clearCookies() {

		System.out.println("clear Cookies  - From Safari");

	}
	public static void main(String[] args) {
		Safari sf = new Safari();
		System.out.println(sf.browserName);
		System.out.println(sf.browserVersion);
		sf.closeBrowser();
		sf.navigateBack();
		sf.openURL();
		sf.takeSnap();
		sf.clearCookies();
	}
}
