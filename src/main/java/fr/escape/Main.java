package fr.escape;

import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static String tab() {
		
		String str = "1234";
		int taille = str.length();
		String c;
		int[] arr = new int[taille];
		for (int i = 0; i < taille; i++) {
			c = str.substring(i, i + 1);
			arr[i] = Integer.parseInt(c);
		}
	
	 return Arrays.toString(arr);
	}
	
	public static void main(String[] args) {
		
		System.out.println(tab());
		
	}
	 
}

