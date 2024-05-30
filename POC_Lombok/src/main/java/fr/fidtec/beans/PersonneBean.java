package fr.fidtec.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonneBean {

	@Getter @Setter
	private String nom;
	
	@Getter @Setter
	private String prenom;
			
}
