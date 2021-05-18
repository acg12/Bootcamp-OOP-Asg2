package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	public static void start(HashMap<Integer, String> map, ArrayList<Participant> list) {
		Scanner scan = new Scanner(System.in);
		
		int share;
		String username;
		
		do {
			System.out.print("Input a number [0 - 100]: ");
			try {
				share = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input must be numeric");
				scan.nextLine();
				share = -1;
			}
		} while(!Validation.validNumber(share));
		
		do {
			System.out.print("Could you give me your username [5 - 20 characters]? ");
			username = scan.nextLine();
		} while(!Validation.validUsername(map, username));
		
		list.add(new Participant(username, share));
		map.put(map.size() + 1, username);
		
		System.out.println("You are the " + map.size() + " that joins the game");
		System.out.println("Your share number: " + share);
	}
	
	public static void update(ArrayList<Participant> list) {
		if(list.isEmpty()) {
			return;
		}
		
		Scanner scan = new Scanner(System.in);
	
		int choice = -1;
		
		do {
			view(list);
			System.out.print("Which participant you would like to update [1 - " + list.size() + "][0 to exit]? ");
			try {
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input must be numeric");
				scan.nextLine();
				choice = -1;
			}
		} while(choice < 0 || choice > list.size());
		
		if(choice > 0) {
			int share;
			do {
				System.out.print("Input a number [0 - 100]: ");
				try {
					share = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Input must be numeric");
					scan.nextLine();
					share = -1;
				}
			} while(!Validation.validNumber(share));
			
			Participant p = list.get(choice - 1);
			p.setShare(share);
			
			System.out.println("Update Successful!");
		}
	}
	
	public static void delete(HashMap<Integer, String> map, ArrayList<Participant> list) {
		if(list.isEmpty()) {
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		
		int choice = -1;
		
		do {
			view(list); 
			System.out.print("Which participant you would like to delete [1 - " + list.size() + "][0 to exit]? ");
			try {
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input must be numeric");
				scan.nextLine();
				choice = -1;
			}
		} while(choice < 0 || choice > list.size());
		
		if(choice > 0) {
			list.remove(choice - 1);
			map.remove(choice);
			
			System.out.println("Participant succesfully removed from event");
		}
	}
	
	public static void view(ArrayList<Participant> list) {
		System.out.println("+============================================+");
		System.out.println("+ Share list                                 +");
		System.out.println("+============================================+");
		
		for (Participant p : list) {
			System.out.printf("| %-4d| %-25s| %-10d|\n", list.indexOf(p) + 1, p.username, p.share);
		}
		
		System.out.println("+============================================+");
	}
	
	public static void viewSort(ArrayList<Participant> list) {
		if(list.isEmpty()) {
			return;
		}
		
		Collections.sort(list, null);		
		
		ArrayList<Integer> shares = new ArrayList<Integer>();
		for (Participant p : list) {
			shares.add(p.share);
		}
		
		Collections.shuffle(shares);
		Collections.reverse(shares);
		
		System.out.println("+==============================================+");
		System.out.println("+ Share list                                   +");
		System.out.println("+==============================================+");
		System.out.println("+ Username                 | Before  | After   +");
		System.out.println("+==============================================+");
		
		for (Participant p : list) {
			int index = list.indexOf(p);
			System.out.printf("| %-25s| %-8d| %-8d|\n", p.username, p.share, shares.get(index));
		}
		
		System.out.println("+==============================================+");
	}
}
