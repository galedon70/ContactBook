package com.kcjavadev.contactbook;

import java.util.HashMap;

public class ContactBook {
    
	private HashMap<String,String> contacts = new HashMap<String,String>();
    
    /**
     * There are several ways to get data into your map.  This puts them in one by one.  hardcoded.
     */
    public void createInitialBook1( ) {
        contacts.put( "Bob Jones", "Charlotte, NC" );
        contacts.put( "Andrea Chavez", "Seattle, WA" );
    }
    
    /**
     * Here the names and cities are in arrays.  The cities must match the order of the names
     */
    public void createInitialBook2( ) {
        String[] names = new String[] { "Bob Jones", "Andrea Chavez" };
        String[] cities = new String[] { "Charlotte, NC", "Seattle, WA" };
        
        // iterating over the array to put the names and cities into the map
        for ( int x = 0; x < names.length; x++ ) {
            contacts.put( names[x], cities[x] );
        }
        
       
    }
    
    public void printContactList( ) {
        // this is the new way to do a for-loop.  Java converts the Set to an iterator and does the base work for you.
        for ( String name : contacts.keySet() ) {
            // a map is just a key/value pair.  The name is the key so contacts.get( name ) gets the associated city
            System.out.println( name + " : " + contacts.get( name ) );
        }
    }

}
