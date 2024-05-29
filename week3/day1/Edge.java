package week3.day1;

import org.openqa.selenium.devtools.v115.page.model.Frame;

public class Edge extends Browser{
	
	public void readerMode() {
		System.out.println("reader mode - from edge");
	}
	
	public void fullScreenMode() {
		System.out.println("full Screen Mode - from edge");
	}
	public static void main(String[] args) {
		Edge obj = new Edge();
		System.out.println(obj.browserName);
		System.out.println(obj.browserVersion);
		obj.closeBrowser();
		obj.navigateBack();
		obj.openURL();
		obj.readerMode();
		obj.fullScreenMode();
		
	}
}
