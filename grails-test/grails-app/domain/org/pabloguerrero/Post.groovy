package org.pabloguerrero

class Post {
	String content
	Date dateCreated

	/*
	 * one-to-many (1:m) relationship.
	 * hasMany (on the “one” side of the relationship)
	 * and belongsTo (on the “many” side of the relationship).
	 */
	static belongsTo = [ user : User ]

	/*
	 * Many-to-many (m:n) relationship.
	 * The [tags : Tag ] map tells us that a Post relates to many Tag objects, 
	 * and that the relationship is stored in an attribute named tags.
	 */
	static hasMany = [ tags : Tag ]

	static constraints = {
		content blank: false
	}

	static mapping = {
		sort dateCreated: "desc"
	}
	
	/*
	 * Creates a read-only displayString property for the scaffolding
	 */
	String getDisplayString() { return content }
}
