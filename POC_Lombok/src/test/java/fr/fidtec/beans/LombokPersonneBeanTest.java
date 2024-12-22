package fr.fidtec.beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LombokPersonneBeanTest {

	@Test
	public void LombokPersonneBean_Builder_Test() {
		
		LombokPersonneBean p = LombokPersonneBean.builder().nom("COULON").prenom("Fidele").build();

		System.out.println(p.toString());
		
		assertEquals("COULON", p.getNom());
		assertEquals("Fidele", p.getPrenom());

	}
}
