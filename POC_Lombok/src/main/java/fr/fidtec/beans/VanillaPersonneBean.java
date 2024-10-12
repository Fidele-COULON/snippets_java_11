package fr.fidtec.beans;

public class VanillaPersonneBean {

	private String nom;
	private String prenom;
	
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
	
	public static VanillaPersonneBeanBuilder builder() {
		
		return new VanillaPersonneBeanBuilder();
	}
}
