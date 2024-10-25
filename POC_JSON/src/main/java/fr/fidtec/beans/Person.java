package fr.fidtec.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

// @Builder est à préférer à @Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	@JsonProperty("nom")
	private String lastName;

	@JsonProperty("prenom")
	private String firstName;
			
}
