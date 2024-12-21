package fr.fidtec;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // https://www.baeldung.com/java-flight-recorder-monitoring
    // Java Flight Recorder
    // https://github.com/openjdk/jmc

    // 1. javac -d out -sourcepath src/main src/main/java/fr/fidtec/main.java
    // 2. java -XX:+FlightRecorder -XX:StartFlightRecording=duration=200s,filename=test.jfr -cp ./out/ fr.fidtec.Main
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<Object> items = new ArrayList<>(1);
        try {
            while (true){
                items.add(new Object());
            }
        } catch (OutOfMemoryError e){
            System.out.println(e.getMessage());
        }

        assert items.size() > 0;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}