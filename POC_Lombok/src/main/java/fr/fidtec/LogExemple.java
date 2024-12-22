package fr.fidtec;

import lombok.extern.java.Log;

// https://projectlombok.org/features/log
@Log
public class LogExemple {

    public static void main(String... args) {
        log.severe("Something's wrong here");
    }

}
