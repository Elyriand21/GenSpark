import java.util.InputMismatchException;
import java.util.Scanner;

public class DragonCave {

    // Creates an integer variable to hold the user's answer
    int answer = 0;
    // Creates an Integer to hold the input
    int inputAsInt = 0;

    public DragonCave(){
        answer = 0;
    }

    public void run() {
        // Creates a Scanner object to read the user's input
        Scanner inputRead = new Scanner(System.in);
        // Outputs the first piece of dialogue
        firstDialogue();
        // Gets the input of the user and stores in answer variable
        answer = getInput(inputRead);
        showGameText();

    }

    // Method that displays the intro dialogue
    private void firstDialogue() {
        // Creates the intro piece of dialogue
        System.out.println("You are in a land full of dragons. In front of you," +
                "\nyou see two caves. In one cave, the dragon is friendly" +
                "\nand will share his treasure with you. The other dragon" +
                "\nis greedy and hungry and will eat you on sight." +
                "\nWhich cave do you go into? (1 or 2)");
    }
    // Method that receives the user's input
    private int getInput(Scanner input){
        // Creates a boolean to check whether the answer has been given
        boolean answerGiven = false;
        while (answerGiven == false) {
            try {
                // Converts the inputAsString to inputAsInt
                inputAsInt = input.nextInt();
                // If the user's input is valid, it sets the answerGiven boolean to true, ending the while loop
                if (inputAsInt == 1 || inputAsInt == 2) {
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
                input.nextLine();
            }

        }
        return answer;
    }
    // Method that displays the game text
    private void showGameText(){
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

    // GET and SET methods
    // Method that returns the user's answer
    public int getAnswer(){
        return answer;
    }
    // Method the sets the user's answer
    public void setAnswer(int userAnswer){
        this.answer = userAnswer;
    }
}
