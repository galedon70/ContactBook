package com.kcjavadev.contactbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Typically good to document your classes to explain what they are for.
 * 
 * ContactBook is the main entry into the app.  This sets everything up and communicates
 * with the client to get input.
 * 
 * @author scott
 *
 */
public class ContactBook	{
	
	// NOTE : what is the purpose of having these?
	String name, address;
	
	private HashMap<String,String> contacts = new HashMap<String,String>();
	
	// TODO : you can move to adding Person objects instead of using the HashMap
	private List<Person> persons;

	// Typically want to make constructors public unless you definitely don't want others accessing.
	ContactBook(){
		name = "";
		address = "";
		// you can initialize parameters in the constructor or when you define them
		persons = new ArrayList<Person>();
	}
	
	
    public void addContact(String a, String n){
    	name = n;
    	address = a;
    	contacts.put(name, address);
    }

    public void printContacts( ) {
        // this is the new way to do a for-loop.  Java converts the Set to an iterator and does the base work for you.
        for ( String name : contacts.keySet() ) {
            // a map is just a key/value pair.  The name is the key so contacts.get( name ) gets the associated city
            System.out.println( name + " : " + contacts.get( name ) );
        }
    }

    /**
     * Main (currently only) way into the application.  
     * @param args
     */
	public static void main( String[] args ) {
        System.out.println( "Staring application" );
        
        // initialize a new class to work with
        ContactBook cb = new ContactBook();
        
        System.out.println( "Creating initial contact book" );
        cb.addContact("Test Name1","Test Address1");
        cb.addContact("Test Name2", "Test Address2");
        
        // now print the entries
        cb.printContacts( );
    	}
    
   
}
