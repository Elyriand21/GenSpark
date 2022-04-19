import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;

public class Hangman {
    int guesses;
    int lettersLeft;
    String missedLetters;
    String wordToGuess;
    String spacesToDisplay = "";
    String head = "";
    String body1 = "";
    String body2 = "";
    String leftArm = "";
    String rightArm = "";
    String leftLeg = "";
    String rightLeg = "";
    ArrayList<String> guessedLetters = new ArrayList<>();
    ArrayList<Character> spaces = new ArrayList<>();
    boolean wordGuessed = false;
    boolean play = true;

    public Hangman() {
        guesses = 0;
        missedLetters = "";
    }

    // Logic to run the game
    public void run() {
        // ACTUAL CODE
        while (play) {
            wordToGuess = generateWord();
            for (int i = 0; i < wordToGuess.length(); i++) {
                spaces.add('_');
            }
            lettersLeft = wordToGuess.length();
            while(!wordGuessed) {
                displayGameInterface();
                evaluate();
            }
            displayEndText();
        }
    }

    // Generates a random word
    private String generateWord() {
        String returnWord = "";
        List<String> wordList = new ArrayList<>();

        try {
            File obj = getResourceFile("words.txt");
            if (!obj.exists()) {
                throw new FileNotFoundException();
            }
            try {
                wordList = Files.readAllLines(Paths.get(obj.getPath()));
            } catch (IOException i) {
                System.out.println("Error has occured");
                return null;
            }

            Random random = new Random();
            return wordList.get(random.nextInt(wordList.size()));


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return returnWord;
    }
    // Displays the game interface
    private void displayGameInterface() {
        updateSpacesToDisplay();

        System.out.println("H A N G M A N" +
                "\n" +
                "\n  +---+" +
                "\n");
        if (head == "") {
            System.out.println("      |");
        }
        else {
            System.out.println("  " + head + "   |");
        }
        if (body1 == "") {
            System.out.println("\n" + "      |");
        }
        else {
            if (leftArm == "/") {
                if (rightArm == "\\") {
                    System.out.println("\n " + leftArm + body1 + rightArm + "  |");
                }
                else{
                    System.out.println("\n " + leftArm + body1 + "   |");
                }
            }
            else {
                System.out.println("\n" + "  " + body1 + "   |");
            }
        }
        if(body2 == ""){
            System.out.println("\n" + "      |");
        }
        else{
            System.out.println("\n " + " " + body2 + "   |");
        }
        if(leftLeg == ""){
            System.out.println("\n" + "      ===");
        }
        else{
            if(rightLeg == "\\"){
                System.out.println("\n " + leftLeg + " " + rightLeg + "  ===");
            }
            else{
                System.out.println("\n " + leftLeg + "    ===");
            }
        }
        System.out.println("\nMissed Letters: " + missedLetters);
        System.out.println("\n" + spacesToDisplay);
        System.out.println("\nGuess a letter.");
    }
    // Gets the user input
    private Character getUserInput() {
        Character input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.next().charAt(0);
        System.out.println("");
        System.out.println("");
        System.out.println("\033[0;1m" + input + "\033[0;0m");
        System.out.println("");
        System.out.println("");

        return input;
    }
    // Evaluates the user input
    private void evaluate() {
        Character ch = getUserInput();
        if(guessedLetters.contains(ch.toString())){
            System.out.println("You have already guessed that letter. Choose again." +
                               "\n\nGuess a letter.");
            evaluate();
        }
        else {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == ch) {
                    spaces.set(i, ch);
                    lettersLeft--;
                }
            }
            if (!spaces.contains(ch)) {
                switch (guesses) {
                    // First guess
                    case 0:
                        head = "O";
                        guesses++;
                        missedLetters += ch;
                        guessedLetters.add(ch.toString());
                        break;
                    // Second guess
                    case 1:
                        body1 = "|";
                        guesses++;
                        missedLetters += ch;
                        guessedLetters.add(ch.toString());
                        break;
                    // Third guess
                    case 2:
                        leftArm = "/";
                        guesses++;
                        missedLetters += ch;
                        guessedLetters.add(ch.toString());
                        break;
                    // Fourth guess
                    case 3:
                        rightArm = "\\";
                        guesses++;
                        missedLetters += ch;
                        guessedLetters.add(ch.toString());
                        break;
                    // Fifth guess
                    case 4:
                        body2 = "|";
                        guesses++;
                        missedLetters += ch;
                        guessedLetters.add(ch.toString());
                        break;
                    // Sixth guess
                    case 5:
                        leftLeg = "/";
                        guesses++;
                        missedLetters += ch;
                        guessedLetters.add(ch.toString());
                        break;
                    // Seventh guess
                    case 6:
                        rightLeg = "\\";
                        guesses++;
                        missedLetters += ch;
                        guessedLetters.add(ch.toString());
                        break;
                }

            } else {
                guessedLetters.add(ch.toString());
            }
        }
        if(lettersLeft == 0){
            wordGuessed = true;
        }
        if(guesses == 7){
            wordGuessed = true;
        }
        updateSpacesToDisplay();
    }
    // Displays the end text depending on if the user guessed the word correctly or not
    private void displayEndText(){
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if(lettersLeft == 0) {
            System.out.println("Yes! The secret word was " + "\"" + wordToGuess + "\"! You have won!");
        }
        else{
            System.out.println("I'm sorry! The secret word was " + "\"" + wordToGuess + "\"");
        }
        System.out.println("Do you want to play again? (yes or no)");
        while(!validInput) {
            try {
                input = scanner.nextLine();
                if (input.matches("yes")) {
                    lettersLeft = 0;
                    missedLetters = "";
                    spaces.clear();
                    guessedLetters.clear();
                    head = "";
                    body1 = "";
                    body2 = "";
                    leftArm = "";
                    rightArm = "";
                    leftLeg = "";
                    rightLeg = "";
                    wordGuessed = false;
                    validInput = true;
                }
                else {
                    play = false;
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter yes or no.");
                input = scanner.nextLine();
            }
        }

    }

    // Locates the file that contains the list of words
    private File getResourceFile(final String filename) {
        URL url = this.getClass().getClassLoader().getResource(filename);

        File obj = new File(url.getFile());

        return obj;
    }
    // Updates the displayed spaces
    private void updateSpacesToDisplay() {
        spacesToDisplay = "";
        for (int i = 0; i < spaces.size(); i++) {
            if (spaces.get(i) == '_') {
                spacesToDisplay += "_";
            } else {
                spacesToDisplay += spaces.get(i);
            }
        }
    }

    // GETTERS
    public String getWordToGuess() {
        return wordToGuess;
    }
    public String getMissedLetters() {
        return missedLetters;
    }
    public int getLettersLeft(){
        return lettersLeft;
    }
    //SETTERS
    public void setWordToGuess(String str) {
        wordToGuess = str;
    }
    public void setMissedLetters(String b) {
        missedLetters = b;
    }
    public void setLettersLeft(int let){
        lettersLeft = let;
    }
}