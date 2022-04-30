import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LandGridTest {
    LandGrid landGrid;
    Human human1,human2,human3,human4,human5;
    Goblin goblin1,goblin2,goblin3,goblin4,goblin5;
    ArrayList<Human> humanList;
    ArrayList<Goblin> goblinList;

    @BeforeEach
    void setUp() {
        human1 = new Human();
        human2 = new Human();
        human3 = new Human();
        human4 = new Human();
        human5 = new Human();
        goblin1 = new Goblin();
        goblin2 = new Goblin();
        goblin3 = new Goblin();
        goblin4 = new Goblin();
        goblin5 = new Goblin();
        landGrid = new LandGrid(human1,human2,human3,human4,human5,goblin1,goblin2,goblin3,goblin4,goblin5);
        humanList = landGrid.getHumans();
        goblinList = landGrid.getGoblins();
    }

    @Test
    void removeHumanFromArray() {
        landGrid.removeHumanFromArray(human1);

        assertEquals(false, landGrid.getHumans().contains(human1), "This should return false");
    }

    @Test
    void removeGoblinFromArray() {
        landGrid.removeGoblinFromArray(goblin1);

        assertEquals(false, landGrid.getGoblins().contains(goblin1), "This should return false");
    }

    @Test
    void getCharacterAtCoords() {
        landGrid.setCharacterAtCoords(new Point(3,4), human1);

        assertEquals(human1, landGrid.getCharacterAtCoords(new Point(3,4)), "This should return human 1");
    }

    @Test
    void getHumans() {
        assertEquals(humanList, landGrid.getHumans(), "This should return an ArrayList with Humans in it");
    }

    @Test
    void getGoblins() {
        assertEquals(goblinList, landGrid.getGoblins(), "This should return an ArrayList with Goblins in it");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All tests completed. No errors found...");
    }
}