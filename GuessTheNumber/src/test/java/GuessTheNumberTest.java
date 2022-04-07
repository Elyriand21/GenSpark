import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {
    GuessTheNumber guessTheNumber;

    @BeforeEach
    void setUp() {
        guessTheNumber = new GuessTheNumber();
    }

    @Test
    void getName() {
        guessTheNumber.setName("Felix");
        assertEquals("Felix", guessTheNumber.getName(), "This method should return Felix");
    }

    @Test
    void getAnswer() {
        guessTheNumber.setAnswer(3);
        assertEquals(3, guessTheNumber.getAnswer(), "This method should return 3");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("No errors were found. All tests completed...");
    }
}