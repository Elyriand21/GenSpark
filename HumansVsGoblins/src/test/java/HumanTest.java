import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human human;

    @BeforeEach
    void setUp() {
        human = new Human();
    }

    @Test
    void attack() {
        human.setStrength(3);

        assertEquals(3, human.attack(), "This should return 3");
    }

    @Test
    void getHealth() {
        human.setHealth(34);

        assertEquals(34, human.getHealth(), "This should return 34");
    }

    @Test
    void getStrength() {
        human.setStrength(34);

        assertEquals(34, human.getStrength(), "This should return 34");
    }

    @Test
    void getName() {
        human.setName("Marc");

        assertEquals("Marc", human.getName(), "This should return Marc");
    }

    @Test
    void getSex() {
        human.setSex("Male");

        assertEquals("Male", human.getSex(), "This should return Male");
    }

    @Test
    void getIcon() {
        human.setIcon("34");

        assertEquals("34", human.getIcon(), "This should return 34");
    }

    @Test
    void getCoords() {
        human.setCoords(new Point(3,4));

        assertEquals(new Point(3,4), human.getCoords(), "This should return a Point object at 3,4");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All tests completed. No errors found");
    }
}