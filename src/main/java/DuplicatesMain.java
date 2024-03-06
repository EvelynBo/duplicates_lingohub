package main.java;

import java.util.List;

public class DuplicatesMain {
    public static void main(String[] args) {

        if (args.length == 1) {

            DuplicatesDetector duplicateDetector = new DuplicatesDetector();
            List<String> duplicates = duplicateDetector.findDuplicateWords(args[0]);

            System.out.println("Duplicates: " + String.join(" ", duplicates));

        } else if (args.length > 1) {
            System.err.println("Too many arguments.");
        } else {
            System.err.println("Text is missing.");
        }

    }

}