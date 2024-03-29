package main.test;

import main.java.DuplicatesDetector;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DuplicatesTest {

    private final DuplicatesDetector duplicateDetection = new DuplicatesDetector();

    @Test
    public void testStandardCase() {
        String text_01 = "Das das ist ein Auto.";
        List<String> duplicates = duplicateDetection.findDuplicates(text_01);
        assertEquals(1, duplicates.size());
        assertTrue(duplicates.contains("das"));

        String text_02 = "Das das das ist ein Auto.";
        List<String> duplicates02 = duplicateDetection.findDuplicates(text_02);
        assertEquals(2, duplicates02.size());
        assertTrue(duplicates02.contains("das"));
    }

    @Test
    public void testEdgeCase() {
        String text = "Das ist ein Einser.";
        List<String> duplicates = duplicateDetection.findDuplicates(text);
        assertTrue(duplicates.isEmpty());
    }

    @Test
    public void testEmptyText() {
        String text = "";
        List<String> duplicates = duplicateDetection.findDuplicates(text);
        assertTrue(duplicates.isEmpty());
    }

    @Test
    public void testSpecialCharacters() {
        String text = "Das ist eins, eins oder noch eins!";
        List<String> duplicates = duplicateDetection.findDuplicates(text);
        assertTrue(duplicates.isEmpty());

    }

    @Test
    public void testCapitalLetters() {
        String text = "Das das ist ein Auto";
        List<String> duplicates = duplicateDetection.findDuplicates(text);
        assertEquals(1, duplicates.size());
        assertTrue(duplicates.contains("das"));
    }

    /**
     * Test performance with a timeout and a large list
     */
    @Test(timeout = 100)
    public void testPerformance() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("test ");
        }
        List<String> duplicates = duplicateDetection.findDuplicates(builder.toString());
        assertTrue(duplicates.contains("test"));
    }

    /**
     * Test performance with a timeout and a large list with sentences
     */
    @Test(timeout = 500)
    public void testPerformanceWithSentences() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("Test Tests, das ist ein ein Test. ");
        }
        List<String> duplicates = duplicateDetection.findDuplicates(builder.toString());
        assertEquals(10000, duplicates.size());
        assertTrue(duplicates.contains("ein"));
    }

    /**
     * Test performance with a timeout and a large list with unique words
     */
    @Test(timeout = 100)
    public void testPerformanceWithUniqueWords() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("test").append(i).append(" ");
        }
        List<String> duplicates = duplicateDetection.findDuplicates(builder.toString());
        assertTrue(duplicates.isEmpty());
    }

}
