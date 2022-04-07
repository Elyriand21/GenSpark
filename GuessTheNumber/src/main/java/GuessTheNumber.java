import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumber {
    private String name;
    private int inputAsInt;
    private String inputAsString;
    private int answer;

    public GuessTheNumber() {
        answer = 0;
        name = "";
        inputAsInt = 0;
        inputAsString = "";
    }

    public void run() {
        Scanner masterInput = new Scanner(System.in);
        // Displays the instructions to the user
        displayGreeting();
        // Receives the user's input as name and stores as name variable
        name = getNameInput(masterInput);
        boolean wantsToPlay = true;
        while (wantsToPlay) {
            wantsToPlay = play(masterInput, name);
        }
        print("Thank you for playing " + name + ". Hope to see you soon!");
    }

    // Displays the greeting to the user
    private void displayGreeting() {
        print("Hello! What is your name?\n\n");
    }
    
    private boolean play(Scanner input, String name) {
        boolean validAnswer;
        // Creates an integer value that determines how many tries the player has left
        int tries = 6;
        // Creates the integer value that the player is trying to guess
        int numberToGuess = (int) Math.floor(Math.random() * (20) + 1);
        int userGuess = 0;
        // Displays the instructions
        print("\n\nWell, " + "\033[0;1m" + name + "\033[0;0m" + ", I am thinking of a number between " +
                "1 and 20.");
        // While loop that activates if the player wants to play
        while (tries > 0) {
            // DEBUG TOOL
            //System.out.println("The number to guess is: " + numberToGuess);

            // Creates the second piece of dialogue
            print("\nTake a guess.\n\n");
            try {
                userGuess = input.nextInt();
                if (!isBetweenOneAndTwenty(userGuess)) {
                    throw new IllegalArgumentException("You must choose a number between 1 and 20");
                }
                if (isLessThan(userGuess, numberToGuess)) {
                    print("Your guess is too low");
                }
                if (isGreaterThan(userGuess, numberToGuess)) {
                    print("Your guess is too high");
                }
            } catch (InputMismatchException e) {
                print("Your guess must be an integer");
            } catch (IllegalArgumentException e) {
                print("Something weird happened...");
                e.getMessage();
            }

            input.nextLine();
            tries--;
            if (guessIsCorrect(userGuess, numberToGuess)) {
                print("\n\nGood job, " + "\033[0;1m" + name + "\033[0;0m" + "! You guessed my number in " + tries + " guesses!" +
                        "\nWould you like to play again? (y or n)");
                String playAgain = input.nextLine();
                return !playAgain.equals("n");
            }
        }
        print("\n\nSorry " + "\033[0;1m" + name + "\033[0;0m" + ". The number I was thinking of was " + numberToGuess);
        print("\nWould you like to play again? (y or n)");
        String playAgain = input.nextLine();
        return !playAgain.equals("n");
    }

    private String getNameInput(Scanner inputRead) {
        // Allows for user input and stores as name variable
        boolean validName = false;
        while (!validName) {
            try {
                inputAsString = inputRead.nextLine();
                if (inputAsString.matches("[a-zA-z]+")) {
                    name = inputAsString;
                    validName = true;
                } else {
                    throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("Please enter a valid name");
            }
        }
        return name;
    }

    private int getAnswerInput(Scanner inputRead) {
        boolean validAnswer;
        validAnswer = false;
        // While loop to ensure player enters a number
        while (!validAnswer) {
            try {
                inputAsString = inputRead.nextLine();
                inputAsInt = Integer.parseInt(inputAsString);
                answer = inputAsInt;
                validAnswer = true;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numver");
            }
        }
        return answer;
    }

    private boolean isGreaterThan(int guess, int correct) {
        return guess > correct;
    }

    private boolean isLessThan(int guess, int correct) {
        return guess < correct;
    }

    private boolean guessIsCorrect(int guess, int correct) {
        return guess == correct;
    }

    private boolean isBetweenOneAndTwenty(int guess) {
        return guess >= 0 && guess <= 20;
    }

    // GET and SET methods
    // Method that returns the name of the user
    public String getName() {
        return name;
    }

    // Method that returns the answer the user input
    public int getAnswer() {
        return answer;
    }

    // Method that sets the name of the user
    public void setName(String newName) {
        this.name = newName;
    }

    // Method that sets the user's answer
    public void setAnswer(int newAnswer) {
        this.answer = newAnswer;
    }

    // Method to simplify printing to console
    private void print(String str) {
        System.out.println(str);
    }
}