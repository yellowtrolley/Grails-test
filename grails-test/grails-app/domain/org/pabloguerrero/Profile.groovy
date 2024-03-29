package org.pabloguerrero

class Profile {
	User user
	byte[] photo
	String fullName
	String bio
	String homepage
	String email
	String timezone
	String country
	String jabberAddress

	static constraints = {
		fullName blank: false
		bio nullable: true, maxSize: 1000
		homepage url: true, nullable: true
		email email: true, nullable: false
		photo nullable: true
		country nullable: true
		timezone nullable: true
		jabberAddress email: true, nullable: true
	}
	
	String toString() { return "Profile of $fullName (id: $id)" }
	
	/*
	 * Creates a read-only displayString property for the scaffolding
	 */
	String getDisplayString() { return fullName } 

}
