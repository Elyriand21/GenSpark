import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonCaveTest {

    DragonCave dragonCave;

    @BeforeEach
    void setUp() {
        dragonCave = new DragonCave();
    }

    @Test
    void getAnswer() {
        dragonCave.setAnswer(1);
        assertEquals(1, dragonCave.getAnswer(), "This method should return a 1");
    }

    @AfterEach
    void tearDown() {
        System.out.println("No errors were found. Tests completed...");
    }
}