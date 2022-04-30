import java.awt.*;
import java.util.*;

public class LandGrid {
    // ONLY FOR GETTING CLASS
    private Human human = new Human();
    private Goblin goblin = new Goblin();

    // Variables
    private static final int cols = 5;
    private static final int rows = 5;
    private int coordsLeft = 10;
    // Creates an array for the land to be in a grid
    private Land[][] grid = new Land[5][5];
    // Creates an array to store the Humans
    private ArrayList<Human> humans = new ArrayList<>();
    // Creates an array to store the Goblins
    private ArrayList<Goblin> goblins = new ArrayList<>();
    // HashMap to store coordinate pairs
    public ArrayList<Point> coords = new ArrayList<Point>();

    public LandGrid(Human human1, Human human2, Human human3, Human human4, Human human5, Goblin goblin1,
                    Goblin goblin2, Goblin goblin3, Goblin goblin4, Goblin goblin5) {
        for (int i = 0; i < cols; i++) {
            for (int e = 0; e < rows; e++) {
                grid[i][e] = new Land();
            }
        }
        // Sets the coords for each object in grid
        setLandCords();
        // Ensures that no two characters have the same coordinates
        while (coordsLeft != 0) {
            switch (coordsLeft) {
                case 10:
                    coords.add(human1.getCoords());
                    humans.add(human1);
                    coordsLeft--;
                    break;
                case 9:
                    human2 = (Human) makeUnique(human2);
                    coords.add(human2.getCoords());
                    humans.add(human2);
                    coordsLeft--;
                    break;
                case 8:
                    human3 = (Human) makeUnique(human3);
                    coords.add(human3.getCoords());
                    humans.add(human3);
                    coordsLeft--;
                    break;
                case 7:
                    human4 = (Human) makeUnique(human4);
                    coords.add(human4.getCoords());
                    humans.add(human4);
                    coordsLeft--;
                    break;
                case 6:
                    human5 = (Human) makeUnique(human5);
                    coords.add(human5.getCoords());
                    humans.add(human5);
                    coordsLeft--;
                    break;
                case 5:
                    goblin1 = (Goblin) makeUnique(goblin1);
                    coords.add(goblin1.getCoords());
                    goblins.add(goblin1);
                    coordsLeft--;
                    break;
                case 4:
                    goblin2 = (Goblin) makeUnique(goblin2);
                    coords.add(goblin2.getCoords());
                    goblins.add(goblin2);
                    coordsLeft--;
                    break;
                case 3:
                    goblin3 = (Goblin) makeUnique(goblin3);
                    coords.add(goblin3.getCoords());
                    goblins.add(goblin3);
                    coordsLeft--;
                    break;
                case 2:
                    goblin4 = (Goblin) makeUnique(goblin4);
                    coords.add(goblin4.getCoords());
                    goblins.add(goblin4);
                    coordsLeft--;
                    break;
                case 1:
                    goblin5 = (Goblin) makeUnique(goblin5);
                    coords.add(goblin5.getCoords());
                    goblins.add(goblin5);
                    coordsLeft--;
                    break;
            }
        }
        // Places the generated characters on the grid in their respective coords
        for (int i = 0; i < cols; i++) {
            for (int e = 0; e < rows; e++) {
                if (!grid[i][e].doesContainCharacter()) {
                    if (grid[i][e].getCoords().getX() == human1.getCoords().getX() && grid[i][e].getCoords().getY() == human1.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(human1.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(human1.getClass());
                        grid[i][e].setCharacter(human1);
                    }

                    if (grid[i][e].getCoords().getX() == human2.getCoords().getX() && grid[i][e].getCoords().getY() == human2.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(human2.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(human2.getClass());
                        grid[i][e].setCharacter(human2);
                    }
                    if (grid[i][e].getCoords().getX() == human3.getCoords().getX() && grid[i][e].getCoords().getY() == human3.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(human3.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(human3.getClass());
                        grid[i][e].setCharacter(human3);
                    }
                    if (grid[i][e].getCoords().getX() == human4.getCoords().getX() && grid[i][e].getCoords().getY() == human4.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(human4.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(human4.getClass());
                        grid[i][e].setCharacter(human4);
                    }
                    if (grid[i][e].getCoords().getX() == human5.getCoords().getX() && grid[i][e].getCoords().getY() == human5.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(human5.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(human5.getClass());
                        grid[i][e].setCharacter(human5);
                    }
                    if (grid[i][e].getCoords().getX() == goblin1.getCoords().getX() && grid[i][e].getCoords().getY() == goblin1.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(goblin1.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(goblin1.getClass());
                        grid[i][e].setCharacter(goblin1);
                    }
                    if (grid[i][e].getCoords().getX() == goblin2.getCoords().getX() && grid[i][e].getCoords().getY() == goblin2.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(goblin2.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(goblin2.getClass());
                        grid[i][e].setCharacter(goblin2);
                    }
                    if (grid[i][e].getCoords().getX() == goblin3.getCoords().getX() && grid[i][e].getCoords().getY() == goblin3.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(goblin3.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(goblin3.getClass());
                        grid[i][e].setCharacter(goblin3);
                    }
                    if (grid[i][e].getCoords().getX() == goblin4.getCoords().getX() && grid[i][e].getCoords().getY() == goblin4.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(goblin4.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(goblin4.getClass());
                        grid[i][e].setCharacter(goblin4);
                    }
                    if (grid[i][e].getCoords().getX() == goblin5.getCoords().getX() && grid[i][e].getCoords().getY() == goblin5.getCoords().getY()) {
                        grid[i][e].setCharacterIcon(goblin5.getIcon());
                        grid[i][e].setContainsCharacter(true);
                        grid[i][e].setContainedCharClass(goblin5.getClass());
                        grid[i][e].setCharacter(goblin5);
                    }
                }
            }
        }
    }

    public void displayGrid() {
        for (int a = 0; a < 5; a++) {
            if(a == 0){
                for(int i = 0; i < 5; i++){
                    System.out.print(String.format("%-8s%-8s", "", i));
                }
                System.out.print("\n");
            }
            for (int i = 0; i < 5; i++) {
                grid[i][a].displayTop();
                if(a == 2 && i == 4){
                    System.out.print(String.format("%-17s%-5s", "", "___"));
                }
            }

            System.out.print("\n");
            for (int i = 0; i < 5; i++) {
                grid[i][a].displaySecond();
                if(a == 0 && i == 4){
                    System.out.print(String.format("%-7s%-5s", "", "\033[0;1m" + "H U M A N S  V S  G O B L I N S" + "\033[0;0m"));
                }
                if(a == 2 && i == 4){
                    System.out.print(String.format("%-15s%-5s", "", "/  N  \\"));
                }
            }
            System.out.print("\n");
            for (int i = 0; i < 5; i++) {
                if(i == 0){
                    System.out.print(a + " ");
                }
                grid[i][a].displayThird();
                if(a == 0 && i == 4){
                    System.out.print(String.format("%-2s%-5s", "", "\033[3m" + "A 5v5 game between Humans and Goblins" + "\033[0m"));
                }
                if(a == 2 && i == 4){
                    System.out.print(String.format("%-12s%-5s", "", "| W + E |"));
                }
                if(a == 1 && i == 4){
                    System.out.print(String.format("%-18s%-5s", "", "___"));
                }

            }
            System.out.print("\n");
            for (int i = 0; i < 5; i++) {
                grid[i][a].displayFourth();
                if(a == 0 && i == 4){
                    System.out.print(String.format("%-6s%-5s", "", "\033[3m" + "Will you survive the Goblin horde" +"\033[0m"));
                }
                if(a == 2 && i == 4){
                    System.out.print(String.format("%-15s%-5s", "", "\\  N  /"));
                }
                if(a == 1 && i == 4){
                    System.out.print(String.format("%-19s%-5s", "", "/    \\"));
                }
            }
            System.out.print("\n");
            for (int i = 0; i < 5; i++) {
                grid[i][a].displayBottom();
                if(a == 0 && i == 4){
                    System.out.print(String.format("%-4s%-5s", "", "\033[3m" + "Or will you succumb to their strength?" + "\033[0m"));
                }
                if(a == 2 && i == 4){
                    System.out.print(String.format("%-17s%-5s", "", "---"));
                }
                if(a == 1 && i == 4){
                    System.out.print(String.format("%-18s%-5s", "", "|     |"));
                }
            }
            System.out.print("\n");
        }
        getAllStats();
    }
    public boolean[] checkMoveSpace(Object obj, LandGrid grid1, String dir){
        boolean[] booleanArray = new boolean[2];
        // If the object to move is a Human
        if(obj.getClass().equals(human.getClass())){
            Human temp = (Human) obj;

            switch (dir) {
                case "n":
                    if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() - 1].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() - 1].getContainedCharClass().equals(goblin.getClass())) {
                            // If the position the Human is trying to move and there is a Goblin there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() - 1].getContainedCharClass().equals(human.getClass())) {
                            // If the position the Human is trying to move and there is a Human there
                            return booleanArray;
                        }
                    } else {
                        // If the position the Human is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
                case "s":
                    if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() + 1].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() + 1].getContainedCharClass().equals(goblin.getClass())) {
                            // If the position the Human is trying to move and there is a Goblin there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() + 1].getContainedCharClass().equals(human.getClass())) {
                            // If the position the Human is trying to move and there is a Human there
                            return booleanArray;
                        }
                    } else {
                        // If the position the Human is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
                case "w":
                    if (grid[(int) temp.getCoords().getX() - 1][(int) temp.getCoords().getY()].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX() - 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(goblin.getClass())) {
                            // If the position the Human is trying to move and there is a Goblin there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX() - 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(human.getClass())) {
                            return booleanArray;
                        }
                    } else {
                        // If the position the Human is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
                case "e":
                    if (grid[(int) temp.getCoords().getX() + 1][(int) temp.getCoords().getY()].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX() + 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(goblin.getClass())) {
                            // If the position the Human is trying to move and there is a Goblin there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX() + 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(human.getClass())) {
                            // If the position the Human is trying to move and there is a human there
                            return booleanArray;
                        }
                    } else {
                        // If the position the Human is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
            }
        }
        // If the object to move is a Goblin
        else{
            Goblin temp = (Goblin) obj;

            switch (dir) {
                case "n":
                    if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() - 1].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() - 1].getContainedCharClass().equals(human.getClass())) {
                            // If the position the Goblin is trying to move and there is a Human there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() - 1].getContainedCharClass().equals(goblin.getClass())) {
                            // If the position the Goblin is trying to move and there is a Goblin there
                            return booleanArray;
                        }
                    } else {
                        // If the position the Goblin is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
                case "s":
                    if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() + 1].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() + 1].getContainedCharClass().equals(human.getClass())) {
                            // If the position the Goblin is trying to move and there is a Human there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY() + 1].getContainedCharClass().equals(goblin.getClass())) {
                            // If the position the Goblin is trying to move and there is a Goblin there
                            return booleanArray;
                        }
                    } else {
                        // If the position the Goblin is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
                case "w":
                    if (grid[(int) temp.getCoords().getX() - 1][(int) temp.getCoords().getY()].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX() - 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(human.getClass())) {
                            // If the position the Goblin is trying to move and there is a Human there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX() - 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(goblin.getClass())) {
                            // If the position the Goblin is trying to move and there is a Goblin there
                            return booleanArray;
                        }
                    } else {
                        // If the position the Goblin is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
                case "e":
                    if (grid[(int) temp.getCoords().getX() + 1][(int) temp.getCoords().getY()].doesContainCharacter()) {
                        if (grid[(int) temp.getCoords().getX() + 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(human.getClass())) {
                            // If the position the Goblin is trying to move and there is a Human there
                            booleanArray[0] = true;
                            booleanArray[1] = true;
                            return booleanArray;
                        } else if (grid[(int) temp.getCoords().getX() + 1][(int) temp.getCoords().getY()].getContainedCharClass().equals(goblin.getClass())) {
                            return booleanArray;
                        }
                    } else {
                        // If the position the Goblin is trying to move and there is nothing there
                        booleanArray[0] = true;
                        return booleanArray;
                    }
                    break;
            }
        }
        return booleanArray;
    }

    private Object makeUnique(Object obj) {
        if (obj.getClass().equals(human.getClass())) {
            Human temp = (Human) obj;
            while (coords.contains(temp.getCoords())) {
                temp = new Human();
            }
            return temp;
        } else {
            Goblin temp2 = (Goblin) obj;
            while (coords.contains(temp2.getCoords())) {
                temp2 = new Goblin();
            }
            return temp2;
        }
    }

    // SETTERS
    private void setLandCords() {
        for (int i = 0; i < cols; i++) {
            for (int e = 0; e < rows; e++) {
                grid[i][e].setCoords(new Point((int) i, (int) e));
            }
        }
    }
    public void setNewCharLocation(Object obj) {
        if(obj.getClass().equals(human.getClass())) {
            Human temp = (Human) obj;
            coords.add(temp.getCoords());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setCharacterIcon(temp.getIcon());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(true);
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setCharacter(temp);
        }
        else{
            Goblin temp = (Goblin) obj;
            coords.add(temp.getCoords());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setCharacterIcon(temp.getIcon());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(true);
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setCharacter(temp);
        }
    }
    public void setNewContainedCharacterClass(Object obj){
        if(obj.getClass().equals(human.getClass())) {
            Human temp = (Human) obj;
            coords.add(temp.getCoords());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainedCharClass(temp.getClass());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(true);
        }
        else{
            Goblin temp = (Goblin) obj;
            coords.add(temp.getCoords());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainedCharClass(temp.getClass());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(true);
        }
    }
    public void setCharacterAtCoords(Point a, Object obj){
        grid[(int) a.getX()][(int) a.getY()].setCharacter(obj);
    }
    public void addHumanToArray(Human hum){
        humans.add(hum);
    }
    public void addGoblinToArray(Goblin gob){
        goblins.add(gob);
    }

    // REMOVERS
    public void removeCharacterIcon(Object obj){
        if(obj.getClass().equals(human.getClass())) {
            Human temp = (Human) obj;
            coords.remove(temp.getCoords());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setCharacterIcon(" ");
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(false);
        }
        else{
            Goblin temp = (Goblin) obj;
            coords.remove(temp.getCoords());
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setCharacterIcon(" ");
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(false);
        }
    }
    public void removeContainedCharacterClass(Object obj){
        if(obj.getClass().equals(human.getClass())) {
            Human temp = (Human) obj;
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainedCharClass(null);
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(false);
        }
        else{
            Goblin temp = (Goblin) obj;
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainedCharClass(null);
            grid[(int) temp.getCoords().getX()][(int) temp.getCoords().getY()].setContainsCharacter(false);
        }
    }
    public void removeHumanFromArray(Human hum){
        Human temp = hum;
        if(humans.contains(temp)){
            humans.set(humans.indexOf(temp), null);
        }
    }
    public void removeGoblinFromArray(Goblin gob){
        Goblin temp = gob;
        temp.setGoblinName(gob.getName());
        if(goblins.contains(gob)){
            goblins.set(goblins.indexOf(gob), null);
        }
    }

    // GETTERS
    public Object getCharacterAtCoords(Point a){
        return grid[(int) a.getX()][(int) a.getY()].getCharacter();
    }
    public ArrayList<Human> getHumans() {
        return humans;
    }
    public ArrayList<Goblin> getGoblins() {
        return goblins;
    }
    private void getAllStats() {
        // If Goblin 1 is still alive
        if(goblins.get(0) != null){
            System.out.print("Goblin 1: " + goblins.get(0).getName() + ", HP: " + goblins.get(0).getHealth() + ", Strength: " + goblins.get(0).getStrength() + ", Coords: [" +
                    ((int) goblins.get(0).getCoords().getX()) + ", " + ((int) goblins.get(0).getCoords().getY()) + "]" + ", Character: " + goblins.get(0) + "\n");
        }
        // If Goblin 2 is still alive
        if(goblins.get(1) != null){
            System.out.print("Goblin 2: " + goblins.get(1).getName() + ", HP: " + goblins.get(1).getHealth() + ", Strength: " + goblins.get(1).getStrength() + ", Coords: [" +
                    ((int) goblins.get(1).getCoords().getX()) + ", " + ((int) goblins.get(1).getCoords().getY()) + "]" + ", Character: " + goblins.get(1) + "\n");
        }
        // If Goblin 3 is still alive
        if(goblins.get(2) != null){
            System.out.print("Goblin 3: " + goblins.get(2).getName() + ", HP: " + goblins.get(2).getHealth() + ", Strength: " + goblins.get(2).getStrength() + ", Coords: [" +
                    ((int) goblins.get(2).getCoords().getX()) + ", " + ((int) goblins.get(2).getCoords().getY()) + "]" + ", Character: " + goblins.get(2) + "\n");
        }
        // If Goblin 4 is still alive
        if(goblins.get(3) != null){
            System.out.print("Goblin 4: " + goblins.get(3).getName() + ", HP: " + goblins.get(3).getHealth() + ", Strength: " + goblins.get(3).getStrength() + ", Coords: [" +
                    ((int) goblins.get(3).getCoords().getX()) + ", " + ((int) goblins.get(3).getCoords().getY()) + "]" + ", Character: " + goblins.get(3) + "\n");
        }
        // If Goblin 5 is still alive
        if(goblins.get(4) != null){
            System.out.print("Goblin 5: " + goblins.get(4).getName() + ", HP: " + goblins.get(4).getHealth() + ", Strength: " + goblins.get(4).getStrength() + ", Coords: [" +
                    ((int) goblins.get(4).getCoords().getX()) + ", " + ((int) goblins.get(4).getCoords().getY()) + "]" + ", Character: " + goblins.get(4) + "\n");
        }
        // If Human 1 is still alive
        if(humans.get(0) != null){
            System.out.print("Human 1: " + humans.get(0).getName() + ", HP: " + humans.get(0).getHealth() + ", Strength: " + humans.get(0).getStrength() + ", Sex: " +
                    humans.get(0).getSex() + ", Coords: [" + ((int) humans.get(0).getCoords().getX()) + ", " + ((int) humans.get(0).getCoords().getY()) + "]\n");
        }
        // If Human 2 is still alive
        if(humans.get(1) != null){
            System.out.print("Human 2: " + humans.get(1).getName() + ", HP: " + humans.get(1).getHealth() + ", Strength: " + humans.get(1).getStrength() + ", Sex: " +
                    humans.get(1).getSex() + ", Coords: [" + ((int) humans.get(1).getCoords().getX()) + ", " + ((int) humans.get(1).getCoords().getY()) + "]\n");
        }
        // If Human 3 is still alive
        if(humans.get(2) != null){
            System.out.print("Human 3: " + humans.get(2).getName() + ", HP: " + humans.get(2).getHealth() + ", Strength: " + humans.get(2).getStrength() + ", Sex: " +
                    humans.get(2).getSex() + ", Coords: [" + ((int) humans.get(2).getCoords().getX()) + ", " + ((int) humans.get(2).getCoords().getY()) + "]\n");
        }
        // If Human 4 is still alive
        if(humans.get(3) != null){
            System.out.print("Human 4: " + humans.get(3).getName() + ", HP: " + humans.get(3).getHealth() + ", Strength: " + humans.get(3).getStrength() + ", Sex: " +
                    humans.get(3).getSex() + ", Coords: [" + ((int) humans.get(3).getCoords().getX()) + ", " + ((int) humans.get(3).getCoords().getY()) + "]\n");
        }
        // If Human 5 is still alive
        if(humans.get(4) != null){
            System.out.print("Human 5: " + humans.get(4).getName() + ", HP: " + humans.get(4).getHealth() + ", Strength: " + humans.get(4).getStrength() + ", Sex: " +
                    humans.get(4).getSex() + ", Coords: [" + ((int) humans.get(4).getCoords().getX()) + ", " + ((int) humans.get(4).getCoords().getY()) + "]\n");
        }
    }
}
