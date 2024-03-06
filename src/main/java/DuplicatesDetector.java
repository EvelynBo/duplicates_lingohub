package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesDetector {

    public List<String> findDuplicateWords(String text) {

        if (text == null || text.isEmpty()) {
            return new ArrayList<>();
        }

        //split text into Array with words
        String[] words = text.split("\\s");

        // create Map to store words and number of occurrences in text
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            // remove special characters at the beginning or ending of a word
            // and convert to lower case
            word = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "").toLowerCase();

            // add word to Map and update occurrences
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // return only keys from the map with a higher occurrence than 1
        return wordMap.entrySet().stream()
                .filter(word -> word.getValue() > 1)
                .map(Map.Entry::getKey).toList();
    }
}