package fr.fidtec.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Builder est à préférer à @Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LombokPersonneBean {

	@Getter @Setter
	private String nom;
	
	@Getter @Setter
	private String prenom;
			
}
