public class Main {
    public static void main(String[] args) {
        DragonCave dragonCave = new DragonCave();
        dragonCave.run();
    }
}

/*public class Main {
    public static void main(String[] args) {
        // Creates a boolean to check whether the answer has been given
        boolean answerGiven = false;
        // Creates an integer variable to hold the user's answer
        int answer = 0;
        // Creates a Scanner object to read the user's input
        Scanner inputRead = new Scanner(System.in);
        // Creates an Integer to hold the input
        int inputAsInt = 0;
        // Outputs the dialogue for the story
        System.out.println("You are in a land full of dragons. In front of you," +
                "\nyou see two caves. In one cave, the dragon is friendly" +
                "\nand will share his treasure with you. The other dragon" +
                "\nis greedy and hungry and will eat you on sight." +
                "\nWhich cave do you go into? (1 or 2)");
        // While loop to continously check for the user's input until a valid input is given
        while (answerGiven == false) {
            // Stores the user's input as "answer" variable
            try {
                // Converts the inputAsString to inputAsInt
                inputAsInt = inputRead.nextInt();
                // If the user's input is valid, it sets the answerGiven boolean to true, ending the while loop
                if (validChoice(inputAsInt)) {
                    // answer is set to the user's input
                    answer = inputAsInt;
                    // Updates that the answer has been given
                    answerGiven = true;
                }
                // If the user does not input a 1 or a 2
                else {
                    System.out.println("Please enter a valid choice: 1 or 2");
                }
            }
            // If the input is not a number
            catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                inputRead.nextLine();
            }

        }
        // Prints the user's answer in bold
        System.out.println("\n\n" + "\u001B[1m" + answer + "\033[0;0m");
        // If the user decides to enter the hungry dragon cave
        if (answer == 1) {
            System.out.println("\n\nYou approach the cave..." +
                    "\nIt is dark and spooky..." +
                    "\nA large dragon jump out in front of you! He opens his jaws and..." +
                    "\nGobbles you down in one bite!");
            System.exit(0);
        }
        // If the user decides to enter the friendly dragons cave
        else {
            System.out.println("\n\nYou approach the cave..." +
                    "\nIt is dark and spooky..." +
                    "\nA large dragon jumps out in front of you! He opens his jaws and..." +
                    "\nLets out a large sigh, indicating it has been a long time since someone has visited." +
                    "\nThe dragon motions for you to follow and leads you to a large room" +
                    "\nFull of more gold, food, and drinks than one could consume in a lifetime!");
            System.exit(0);
        }
    }

    public static boolean validChoice(int choice) {
        return choice == 1 || choice == 2;
    }
}*/
