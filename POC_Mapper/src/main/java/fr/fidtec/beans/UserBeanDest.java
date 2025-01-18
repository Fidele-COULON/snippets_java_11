package fr.fidtec.beans;

import fr.fidtec.enums.MrMme_FR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBeanDest {
    private String prenom;
    private String nom;
    private MrMme_FR genre;
}
