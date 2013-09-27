package org.pabloguerrero

class Tag {
	String name
	User user

	static hasMany = [ posts : Post ]
	
	/*
	 * The belongsTo field controls where the dynamic addTo*() methods can be used from.
	 */
	static belongsTo = [ User, Post ]

	static constraints = {
		name blank: false
	}
	
	/*
	 * Creates a read-only displayString property for the scaffolding
	 */
	String getDisplayString() { return name }
}
