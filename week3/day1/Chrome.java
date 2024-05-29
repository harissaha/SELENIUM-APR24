package week3.day1;

public class Chrome extends Browser{
	
	public void openIncognito() {
		System.out.println("open Incognito - From Chrome");

	}
	
	public void clearCache() {
		System.out.println("clearCache - From Chrome");

	}
	
	public static void main(String[] args) {
		Chrome ch = new Chrome();
		System.out.println(ch.browserName);
		System.out.println(ch.browserVersion);
		ch.closeBrowser();
		ch.navigateBack();
		ch.openURL();
		ch.openIncognito();
		ch.clearCache();
	}

}
