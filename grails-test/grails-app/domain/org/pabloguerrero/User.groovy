package org.pabloguerrero

class User {
	String loginId
	String password
	/*
	 * Grails provides special support for date fields named dateCreated and lastUpdated. 
	 * If you have fields with such names, Grails will automatically set the current 
	 * timestamp value on first save to dateCreated or on every save to lastUpdated.
	 */
	Date dateCreated
	Date lastUpdated
	
	/*
	 * 1:1 relationship
	 */
	static hasOne = [ profile : Profile ]
	
	/*
	 * one-to-many (1:m) relationship.
	 * hasMany (on the “one” side of the relationship)
	 * and belongsTo (on the “many” side of the relationship).
	 * 
	 * following is a self-referencing relationship, a specialized 
	 * version of the one-to-many relationship
	 */
	static hasMany = [ posts : Post, tags : Tag, following : User ] 


	
	static constraints = {
		loginId size: 3..20, unique: true, blank: false
		password size: 6..8, validator: { passwd, user ->
			passwd != user.loginId
		}
		
	/*
	 * he scaffolding will display the fields in the order that they are 
	 * declared in the constraints block
	 */
		tags()
		posts()
		
		/*
		 * If you don’t specify this, Grails will force you to create a Profile 
		 * instance every time you create a User object
		 */
		profile nullable: true 
	}
	
	static mapping = {
		profile lazy: false
	}
	
	String getDisplayString() { return loginId }
}