import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    Goblin goblin;

    @BeforeEach
    void setUp() {
        goblin = new Goblin();
    }

    @Test
    void getName() {
        goblin.setGoblinName("Jacob");

        assertEquals("Jacob", goblin.getName(), "This should return Jacob");
    }

    @Test
    void getHealth() {
        goblin.setHealth(55);

        assertEquals(55, goblin.getHealth(), "This should return 55");
    }

    @Test
    void getStrength() {
        goblin.setStrength(3);

        assertEquals(3, goblin.getStrength(), "This should return 3");
    }

    @Test
    void getIcon() {
        goblin.setIcon("t");

        assertEquals("t", goblin.getIcon(), "This should return t");
    }

    @Test
    void getCoords() {
        goblin.setCoords(new Point(3,4));

        assertEquals(new Point(3,4), goblin.getCoords(), "This should return a Point object at 3,4");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All tests completed. No errors were found");
    }
}