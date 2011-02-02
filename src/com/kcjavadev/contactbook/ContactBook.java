package com.kcjavadev.contactbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * ContactBook is the main entry into the app. This sets everything up and
 * communicates with the client to get input.
 * 
 * @author scott
 * 
 */
public class ContactBook {

	// List of Persons
	private List<Person> contacts;

	// Typically want to make constructors public unless you definitely don't
	// want others accessing.
	public ContactBook() {

		contacts = new ArrayList<Person>();
	}

	public void printContacts() {
		// this is the new way to do a for-loop. Java converts the Set to an
		// iterator and does the base work for you.
		for (Person person : contacts) {
			System.out.println(person.getName() + " : " + person.getAddress());
		}
	}

	/**
	 * Main (currently only) way into the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting application");

		// initialize a new class to work with
		ContactBook contactBook = new ContactBook();

       // populate a few contacts initially
		contactBook.populateInitialPersons();

		Scanner scanner = new Scanner(System.in);
		String response = "";
		// a do/while loop will work here.  It does the stuff first and then checks the condition
		do {
			System.out.print( "What would you like to do now?  [add/remove/help/print/quit] " );
			// the scanner is new to me but seems to work pretty darn well
		    response = scanner.nextLine();
		    if ( response.toLowerCase().equals( "help" ) ) {
				printHelpMessage();
			} else if ( response.toLowerCase().equals( "add" ) ) {
				// passing the contact book so the static method knows what object to perform the add on
				// pass the scanner so we don't have to create another one and worry about multiple open InputReaders
				addNewPerson( scanner, contactBook );
			} else if ( response.toLowerCase().equals( "remove" ) ) {
				// passing the contact book again so
				removePerson( scanner, contactBook );
			}
			else if ( response.toLowerCase().equals( "print" ) ) {
				// passing the contact book again so
				contactBook.printContacts();
			}
		} while ( !response.toLowerCase().equals( "quit" ) );
		
		System.out.println( "Thank you for using the coolest app on the planet.  Good Bye" );
		scanner.close();
	}

	/**
	 * Not always necessary to document private methods but good to do when it isn't blatantly obvious.
	 * This method does the initial setup of the contact book.
	 */
	private void populateInitialPersons() {
		System.out.println("Creating initial contact book");

		Person person = new Person();
		person.setName("Jo Schmoe");
		person.setCity("JoVille");
		person.setState("CA");
		person.setZipCode(11111);
		contacts.add(person);

		person = new Person();
		person.setName("Suzie Smiles");
		person.setCity("Happy Town");
		person.setState("TX");
		person.setZipCode(22222);
		contacts.add(person);

		person = new Person();
		person.setName("Brad Pitt");
		person.setCity("Angelinaville");
		person.setState("CA");
		person.setZipCode(33333);
		contacts.add(person);

		person = new Person();
		person.setName("Kermit");
		person.setCity("Sesame Street");
		person.setState("NY");
		person.setZipCode(44444);
		contacts.add(person);

		person = new Person();
		person.setName("Mickey Mouse");
		person.setCity("Orlando");
		person.setState("FL");
		person.setZipCode(55555);
		contacts.add(person);
	}
	
	
	private static void printHelpMessage() {
		System.out.println( "Yet to be finished.  Help goes here\n" );
	}
	
	private static void addNewPerson( Scanner scanner, ContactBook book ) {
		String response = "";
		Person person = new Person();
		
		// not sure on this.  not sure why ContactBook was passed.
		// I made my best guess on how to do this.  Please advise.
		
		System.out.print("Enter First and Last Name: ");
		response = scanner.nextLine();
		person.setName(response);
				
		System.out.print("Enter City: ");
		response = scanner.nextLine();
		person.setCity(response);
		
        System.out.print("Enter State: ");
        response = scanner.nextLine();
        person.setState(response);
        
        System.out.print("Enter Postal Code: ");
        response = scanner.nextLine();
        person.setZipCode(Integer.parseInt(response));
        
        book.contacts.add(person);
	}
	
	private static void removePerson( Scanner scanner, ContactBook book ) {
		String response = "";
		// not sure on this.  not sure why ContactBook was passed.
		// I made my best guess on how to do this.  Please advise.
		
		System.out.print("Enter Name of person to remove: ");
		response = scanner.nextLine();
	
		for (Person person : book.contacts) {
			if (person.getName().equals(response)) {
				book.contacts.remove(person);
				break;
			} 
		}
	}
	
	private static void saveBook(ContactBook book) {
		//TODO write method to save book to file
	}

	private static void loadBook(ContactBook book) {
		//TODO write method to load book from file
	}
}
