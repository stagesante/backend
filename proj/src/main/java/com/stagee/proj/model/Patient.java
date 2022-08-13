package com.stagee.proj.model;


import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

@Document(collection= "patient")
public class Patient {
	 @Id
	 private int id;
	 private String nom;
	 private String prenom;
	 private Date naissance;
	 private String gender;
	 private String ville;
	 float[] tension = new float[100];
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float[] getTension() {
		return tension;
	}
	public void setTension(float[] tension) {
		this.tension = tension;
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
	public Date getNaissance() {
		return naissance;
	}
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	private String adresse;
	 private int tel;
	
	 
}
