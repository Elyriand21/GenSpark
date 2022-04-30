import java.awt.*;
import java.util.*;

public class HumansVsGoblins {
    private boolean play;
    private boolean needToMove;
    private boolean needToFight;
    private boolean showEnd;
    private boolean userTurn;
    private Human fightingHuman;
    private Goblin fightingGoblin;
    private int whoWon;
    private int humansLeft;
    private int goblinsLeft;
    private ArrayList<String> deadHumans;

    private static Point temp = new Point();

    Goblin goblin1, goblin2, goblin3, goblin4, goblin5;
    Human human1, human2, human3, human4, human5;
    LandGrid grid;

    public HumansVsGoblins() {
        generateGame();
    }

    public void run() {
        while (play) {
            grid.displayGrid();
            while (needToMove) {
                displayMoveInstructions();
                while (needToFight) {
                    displayCombat(fightingHuman, fightingGoblin);
                }
            }
            while (showEnd) {
                displayEndText();
            }
        }
    }

    private void displayMoveInstructions() {
        if (humansLeft == 0) {
            whoWon = 1;
            needToMove = false;
            showEnd = true;
        } else if (goblinsLeft == 0) {
            whoWon = 0;
            needToMove = false;
            showEnd = true;
        } else {
            // If it is the player's turn
            if (userTurn) {
                String[] charAndDir = new String[2];

                charAndDir[0] = getCharacterToMove();
                charAndDir[1] = getDirectionToMove();

                System.out.println("Character: " + "\033[0;1m" + charAndDir[0] + "\033[0;0m" + "\nDirection: " + "\033[0;1m" + charAndDir[1] + "\033[0;0m");

                // If the user decides to move a human
                if (charAndDir[0].substring(0, 5).matches("human")) {
                    // User decides on Human 1
                    if (charAndDir[0].matches("human 1")) {
                        boolean canMove = false;
                        if (grid.getHumans().contains(human1)) {
                            while (!canMove) {
                                try {
                                    // [0] means can move [1] means there is a goblin
                                    boolean[] tempArray = grid.checkMoveSpace(human1, grid, charAndDir[1]);
                                    // If the Human is moving and there is nothing there
                                    if (tempArray[0] && !tempArray[1]) {
                                        grid.removeCharacterIcon(human1);
                                        grid.removeContainedCharacterClass(human1);
                                        grid.setCharacterAtCoords(human1.getCoords(), null);
                                        human1.move(charAndDir[1]);
                                        grid.setNewCharLocation(human1);
                                        grid.setNewContainedCharacterClass(human1);
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Goblin there
                                    else if (tempArray[0] & tempArray[1]) {
                                        System.out.println("Time to fight!");
                                        grid.removeCharacterIcon(human1);
                                        grid.removeContainedCharacterClass(human1);
                                        grid.setCharacterAtCoords(human1.getCoords(), null);
                                        human1.move(charAndDir[1]);
                                        fightingGoblin = (Goblin) grid.getCharacterAtCoords(human1.getCoords());
                                        fightingHuman = human1;
                                        needToFight = true;
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Human there
                                    else if (!tempArray[1]) {
                                        System.out.println("There's a Human where you want to move!");
                                        charAndDir[1] = getDirectionToMove();
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                    charAndDir[1] = getDirectionToMove();
                                }
                            }
                            if (!needToFight) {
                                userTurn = false;
                                grid.displayGrid();
                            }
                        } else {
                            System.out.print("\nThis Human is dead! Choose another");
                        }
                    }
                    // User decides on Human 2
                    else if (charAndDir[0].matches("human 2")) {
                        boolean canMove = false;
                        if (grid.getHumans().contains(human2)) {
                            while (!canMove) {
                                try {
                                    // [0] means can move [1] means there is a goblin
                                    boolean[] tempArray = grid.checkMoveSpace(human2, grid, charAndDir[1]);
                                    // If the Human is moving and there is nothing there
                                    if (tempArray[0] && !tempArray[1]) {
                                        grid.removeCharacterIcon(human2);
                                        grid.removeContainedCharacterClass(human2);
                                        grid.setCharacterAtCoords(human2.getCoords(), null);
                                        human2.move(charAndDir[1]);
                                        grid.setNewCharLocation(human2);
                                        grid.setNewContainedCharacterClass(human2);
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Goblin there
                                    else if (tempArray[0] & tempArray[1]) {
                                        System.out.println("Time to fight!");
                                        grid.removeCharacterIcon(human2);
                                        grid.removeContainedCharacterClass(human2);
                                        grid.setCharacterAtCoords(human2.getCoords(), null);
                                        human2.move(charAndDir[1]);
                                        fightingGoblin = (Goblin) grid.getCharacterAtCoords(human2.getCoords());
                                        fightingHuman = human2;
                                        needToFight = true;
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Human there
                                    else if (!tempArray[1]) {
                                        System.out.println("There's a Human where you want to move!");
                                        charAndDir[1] = getDirectionToMove();
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                    charAndDir[1] = getDirectionToMove();
                                }
                            }
                            if (!needToFight) {
                                userTurn = false;
                                grid.displayGrid();
                            }
                        } else {
                            System.out.print("\nThat human is dead! Please choose another character\n");
                            displayMoveInstructions();
                        }
                    }
                    // User decides on Human 3
                    else if (charAndDir[0].matches("human 3")) {
                        boolean canMove = false;
                        if (grid.getHumans().contains(human3)) {
                            while (!canMove) {
                                try {
                                    // [0] means can move [1] means there is a goblin
                                    boolean[] tempArray = grid.checkMoveSpace(human3, grid, charAndDir[1]);
                                    // If the Human is moving and there is nothing there
                                    if (tempArray[0] && !tempArray[1]) {
                                        grid.removeCharacterIcon(human3);
                                        grid.removeContainedCharacterClass(human3);
                                        grid.setCharacterAtCoords(human3.getCoords(), null);
                                        human3.move(charAndDir[1]);
                                        grid.setNewCharLocation(human3);
                                        grid.setNewContainedCharacterClass(human3);
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Goblin there
                                    else if (tempArray[0] & tempArray[1]) {
                                        System.out.println("Time to fight!");
                                        grid.removeCharacterIcon(human3);
                                        grid.removeContainedCharacterClass(human3);
                                        grid.setCharacterAtCoords(human3.getCoords(), null);
                                        human3.move(charAndDir[1]);
                                        fightingGoblin = (Goblin) grid.getCharacterAtCoords(human3.getCoords());
                                        fightingHuman = human3;
                                        needToFight = true;
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Human there
                                    else if (!tempArray[0] && !tempArray[1]) {
                                        System.out.println("There's a Human where you want to move!");
                                        charAndDir[1] = getDirectionToMove();
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                    charAndDir[1] = getDirectionToMove();
                                }
                            }
                            if (!needToFight) {
                                userTurn = false;
                                grid.displayGrid();
                            }
                        } else {
                            System.out.print("\nThat human is dead! Please choose another character\n");
                            displayMoveInstructions();
                        }
                    }
                    // User decides on Human 4
                    else if (charAndDir[0].matches("human 4")) {
                        boolean canMove = false;
                        if (grid.getHumans().contains(human4)) {
                            while (!canMove) {
                                try {
                                    // [0] means can move [1] means there is a goblin
                                    boolean[] tempArray = grid.checkMoveSpace(human4, grid, charAndDir[1]);
                                    // If the Human is moving and there is nothing there
                                    if (tempArray[0] && !tempArray[1]) {
                                        grid.removeCharacterIcon(human4);
                                        grid.removeContainedCharacterClass(human4);
                                        grid.setCharacterAtCoords(human4.getCoords(), null);
                                        human4.move(charAndDir[1]);
                                        grid.setNewCharLocation(human4);
                                        grid.setNewContainedCharacterClass(human4);
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Goblin there
                                    else if (tempArray[0] & tempArray[1]) {
                                        System.out.println("Time to fight!");
                                        grid.removeCharacterIcon(human4);
                                        grid.removeContainedCharacterClass(human4);
                                        grid.setCharacterAtCoords(human4.getCoords(), null);
                                        human4.move(charAndDir[1]);
                                        fightingGoblin = (Goblin) grid.getCharacterAtCoords(human4.getCoords());
                                        fightingHuman = human4;
                                        needToFight = true;
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Human there
                                    else if (!tempArray[0] && !tempArray[1]) {
                                        System.out.println("There's a Human where you want to move!");
                                        charAndDir[1] = getDirectionToMove();
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                    charAndDir[1] = getDirectionToMove();
                                }
                            }
                            if (!needToFight) {
                                userTurn = false;
                                grid.displayGrid();
                            }
                        } else {
                            System.out.print("\nThat human is dead! Please choose another");
                            displayMoveInstructions();
                        }
                    }
                    // User decides on Human 5
                    else if (charAndDir[0].matches("human 5")) {
                        boolean canMove = false;
                        if (grid.getHumans().contains(human5)) {
                            while (!canMove) {
                                try {
                                    // [0] means can move [1] means there is a goblin
                                    boolean[] tempArray = grid.checkMoveSpace(human5, grid, charAndDir[1]);
                                    // If the Human is moving and there is nothing there
                                    if (tempArray[0] && !tempArray[1]) {
                                        grid.removeCharacterIcon(human5);
                                        grid.removeContainedCharacterClass(human5);
                                        grid.setCharacterAtCoords(human5.getCoords(), null);
                                        human5.move(charAndDir[1]);
                                        grid.setNewCharLocation(human5);
                                        grid.setNewContainedCharacterClass(human5);
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Goblin there
                                    else if (tempArray[0] & tempArray[1]) {
                                        System.out.println("Time to fight!");
                                        grid.removeCharacterIcon(human5);
                                        grid.removeContainedCharacterClass(human5);
                                        grid.setCharacterAtCoords(human5.getCoords(), null);
                                        human5.move(charAndDir[1]);
                                        fightingGoblin = (Goblin) grid.getCharacterAtCoords(human5.getCoords());
                                        fightingHuman = human5;
                                        needToFight = true;
                                        canMove = true;
                                    }
                                    // If the Human is moving and there is a Human there
                                    else if (!tempArray[0] && !tempArray[1]) {
                                        System.out.println("There's a Human where you want to move!");
                                        charAndDir[1] = getDirectionToMove();
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                    charAndDir[1] = getDirectionToMove();
                                }
                            }
                            if (!needToFight) {
                                userTurn = false;
                                grid.displayGrid();
                            }
                        } else {
                            System.out.print("\nThat human is dead! Please choose another character\n");
                            displayMoveInstructions();
                        }
                    }
                }
            }
            // If it is the computer's turn
            else {
                String[] charAndDir = new String[2];
                // 1 = goblin 1, 2 = goblin 2... 5 = goblin 5
                int charChoice;
                // 1 = n, 2 = w, 3 = s, 4 = e
                int dirChoice;

                charChoice = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);

                charAndDir[0] = setComputerCharacterChoice(charChoice);
                charAndDir[1] = setComputerDirectionChoice(dirChoice);

                System.out.println("Character: " + "\033[0;1m" + charAndDir[0] + "\033[0;0m" + "\nDirection: " + "\033[0;1m" + charAndDir[1] + "\033[0;0m");

                // Goblin 1 is decided to move
                if (charChoice == 1) {
                    boolean canMove = false;
                    if (grid.getGoblins().contains(goblin1)) {
                        while (!canMove) {
                            try {
                                // [0] means can move [1] means there is a Human
                                boolean[] tempArray = grid.checkMoveSpace(goblin1, grid, charAndDir[1]);
                                // If the Computer moves the Goblin onto an empty space
                                if (tempArray[0] && !tempArray[1]) {
                                    grid.removeCharacterIcon(goblin1);
                                    grid.removeContainedCharacterClass(goblin1);
                                    grid.setCharacterAtCoords(goblin1.getCoords(), null);
                                    goblin1.move(charAndDir[1]);
                                    grid.setNewCharLocation(goblin1);
                                    grid.setNewContainedCharacterClass(goblin1);
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space with a Human
                                else if (tempArray[0] & tempArray[1]) {
                                    System.out.println("Time to fight!");
                                    grid.removeCharacterIcon(goblin1);
                                    grid.removeContainedCharacterClass(goblin1);
                                    grid.setCharacterAtCoords(goblin1.getCoords(), null);
                                    goblin1.move(charAndDir[1]);
                                    fightingGoblin = goblin1;
                                    fightingHuman = (Human) grid.getCharacterAtCoords(goblin1.getCoords());
                                    needToFight = true;
                                    canMove = true;
                                }
                                // If the Computer moves the Goblin onto a space where a goblin already is
                                else if (!tempArray[0] && !tempArray[1]) {
                                    dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                    charAndDir[1] = setComputerDirectionChoice(dirChoice);
                                }
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                                dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                charAndDir[1] = setComputerDirectionChoice(dirChoice);
                            }
                        }
                        if (!needToFight) {
                            userTurn = true;
                            grid.displayGrid();
                        }
                    } else {
                        charChoice = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                    }
                }
                // Goblin 2
                if (charChoice == 2) {
                    boolean canMove = false;
                    if (grid.getGoblins().contains(goblin2)) {
                        while (!canMove) {
                            try {
                                // [0] means can move [1] means there is a Human
                                boolean[] tempArray = grid.checkMoveSpace(goblin2, grid, charAndDir[1]);
                                // If the Computer moves the Goblin onto an empty space
                                if (tempArray[0] && !tempArray[1]) {
                                    grid.removeCharacterIcon(goblin2);
                                    grid.removeContainedCharacterClass(goblin2);
                                    grid.setCharacterAtCoords(goblin2.getCoords(), null);
                                    goblin2.move(charAndDir[1]);
                                    grid.setNewCharLocation(goblin2);
                                    grid.setNewContainedCharacterClass(goblin2);
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space with a Human
                                else if (tempArray[0] & tempArray[1]) {
                                    System.out.println("Time to fight!");
                                    grid.removeCharacterIcon(goblin2);
                                    grid.removeContainedCharacterClass(goblin2);
                                    grid.setCharacterAtCoords(goblin2.getCoords(), null);
                                    goblin2.move(charAndDir[1]);
                                    fightingGoblin = goblin2;
                                    fightingHuman = (Human) grid.getCharacterAtCoords(goblin2.getCoords());
                                    needToFight = true;
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space where a Goblin already is
                                else if (!tempArray[1]) {
                                    dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                    charAndDir[1] = setComputerDirectionChoice(dirChoice);
                                }
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                                dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                charAndDir[1] = setComputerDirectionChoice(dirChoice);
                            }
                        }
                        if (!needToFight) {
                            userTurn = true;
                            grid.displayGrid();
                        }
                    }
                    // If the computer chooses Goblin 2 and it has no health
                    else {
                        charChoice = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                    }
                }
                // Goblin 3
                if (charChoice == 3) {
                    boolean canMove = false;
                    if (grid.getGoblins().contains(goblin3)) {
                        while (!canMove) {
                            try {
                                // [0] means can move [1] means there is a Human
                                boolean[] tempArray = grid.checkMoveSpace(goblin3, grid, charAndDir[1]);
                                // If the Computer moves the Goblin onto an empty space
                                if (tempArray[0] && !tempArray[1]) {
                                    grid.removeCharacterIcon(goblin3);
                                    grid.removeContainedCharacterClass(goblin3);
                                    grid.setCharacterAtCoords(goblin3.getCoords(), null);
                                    goblin3.move(charAndDir[1]);
                                    grid.setNewCharLocation(goblin3);
                                    grid.setNewContainedCharacterClass(goblin3);
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space with a Human
                                else if (tempArray[0] & tempArray[1]) {
                                    System.out.println("Time to fight!");
                                    grid.removeCharacterIcon(goblin3);
                                    grid.removeContainedCharacterClass(goblin3);
                                    grid.setCharacterAtCoords(goblin3.getCoords(), null);
                                    goblin3.move(charAndDir[1]);
                                    fightingGoblin = goblin3;
                                    fightingHuman = (Human) grid.getCharacterAtCoords(goblin3.getCoords());
                                    needToFight = true;
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space where a Goblin already is
                                else if (!tempArray[1]) {
                                    dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                    charAndDir[1] = setComputerDirectionChoice(dirChoice);
                                }
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                                dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                charAndDir[1] = setComputerDirectionChoice(dirChoice);
                            }
                        }
                        if (!needToFight) {
                            userTurn = true;
                            grid.displayGrid();
                        }
                    }
                    // If the computer chooses Goblin 3 and it has no health
                    else {
                        charChoice = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                    }
                }
                // Goblin 4
                if (charChoice == 4) {
                    boolean canMove = false;
                    if (grid.getGoblins().contains(goblin4)) {
                        while (!canMove) {
                            try {
                                // [0] means can move [1] means there is a Human
                                boolean[] tempArray = grid.checkMoveSpace(goblin4, grid, charAndDir[1]);
                                // If the Computer moves the Goblin onto an empty space
                                if (tempArray[0] && !tempArray[1]) {
                                    grid.removeCharacterIcon(goblin4);
                                    grid.removeContainedCharacterClass(goblin4);
                                    grid.setCharacterAtCoords(goblin4.getCoords(), null);
                                    goblin4.move(charAndDir[1]);
                                    grid.setNewCharLocation(goblin4);
                                    grid.setNewContainedCharacterClass(goblin4);
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space with a Human
                                else if (tempArray[0] & tempArray[1]) {
                                    System.out.println("Time to fight!");
                                    grid.removeCharacterIcon(goblin4);
                                    grid.removeContainedCharacterClass(goblin4);
                                    grid.setCharacterAtCoords(goblin4.getCoords(), null);
                                    goblin4.move(charAndDir[1]);
                                    fightingGoblin = goblin4;
                                    fightingHuman = (Human) grid.getCharacterAtCoords(goblin4.getCoords());
                                    needToFight = true;
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space where a Goblin already is
                                else if (!tempArray[1]) {
                                    dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                    charAndDir[1] = setComputerDirectionChoice(dirChoice);
                                }
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                                dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                charAndDir[1] = setComputerDirectionChoice(dirChoice);
                            }
                        }
                        if (!needToFight) {
                            userTurn = true;
                            grid.displayGrid();
                        }
                    }
                    // If the computer chooses Goblin 4 and it has no health
                    else {
                        charChoice = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                    }
                }
                // Goblin 5
                if (charChoice == 5) {
                    boolean canMove = false;
                    if (grid.getGoblins().contains(goblin5)) {
                        while (!canMove) {
                            try {
                                // [0] means can move [1] means there is a Human
                                boolean[] tempArray = grid.checkMoveSpace(goblin5, grid, charAndDir[1]);
                                // If the Computer moves the Goblin onto an empty space
                                if (tempArray[0] && !tempArray[1]) {
                                    grid.removeCharacterIcon(goblin5);
                                    grid.removeContainedCharacterClass(goblin5);
                                    grid.setCharacterAtCoords(goblin5.getCoords(), null);
                                    grid.setCharacterAtCoords(goblin5.getCoords(), null);
                                    goblin5.move(charAndDir[1]);
                                    grid.setNewCharLocation(goblin5);
                                    grid.setNewContainedCharacterClass(goblin5);
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space with a Human
                                else if (tempArray[0] & tempArray[1]) {
                                    System.out.println("Time to fight!");
                                    grid.removeCharacterIcon(goblin5);
                                    grid.removeContainedCharacterClass(goblin5);
                                    grid.setCharacterAtCoords(goblin5.getCoords(), null);
                                    goblin5.move(charAndDir[1]);
                                    fightingGoblin = goblin5;
                                    fightingHuman = (Human) grid.getCharacterAtCoords(goblin5.getCoords());
                                    needToFight = true;
                                    canMove = true;
                                }
                                // If the Computer moves a Goblin onto a space where a Goblin already is
                                else if (!tempArray[1]) {
                                    dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                    charAndDir[1] = setComputerDirectionChoice(dirChoice);
                                }
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                                dirChoice = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                                charAndDir[1] = setComputerDirectionChoice(dirChoice);
                            }
                        }
                        if (!needToFight) {
                            userTurn = true;
                            grid.displayGrid();
                        }
                    }
                    // If the computer chooses Goblin 4 and it has no health
                    else {
                        charChoice = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
                    }
                }
            }
        }
    }
    private void displayCombat(Human hum, Goblin gob) {
        Scanner scanner = new Scanner(System.in);
        boolean stillFighting = true;
        int input = 0;
        int humanInit;
        int goblinInt;
        // If turn = 0, Humans turns. If turn = 1, Goblins turn
        int turn = 0;
        // If won = 0, Human won. If won = 1, Goblin won
        int won = -1;

        System.out.print(hum.getName() + "has engaged in combat with " + gob.getName() + "!");
        System.out.print("\nTime to roll for initative...");
        System.out.print("\nType 1 to begin roll for initative\n");
        while (input != 1) {
            try {
                input = scanner.nextInt();
                if (input != 1) {
                    System.out.print("Please enter a 1");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must enter a digit");
            }
        }
        humanInit = (int) Math.floor(Math.random() * (20 - 1 + 1) + 1);
        System.out.print("\n" + hum.getName() + " rolled a " + humanInit);
        System.out.print("\n" + gob.getName() + " is now rolling for initiative");
        goblinInt = (int) Math.floor(Math.random() * (20 - 1 + 1) + 1);
        System.out.print("\n" + gob.getName() + " rolled a " + goblinInt);
        if (goblinInt > humanInit) {
            turn = 1;
        }

        while (stillFighting) {
            // Logic for if it is the Humans turn
            if (turn == 0) {
                // Prints out that the human attacks for their strength
                System.out.print("\n" + hum.getName() + "attacks for " + hum.getStrength());
                // Sets the Goblins health to be what their health was - the strength of the human
                gob.setHealth(gob.getHealth() - hum.getStrength());
                // If Hunan defeats Goblin
                if (gob.getHealth() <= 0) {
                    won = 0;
                    stillFighting = false;
                }
                turn = 1;
            }
            // Logic for if it is the Goblins turn
            else {
                // Prints out that the goblin attacks for their strength
                System.out.print("\n" + gob.getName() + " attacks for " + gob.getStrength());
                // Sets the Human's health to be what their health was - the strength of the goblin
                hum.setHealth((hum.getHealth() - gob.getStrength()));
                // If Goblin defeats Human
                if (hum.getHealth() <= 0) {
                    won = 1;
                    stillFighting = false;
                }
                turn = 0;
            }
        }
        // If the Goblin wins
        if (won == 1) {
            // Prints out that the goblin defeated the Human
            System.out.print("\n" + gob.getName() + " defeated " + hum.getName() + "\n");
            // 3 lines = updates grid with character class, sets the goblin's new location, and sets the character at those coordinates to be the goblin
            grid.setNewContainedCharacterClass(gob);
            grid.setNewCharLocation(gob);
            grid.setCharacterAtCoords(gob.getCoords(), gob);
            // Reduces the humanLeft counter by 1 since a human died
            humansLeft--;
            // Adds the dead human to a list that stores dead human names
            deadHumans.add(hum.getName());
            // Removes the dead human from the list containing alive humans
            grid.removeHumanFromArray(hum);
            fightingHuman = null;
            fightingGoblin = null;
            grid.displayGrid();
            userTurn = !userTurn;
            needToFight = false;
        }
        // If the Human wins
        else {
            System.out.print("\n" + hum.getName() + " defeated " + gob.getName() + "\n");
            grid.setNewContainedCharacterClass(hum);
            grid.setNewCharLocation(hum);
            grid.setCharacterAtCoords(hum.getCoords(), hum);
            goblinsLeft--;
            grid.removeGoblinFromArray(gob);
            fightingHuman = null;
            fightingGoblin = null;
            grid.displayGrid();
            userTurn = !userTurn;
            needToFight = false;
        }
    }
    private void displayEndText() {
        String input = "";
        // If the Humans won
        if (whoWon == 0) {
            System.out.print("\nAfter a long, hard battle - the Humans were able to overcome the Goblin horde.");
            if (humansLeft != 5) {
                System.out.print("\nLives were lost. We will never forget their names as they gave the ultimate sacrifice.");
                System.out.print("\nListed below are the Humans that gave their lives in the fight against Evil");
                for (String deadHuman : deadHumans) {
                    System.out.print("\n" + deadHuman);
                }
            }
            System.out.print("\n\nThank you for playing \"Humans vs. Goblins\".");
            System.out.print("\nWould you like to play again? (y or n)");
            try {
                input = getUserInput().toLowerCase(Locale.ROOT);
                if (input.matches("y")) {
                    generateGame();

                } else if (input.matches("n")) {
                    System.out.print("\nHope to see you soon!");
                    System.exit(0);
                } else {
                    System.out.print("\nPlease enter a \"y\" or a \"n\"");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a character");
            }
        }
        // If the Goblins won
        else {
            System.out.print("\nYou put up a valiantly fight, however; the Goblins prevailed in the end.");
            if (humansLeft != 5) {
                System.out.print("\nLives were lost. We will never forget their names as they gave the ultimate sacrifice.");
                System.out.print("\nListed below are the Humans that gave their lives in the fight against Evil");
                for (int i = 0; i < 5; i++) {
                    System.out.print("\n" + deadHumans.get(i));
                }
            }
            System.out.print("\n\nThank you for playing \"Humans vs. Goblins\".");
            System.out.print("\nWould you like to play again? (y or n)");
            try {
                input = getUserInput().toLowerCase(Locale.ROOT);
                if (input.matches("y")) {
                    generateGame();
                } else if (input.matches("n")) {
                    System.out.print("\nHope to see you soon!");
                    play = false;
                    System.exit(0);
                } else {
                    System.out.print("\nPlease enter a \"y\" or a \"n\"");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a character");
            }
        }
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        try {
            input = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input");
        }

        return input;
    }
    private String getDirectionToMove() {
        boolean validDir = false;
        String chosenDir = "";
        System.out.println("Which direction would you like to move?");
        while (!validDir) {
            chosenDir = getUserInput().toLowerCase(Locale.ROOT);
            if (chosenDir.matches("n") || chosenDir.matches("e") || chosenDir.matches("w") || chosenDir.matches("s")) {
                validDir = true;
            } else {
                System.out.println("That is not a valid direction!");
            }
        }

        return chosenDir;
    }
    private String getCharacterToMove() {
        boolean validChar = false;
        String chosenChar = "";
        System.out.println("Which character would you like to move?");
        while (!validChar) {
            chosenChar = getUserInput().toLowerCase(Locale.ROOT);
            if (chosenChar.matches("human 1") || chosenChar.matches("human 2") || chosenChar.matches("human 3") ||
                    chosenChar.matches("human 4") || chosenChar.matches("human 5")) {
                validChar = true;
            } else if (chosenChar.matches("goblin 1") || chosenChar.matches("goblin 2") || chosenChar.matches("goblin 3") ||
                    chosenChar.matches("goblin 4") || chosenChar.matches("goblin 5")) {
                validChar = true;
            } else {
                System.out.println("That is not a character in game!");
            }
        }

        return chosenChar;
    }

    private String setComputerCharacterChoice(int i) {
        String charChoice = switch (i) {
            case 1 -> "goblin 1";
            case 2 -> "goblin 2";
            case 3 -> "goblin 3";
            case 4 -> "goblin 4";
            case 5 -> "goblin 5";
            default -> "";
            // Sets the character String object in charAndDir depending on the number generated between 1 - 5
        };
        return charChoice;
    }
    private String setComputerDirectionChoice(int i) {
        String dirChoice = switch (i) {
            case 1 -> "n";
            case 2 -> "w";
            case 3 -> "s";
            case 4 -> "e";
            default -> "";
            // Sets the direction String object in charAndDir depending on the number generated between 1 - 4
        };
        return dirChoice;
    }


    private void generateGame() {
        needToMove = true;
        needToFight = false;
        deadHumans = new ArrayList<>();
        whoWon = -1;
        humansLeft = 5;
        goblinsLeft = 5;
        play = true;
        showEnd = false;
        userTurn = true;
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
        grid = new LandGrid(human1, human2, human3, human4, human5, goblin1, goblin2, goblin3, goblin4, goblin5);
    }
}
