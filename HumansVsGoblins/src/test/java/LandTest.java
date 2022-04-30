import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    Land land;
    Human human;

    @BeforeEach
    void setUp(){
        land = new Land();
        human = new Human();
    }

    @Test
    void doesContainCharacter() {
        land.setContainsCharacter(true);

        assertEquals(true, land.doesContainCharacter(), "This should return true");
    }

    @Test
    void getCoords() {
        land.setCoords(new Point(3,4));

        assertEquals(new Point(3,4), land.getCoords(), "This should return a Point object at 3,4");
    }

    @Test
    void getContainedCharClass() {
        land.setContainedCharClass(human.getClass());

        assertEquals(human.getClass(), land.getContainedCharClass(), "This should return the Human class");
    }

    @Test
    void getCharacter() {
        land.setCharacter(human);

        assertEquals(human, land.getCharacter(), "This should return the \"human\" character");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("All tests completed. No errors were found");
    }
}