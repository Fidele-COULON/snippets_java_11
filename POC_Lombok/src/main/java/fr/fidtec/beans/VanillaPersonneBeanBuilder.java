package fr.fidtec.beans;

public class VanillaPersonneBeanBuilder {

	private VanillaPersonneBean bean = new VanillaPersonneBean();
	
	public VanillaPersonneBeanBuilder nom(String nom) {
		bean.setNom(nom);
		return this;
	}
	
	public VanillaPersonneBeanBuilder prenom(String prenom) {
		bean.setPrenom(prenom);
		return this;
	}
	
	public VanillaPersonneBean build() {
		return bean;
	}

}
