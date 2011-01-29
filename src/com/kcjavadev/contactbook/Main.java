package com.kcjavadev.contactbook;

public class Main {

    
    /**
     * @param args
     */
    public static void main( String[] args ) {
        System.out.println( "Staring application" );
        
        // initialize a new class to work with
        ContactBook mainApp = new ContactBook();
        
        System.out.println( "Creating initial address book" );
        mainApp.createInitialBook1();
        // mainApp.createInitialBook2();
        
        // now print the entries
        mainApp.printContactList( );
    }
    
   
}
