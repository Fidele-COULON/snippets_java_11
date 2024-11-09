package fr.fidtec.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserNotNull {

    @NotNull(message = "Name may not be null")
    private String name;
}