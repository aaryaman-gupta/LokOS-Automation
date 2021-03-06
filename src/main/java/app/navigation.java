package app;

import io.appium.java_client.MobileBy;
import lokos.lokosTest;
import util.MobileTouch;

public class navigation extends lokosTest {

	public static void shgButton() throws InterruptedException {
		Thread.sleep(2000);
		appdriver.findElementById("com.microware.cdfi:id/tbl_shg").click();
		Thread.sleep(3000);
	}

	public static void navToVillage(int row) throws InterruptedException {
		xc.changeSheet("SHGs");
		appdriver.findElementById("com.microware.cdfi:id/spin_panchayat").click();
		Thread.sleep(1500);
		appdriver.findElement(MobileBy
				.AndroidUIAutomator("new UiSelector().text(\"" + xc.getCellString(row, profileCons.gpColNum) + "\")"))
				.click();
		appdriver.findElementById("com.microware.cdfi:id/spin_village").click();
		Thread.sleep(1500);
		appdriver.findElement(MobileBy.AndroidUIAutomator(
				"new UiSelector().text(\"" + xc.getCellString(row, profileCons.villageColNum) + "\")")).click();
		
	}

	public static void existingSHG(int row) throws Exception {
		String shgName=xc.getCellString(row, profileCons.shgNameColNum).toUpperCase();
		System.out.println("Navigating to "+shgName);
		mt.scrollToText(shgName, "top");

	}

	public static void newSHG() {
		appdriver.findElementById("com.microware.cdfi:id/IvAdd").click();
	}

	public static void openSHGProfile(int row) {
		boolean flag = false;
		int i = 1;
		
		
//		
		while (!flag) {
			String s = appdriver.findElement(MobileBy
					.AndroidUIAutomator("new UiSelector().resourceId(\"com.microware.cdfi:id/tv_nam\").index("+(i-1)+")")).getText();
			if (s.equalsIgnoreCase(xc.getCellString(row, profileCons.shgNameColNum))) {
				flag = true;
				appdriver.findElementByXPath(
						"//android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.ImageView"
						)
						.click();
				appdriver.findElementById("com.microware.cdfi:id/tvShg").click();

			}
			i++;
		}

	}
	
	public static void openSHGMeetings(int row) {
		boolean flag = false;
		int i = 1;	
//		
		while (!flag) {
			String s = appdriver.findElementByXPath("//android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]").getText();
			if (s.equalsIgnoreCase(xc.getCellString(row, profileCons.shgNameColNum))) {
				flag = true;
				appdriver.findElementByXPath(
						"//android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.ImageView"
						)
						.click();				
			}
			i++;
		}

		
		
	}

	public static void openSHGMembers(int row) {
		boolean flag = false;
		int i = 1;
		while (!flag) {
			String s = appdriver.findElementByXPath("//android.widget.LinearLayout[" + i
					+ "]/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView")
					.getText();
			if (s.equalsIgnoreCase(xc.getCellString(row, profileCons.shgNameColNum))) {
				flag = true;
				appdriver
						.findElementByXPath("//android.widget.LinearLayout[" + i
								+ "]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
						.click();

			}
			i++;

		}
	}

	public static void newMember() {
		appdriver.findElementById("com.microware.cdfi:id/tbl_add").click();
	}

	public static void existingMember(int row) {
		xc.changeSheet("Members");
		MobileTouch mt = new MobileTouch(appdriver);
		mt.scrollToText(xc.getCellString(row, memCons.nameColNum), "top");
		String name=xc.getCellString(row, memCons.nameColNum) ;
		appdriver.findElement(MobileBy
				.AndroidUIAutomator("new UiSelector().text(\"" + name+ "\")"))
				.click();

	}

}
