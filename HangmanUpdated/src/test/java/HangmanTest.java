import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    HangmanUpdated hangmanUpdated;

    @BeforeEach
    void setUp() {
         hangmanUpdated = new HangmanUpdated();
    }

    @Test
    void getWordToGuess() {
        hangmanUpdated.setWordToGuess("letters");
        assertEquals("letters", hangmanUpdated.getWordToGuess(), "This should return letters");
    }

    @Test
    void getMissedLetters(){
        hangmanUpdated.setMissedLetters("xgh");
        assertEquals("xgh", hangmanUpdated.getMissedLetters(), "This should return xgh");
    }

    @Test
    void getLettersLeft() {
        hangmanUpdated.setLettersLeft(3);
        assertEquals(3, hangmanUpdated.getLettersLeft(), "This should return a 3");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All tests completed. No errors were found...");
    }
}