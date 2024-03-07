package main.java;

import java.util.List;
import java.util.Set;

public class DuplicatesMain {
    public static void main(String[] args) {

        if (args.length == 1) {

            DuplicatesDetector duplicatesDetector = new DuplicatesDetector();
            List<String> duplicates = duplicatesDetector.findDuplicates(args[0]);

            System.out.println("Duplicates: ");
            duplicates.forEach(System.out::println);

        } else if (args.length > 1) {
            System.err.println("Too many arguments.");
        } else {
            System.err.println("Text is missing.");
        }

    }

}