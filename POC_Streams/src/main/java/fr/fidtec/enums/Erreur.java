package fr.fidtec.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;


@RequiredArgsConstructor
@Getter
public enum Erreur {

    INCONNUE(0, "Erreur inconnue"),
    ERREUR1(1, "ERREUR1"),
    ERREUR2(2, "ERREUR2");

    private final Integer code;
    private final String description;

    public static Erreur getErreur(final Integer code) {
        return Arrays.stream(Erreur.values())
                .filter(e ->e.getCode().equals(code))
                .findFirst()
                .orElse(INCONNUE);
    }
}
