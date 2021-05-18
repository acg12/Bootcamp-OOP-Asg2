package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Participant> list = new ArrayList<>();
	HashMap<Integer, String> map = new HashMap<>();

	public Main() {
		// TODO Auto-generated constructor stub
		int menu = 0;
		do {
			System.out.println("+=======================+");
			System.out.println("+ Options               +");
			System.out.println("+=======================+");
			System.out.println("+ 1. Start Sharing      +");
			System.out.println("+ 2. Update Participant +");
			System.out.println("+ 3. Delete Participant +");
			System.out.println("+ 4. Close App          +");
			System.out.println("+=======================+");
			
			do {
				System.out.print("Choice >> ");
				try {
					menu = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Input must be numeric");
					scan.nextLine();
					menu = 0;
				}
			} while(menu < 1 || menu > 4);
			
			switch(menu) {
			case 1:
				Menu.start(map, list);
				Util.pressEnter();
				break;
			case 2:
				Menu.update(list);
				Util.pressEnter();
				break;
			case 3:
				Menu.delete(map, list);
				Util.pressEnter();
				break;
			}
		} while(menu != 4);
		
		System.out.println("Here's the completed share list");
		System.out.println("Remember, sharing is caring, happy sharing :D");
		Menu.viewSort(list);
		
		scan.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
