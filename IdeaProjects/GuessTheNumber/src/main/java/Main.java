import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creates a scanner that reads the user's input
        Scanner input = new Scanner(System.in);
        // Creates a String that holds the user's name
        String name;
        // Creates an Integer that holds the user's answer
        int answer;
        // Creates a boolean to determine if the user wants to play
        boolean play = true;

        // Creates the first piece of dialogue
        System.out.println("Hello! What is your name?\n\n");
        // Allows for user input and stores as name variable
        name = input.next();

        // While loop that activates if the player wants to play
        while (play) {
            // Creates an integer value that determines how many tries the player has left
            int tries = 6;
            // Creates the integer value that the player is trying to guess
            int numberToGuess = (int) Math.floor(Math.random() * (20) + 1);
            // REMOVE ONCE FINISHED
            System.out.println("The number to guess is: " + numberToGuess);

            // Creates the second piece of dialogue
            System.out.println("\n\nWell, " + "\033[0;1m" + name + "\033[0;0m" + ", I am thinking of a number between " +
                    "1 and 20." +
                    "\nTake a guess.\n\n");

            answer = input.nextInt();
            // If first guess is correct
            if (answer == numberToGuess) {
                tries = 0;
                System.out.println("\n\nGood job, " + "\033[0;1m" + name + "\033[0;0m" + "! You guessed my number in 1 guess!" +
                        "\nWould you like to play again? (y or n)");
                // If the user decides to not play again
                if (input.next().matches("n")) {
                    System.out.println("\033[0;1m" + "n" + "\033[0;0m");
                    play = false;
                }
                else{
                    System.out.println("\033[0;1m" + "y" + "\033[0;0m");
                }
            }
            // If first guess is incorrect
            if (answer != numberToGuess && tries == 6) {
                // Updates tries to 5
                tries = tries - 1;
                // If the first guess is too high
                if (answer > numberToGuess) {
                    System.out.println("\n\nYour guess is too high." +
                            "\nTake a guess.\n\n");
                }
                // If the first guess is too low
                if (answer < numberToGuess) {
                    System.out.println("\n\nYour guess is too low" +
                            "\nTake a guess.\n\n");
                }
                answer = input.nextInt();
            }
            // If second guess is correct
            if (answer == numberToGuess && tries == 5) {
                System.out.println("\n\nGood job, " + "\033[0;1m" + name + "\033[0;0m" + "! You guessed my number in 2 guesses!" +
                        "\nWould you like to play again? (y or n)");
                // If the user decides to not play again
                if (input.next().matches("n")) {
                    System.out.println("\033[0;1m" + "n" + "\033[0;0m");
                    play = false;
                }
                else{
                    System.out.println("\033[0;1m" + "y" + "\033[0;0m");
                }
            }
            // If second guess is incorrect
            if (answer != numberToGuess && tries == 5) {
                // Updates tries to 4
                tries = tries - 1;
                // If the second guess is too high
                if (answer > numberToGuess) {
                    System.out.println("\n\nYour guess is too high." +
                            "\nTake a guess.\n\n");
                }
                // If the second guess is too low
                if (answer < numberToGuess) {
                    System.out.println("\n\nYour guess is too low" +
                            "\nTake a guess.\n\n");
                }
                answer = input.nextInt();
            }

            // If third guess is correct
            if (answer == numberToGuess && tries == 4) {
                System.out.println("\n\nGood job, " + "\033[0;1m" + name + "\033[0;0m" + "! You guessed my number in 3 guesses!" +
                        "\nWould you like to play again? (y or n)");
                // If the user decides to not play again
                if (input.next().matches("n")) {
                    System.out.println("\033[0;1m" + "n" + "\033[0;0m");
                    play = false;
                }
                else{
                    System.out.println("\033[0;1m" + "y" + "\033[0;0m");
                }
            }
            // If third guess is incorrect
            if (answer != numberToGuess && tries == 4) {
                // Updates tries to 3
                tries = tries - 1;
                // If the second guess is too high
                if (answer > numberToGuess) {
                    System.out.println("\n\nYour guess is too high." +
                            "\nTake a guess.\n\n");
                }
                // If the second guess is too low
                if (answer < numberToGuess) {
                    System.out.println("\n\nYour guess is too low" +
                            "\nTake a guess.\n\n");
                }
                answer = input.nextInt();
            }

            // If fourth guess is correct
            if (answer == numberToGuess && tries == 3) {
                System.out.println("\n\nGood job, " + "\033[0;1m" + name + "\033[0;0m" + "! You guessed my number in 4 guesses!" +
                        "\nWould you like to play again? (y or n)");
                // If the user decides to not play again
                if (input.next().matches("n")) {
                    System.out.println("\033[0;1m" + "n" + "\033[0;0m");
                    play = false;
                }
                else{
                    System.out.println("\033[0;1m" + "y" + "\033[0;0m");
                }
            }
            // If fourth guess is incorrect
            if (answer != numberToGuess && tries == 3) {
                // Updates tries to 2
                tries = tries - 1;
                // If the second guess is too high
                if (answer > numberToGuess) {
                    System.out.println("\n\nYour guess is too high." +
                            "\nTake a guess.\n\n");
                }
                // If the second guess is too low
                if (answer < numberToGuess) {
                    System.out.println("\n\nYour guess is too low" +
                            "\nTake a guess.\n\n");
                }
                answer = input.nextInt();
            }

            // If fifth guess is correct
            if (answer == numberToGuess && tries == 2) {
                System.out.println("\n\nGood job, " + "\033[0;1m" + name + "\033[0;0m" + "! You guessed my number in 5 guesses!" +
                        "\nWould you like to play again? (y or n)");
                // If the user decides to not play again
                if (input.next().matches("n")) {
                    System.out.println("\033[0;1m" + "n" + "\033[0;0m");
                    play = false;
                }
                else{
                    System.out.println("\033[0;1m" + "y" + "\033[0;0m");
                }
            }
            // If fifth guess is incorrect
            if (answer != numberToGuess && tries == 2) {
                // Updates tries to 1
                tries = tries - 1;
                // If the second guess is too high
                if (answer > numberToGuess) {
                    System.out.println("\n\nYour guess is too high." +
                            "\nTake a guess.\n\n");
                }
                // If the second guess is too low
                if (answer < numberToGuess) {
                    System.out.println("\n\nYour guess is too low" +
                            "\nTake a guess.\n\n");
                }
                answer = input.nextInt();
            }

            // If sixth guess is correct
            if (answer == numberToGuess && tries == 1) {
                System.out.println("\n\nGood job, " + "\033[0;1m" + name + "\033[0;0m" + "! You guessed my number in 6 guesses!" +
                        "\nWould you like to play again? (y or n)");
                // If the user decides to not play again
                if (input.next().matches("n")) {
                    System.out.println("\033[0;1m" + "n" + "\033[0;0m");
                    play = false;
                }
                else{
                    System.out.println("\033[0;1m" + "y" + "\033[0;0m");
                }
            }
            // If sixth guess is incorrect
            if (answer != numberToGuess && tries == 1) {
                // Updates tries to 0
                tries = 0;
                System.out.println("Sorry! The number I was thinking of was " + numberToGuess +
                        "\nThank you for playing! Would you like to play again? (y or n)");
                // If the user decides to not play again
                if (input.next().matches("n")) {
                    System.out.println("\033[0;1m" + "n" + "\033[0;0m");
                    play = false;
                }
                else{
                    System.out.println("\033[0;1m" + "y" + "\033[0;0m");
                }
            }
        }
    }
}