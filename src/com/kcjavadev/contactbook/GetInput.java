package com.kcjavadev.contactbook;

import java.util.Scanner;

public class GetInput {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		System.out.println ("Main Menu");
		System.out.println("1: Add Contact");
		System.out.println("2: Delete Contact");
        System.out.println("3: Display Contacts");
        System.out.println("0: Quit");
        
        Scanner menuopt=new Scanner(System.in);
        int choice = menuopt.nextInt();
        
        System.out.println();
        System.out.println("Your choice was: " + choice);
	}

}
