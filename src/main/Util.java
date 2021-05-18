package main;

import java.util.Scanner;

public class Util {
	public static void pressEnter() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Press enter to continue...");
		scan.nextLine();
	}
}
