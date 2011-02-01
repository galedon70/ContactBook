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
			// Get address doesn't exist. You can create a method in person that
			// will print City, STATE ZipCode in a nice string format
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

		// by separating function into method it helps keep things clean. That's
		// why i moved this to its own function
		contactBook.populateInitialPersons();

		// now print the entries
		contactBook.printContacts();
		
		Scanner scanner = new Scanner(System.in);
		String response = "";
		// a do/while loop will work here.  It does the stuff first and then checks the condition
		do {
			System.out.print( "What would you like to do now?  [add/remove/help/quit] " );
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
		    
		} while ( !response.toLowerCase().equals( "quit" ) );
		
		System.out.println( "Thank youf or using the coolest app on the planet.  Good Bye" );
		scanner.close();
	}

	/**
	 * Not always necessary to document private methods but good to do when it isn't blatantly obvious.
	 * This method does the initial setup of the contact book.
	 */
	private void populateInitialPersons() {
		System.out.println("Creating initial contact book");

		// this needs changed to Person person = new Person();
		Person person = new Person();
		person.setName("Jo Blow");
		person.setCity("JoVille");
		// lower case set so this becomes person.setState("CA");
		person.setState("CA");

		// not super important now to have a separate method since it was only a
		// one liner anyway (unless it does some kind of error checking)
		// contactBook.addContact(person);
		contacts.add(person);

		person = new Person();
		person.setName("Suzie Smiles");
		person.setCity("Happy Town");
		person.setState("TX");

		contacts.add(person);

		person = new Person();
		person.setName("Brad Pitt");
		person.setCity("Angelinaville");
		person.setState("CA");

		contacts.add(person);

		person = new Person();
		person.setName("Kermit");
		person.setCity("Sesame Street");
		person.setState("NY");
		contacts.add(person);

		person = new Person();
		person.setName("Mickey Mouse");
		person.setCity("Orlando");
		person.setState("FL");

		contacts.add(person);
	}
	
	
	private static void printHelpMessage() {
		System.out.println( "Yet to be finished.  Help goes here\n" );
	}
	
	private static void addNewPerson( Scanner scanner, ContactBook book ) {
		// todo : add prompts to add a new person.  Asking for name, address, etc
	}
	
	private static void removePerson( Scanner scanner, ContactBook book ) {
		// todo : add prompts and remove person from book
	}

}
