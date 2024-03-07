package main.java;

import java.util.*;

public class DuplicatesDetector {

    public List<String> findDuplicates(String text) {
        List<String> duplicates = new ArrayList<>();

        // split the text into sentences
        String[] sentences = text.split("[.!?,]");

        for (String sentence : sentences) {
            // split the sentence into words
            String[] words = sentence.split("\\s+");

            // check each word if the next one is the same
            for (int i = 0; i < words.length - 1; i++) {
                String currentWord = words[i];
                String nextWord = words[i + 1];

                // check if currentWord and nextWord are equal
                if (currentWord.equalsIgnoreCase(nextWord)) {
                    duplicates.add(nextWord);
                }
            }
        }
        return duplicates;
    }
}
