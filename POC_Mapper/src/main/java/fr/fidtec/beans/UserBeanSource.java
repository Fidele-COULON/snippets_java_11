package fr.fidtec.beans;

import fr.fidtec.enums.MrMme_US;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBeanSource {
    private String firstName;
    private String lastName;
    private MrMme_US gender;
}
