package com.stagee.proj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
   @Id
   private int id;
   private String nom;
   private String prenom;
   private String pseudo;
   private String password;
   private String role;
   
public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public int getId() {
	return id;
}

public User() {
	
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getPseudo() {
	return pseudo;
}

public User(int id, String nom, String prenom, String pseudo, String password) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.pseudo = pseudo;
	this.password = password;
}

public User(int id, String nom, String prenom, String pseudo, String password, String role) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.pseudo = pseudo;
	this.password = password;
	this.role = role;
}

public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}




   
}
