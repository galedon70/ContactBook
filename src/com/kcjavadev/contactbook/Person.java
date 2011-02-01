package com.kcjavadev.contactbook;

import java.util.Date;

/**
 * This is a POJO (Plain Ol Java Object) that does nothing more than hold information.
 * You can put some basic stuff in methods but it should do little more than just give you 
 * the data it has stored.  Some things you can do (for example) are like utility methods.  An
 * example would be if you have a birthday field and one of the things you need often is to check
 * whether or not the person has a birthday in the next thirty days you can put in a method that will
 * return true if the birthday is coming in less than one month ( hasBirthdaySoon() )
 * 
 * @author Scott
 *
 */
public class Person {
	
	// this is used somewhat commonly so it is easier to ensure what values we have
	// There can only ever be two kinds of Gender and maybe Unknown or Not Specified
	// You can put this here or have an entire class for Gender enum.
	public enum Gender {
		Female, Male
	}

	private String name;
	private Date birthday;
	private Gender gender;
	
	// just like database design the following fields can go into a new class called Address
	private String city;
	private String state;
	private Integer zipCode;
	private Integer zipCode4;
	
	// I just let eclipse generate all the getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getZipCode4() {
		return zipCode4;
	}
	public void setZipCode4(Integer zipCode4) {
		this.zipCode4 = zipCode4;
	}
	
	// this is an example of a utility method that will help you 
//	public String getAddress() {
//		return getCity() + ", " + getState() + " " + getZipCode();
//	}
	
	// a better way to build strings!
	// This is a better way to do string concatenation
	public String getAddress() {
		StringBuilder builder = new StringBuilder();
		builder.append( getCity() );
		builder.append( ", " ).append( getState() );
		builder.append( " " ).append( getZipCode() );
		if ( getZipCode4() != null ) {
			builder.append( "-" ).append( getZipCode4() );
		}
		return builder.toString();
	}
	
}
