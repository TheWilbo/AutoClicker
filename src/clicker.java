import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Clicker {
	public static boolean clicking = true;
	public static int amountClicked = 0;
	public static int rate = 0;
	public static int rate1 = 0;

	public static void main(String[] args) throws InterruptedException, IOException {
		
		while (rate1 == 0) {
			try {
				System.out.println("How many clicks are you wanting to do?:");
				BufferedReader xyz = new BufferedReader(new InputStreamReader(System.in));
				try {
					rate1 = Integer.parseInt(xyz.readLine());
					if (rate1 == 0) {
						rate1 = 0;
						System.out.println("Must be at least 1 click.");
					}
				} catch (NumberFormatException ex) {
					System.out.println("Error - please try again.");
				}
			} catch (IOException e) {
			}
		}
		
		
		
		System.out.println("Max speed of the autoclicker?: (in milliseconds):");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			rate = Integer.parseInt(in.readLine());
		} catch (NumberFormatException ex) {
			System.out.println("Error - please try again.");
		}
		
		
		
		try {
			System.out.println("*!*!*!*! PLEASE MOVE YOUR MOUSE INTO POSITION! !*!*!*!*");
			System.out.println("*!*!*!*! MOVE MOUSE TO END AUTOCLICK! !*!*!*!*");
			System.out.println("*!*!*!*! Sleeping for 5 seconds !*!*!*!*");
			
			Thread.sleep(5000);
			
			Point p = MouseInfo.getPointerInfo().getLocation();
			System.out.println("Current Mouse Location: "+p);
			
			Robot robot = new Robot();
			while (clicking == true) {
				try {
					Point z = MouseInfo.getPointerInfo().getLocation();
					System.out.println("Current Mouse Location: "+z);
					
					//int randomNum = ThreadLocalRandom.current().nextInt(15000, rate + 1);
					//System.out.println("Current Rate: " + randomNum);
					Thread.sleep(rate);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					amountClicked++;
					System.out.println("Amount Clicked So Far: " + amountClicked);
					
					if (Math.round(z.getX()+z.getY()) != Math.round(p.getX()+p.getY())) {
						System.out.println("MOUSE MOVED!: "+z);
						clicking = false;
					}
					
					if (amountClicked == rate1) {
						clicking = false;
					}
				} catch (InterruptedException ex) {
				}
			}
		} catch (AWTException e) {
		}
		
	}

}
