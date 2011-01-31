package com.kcjavadev.contactbook;

import java.util.HashMap;

public class ContactBook	{
	
	String name, address;
	
	ContactBook(){
		name = "";
		address = "";
	}
	
	private HashMap<String,String> contacts = new HashMap<String,String>();
	
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
