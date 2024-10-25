package fr.fidtec.beans;

import lombok.*;

// @Builder est à préférer à @Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Personne {

	private String nom;

	private String prenom;
			
}
