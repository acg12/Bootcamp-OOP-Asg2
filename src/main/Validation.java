package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Validation {
	public static boolean validNumber(int num) {
		return (num >= 0 && num <= 100) ? true : false;
	}
	
	public static boolean validUsername(HashMap<Integer, String> map, String username) {
		if(username.length() < 5 || username.length() > 20) {
			System.out.println("Username length must be between 5 - 20 characters!");
			return false;
		} else if(map.containsValue(username)) {
			System.out.println("Username has already been taken!!");
			return false;
		} else {
			return true;
		}
	}
}
