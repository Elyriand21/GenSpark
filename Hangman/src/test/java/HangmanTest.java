import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    Hangman hangman;

    @BeforeEach
    void setUp() {
         hangman = new Hangman();
    }

    @Test
    void getWordToGuess() {
        hangman.setWordToGuess("letters");
        assertEquals("letters", hangman.getWordToGuess(), "This should return letters");
    }

    @Test
    void getMissedLetters(){
        hangman.setMissedLetters("xgh");
        assertEquals("xgh", hangman.getMissedLetters(), "This should return xgh");
    }

    @Test
    void getLettersLeft() {
        hangman.setLettersLeft(3);
        assertEquals(3, hangman.getLettersLeft(), "This should return a 3");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All tests completed. No errors were found...");
    }
}