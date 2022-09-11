import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HangmanUpdated {
    int guesses;
    int lettersLeft;
    int state;
    int type;
    int indx;
    int highScoreScore;
    String missedLetters;
    String wordToGuess;
    String highScoreName;
    StringBuilder spacesToDisplay;
    ArrayList<String> guessedLetters;
    List<Character> wordAsList;
    boolean wordGuessed;
    boolean play;
    boolean containsCharacter;
    boolean newGame;
    Path scoresPath;
    public HangmanUpdated() {
        generateGame();
    }

    // Logic to run the game
    public void run() {
        // ACTUAL CODE
        while (play) {
            if (newGame) {
                wordToGuess = generateWord();
                //System.out.println("Generated Word: " + wordToGuess);
                lettersLeft = wordToGuess.length();
                setSpaces();
                newGame = false;
            } else {
                writeToFile();
                type = 1;
                displayGameInterface();
                evaluate();
                if (wordGuessed) {
                    displayEndText();
                }
            }
        }
    }

    // Generates a random word
    private String generateWord() {
        String returnWord = "";
        List<String> wordList;

        try {
            File obj = getResourceFile("words.txt");
            if (!obj.exists()) {
                throw new FileNotFoundException();
            }
            try {
                wordList = Files.readAllLines(Paths.get(obj.getPath()));
            } catch (IOException i) {
                System.out.println("Error has occured while trying to read the lines in the file.");
                return null;
            }

            Random random = new Random();
            returnWord = wordList.get(random.nextInt(wordList.size()));


        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please re-enter the filename");
        }

        wordAsList = returnWord.codePoints().mapToObj(c -> (char) c).collect(Collectors.toList());

        return returnWord;
    }

    // Displays the game interface
    private void displayGameInterface() {
        writeToFile();
        readArtFromFile();
    }

    // Gets the user input
    private Character getUserInput() {
        char input = ' ';
        Scanner scanner = new Scanner(System.in);
        try {
            input = scanner.next().charAt(0);
            System.out.println("");
            System.out.println("");
            System.out.println("\033[0;1m" + input + "\033[0;0m");
            System.out.println("");
            System.out.println("");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a single letter");
            getUserInput();
        }

        return input;
    }

    private String getUserInputString() {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        try {
            input = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter letters");
            getUserInputString();
        }
        return input;
    }

    // Evaluates the user input
    private void evaluate() {
        containsCharacter = false;
        Character ch = getUserInput();
        if (guessedLetters.contains(ch.toString())) {
            System.out.println("""
                    You have already guessed that letter. Choose again.

                    Guess a letter.""");
            evaluate();
        }
        // Letter has not been guessed yet
        else {
            // Method to check if the letter is correct
            correctLetter(ch);
            // SpacesToDisplay is being updated with the guessed character in the correct spot
            // If the wordToGuess doesn't contain the guessed letter
            if (!containsCharacter) {
                missedLetters += ch;
                guessedLetters.add(ch.toString());
                state++;
                guesses++;
            }
            // If wordToGuess DOES contain the guessed letter
            else {
                guessedLetters.add(ch.toString());
            }
        }
        if (lettersLeft == 0) {
            state = 7;
            writeToFile();
            wordGuessed = true;
        }
        if (guesses == 7) {
            wordGuessed = true;
        }
        indx = 0;
    }

    // Displays the end text depending on if the user guessed the word correctly or not
    private void displayEndText() {
        readArtFromFile();
        highScoreName = getUserInputString();

        getHighScore();

        System.out.println("Would you like to play again? (y or n)");
        String input;
        input = getUserInputString();
        if (input.matches("y")) {
            generateGame();
        } else {
            System.out.println("\nHope to see you again soon!");
            System.exit(0);
        }

    }

    // Locates the file that contains the list of words
    private File getResourceFile(final String filename) {
        URL url = this.getClass().getClassLoader().getResource(filename);

        assert url != null;

        return new File(url.getFile());
    }

    private void writeToFile() {
        // 0 = Delivers blank version of art
        if (type == 0) {
            try {
                Stream<String> templateArtStream = Files.lines(Paths.get(getResourceFile("game_state_art_blank.txt").getPath()));
                List<String> filtered = templateArtStream.collect(Collectors.toList());
                FileWriter fw = new FileWriter(getResourceFile("game_state_art.txt"));
                filtered.forEach((s) -> {
                    try {
                        fw.write(s + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fw.close();

            } catch (IOException e) {
                e.getMessage();
            }
        }
        // 1 = after creation
        else if (type == 1) {
            try {
                // Creates a stream that is comprised of the default, blank game art
                Stream<String> templateArtStream = Files.lines(Paths.get(getResourceFile("game_state_art_blank.txt").getPath()));
                // Creates a stream of the current game state art
                Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()));
                // Creates a list that is the blanket art
                List<String> blankFiltered = templateArtStream.collect(Collectors.toList());
                FileWriter fw = new FileWriter(getResourceFile("game_state_art.txt"));
                FileWriter fw2 = new FileWriter(getResourceFile("game_state_art.txt"));
                // Making the game interface back to default
                blankFiltered.forEach((s) -> {
                    try {
                        fw.write(s + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fw.close();
                List<String> filtered = stream.map(line -> line.replace("Word:", "Word: " + spacesToDisplay)).map(x -> x.replace("Missed Letters:", "Missed Letters: " + missedLetters)).map(e -> e.replace("I'm sorry! The word was", "I'm sorry! The word was " + wordToGuess + ".")).map(f -> f.replace("Yes! The secret word was", "Yes! The secret word was " + wordToGuess + ". You won!!")).collect(Collectors.toList());
                filtered.forEach((s) -> {
                    try {
                        fw2.write(s + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fw2.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        // 2 = Updating high score
        else if (type == 2) {
            try {
                String tempName = Files.readAllLines(scoresPath).get(8);
                String tempScore = Files.readAllLines(scoresPath).get(9);

                Stream<String> scoreStream = Files.lines(scoresPath);
                List<String> scores1 = scoreStream.map(x -> x.replace(tempName, "1st: " + highScoreName)).map(c -> c.replace(tempScore, "x    1st Score - " + guesses)).collect(Collectors.toList());

                FileWriter fw = new FileWriter(scoresPath.toString());

                scores1.forEach((s) -> {
                    try {
                        fw.write(s + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fw.close();

            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    private void readArtFromFile() {
        AtomicInteger i = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger(0);
        if (state == 1) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                List<String> filtered = stream.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (s.matches(",")) {
                            i.set(1);
                        } else {
                            System.out.println(s);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (state == 2) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                List<String> filtered = stream.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (count.get() == 1) {
                            if (s.matches(",")) {
                                i.set(1);
                            } else {
                                System.out.println(s);
                            }
                        }
                        if (s.matches(",") && count.get() == 0) {
                            count.set(1);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (state == 3) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                List<String> filtered = stream.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (count.get() == 2) {
                            if (s.matches(",")) {
                                i.set(1);
                            } else {
                                System.out.println(s);
                            }
                        }
                        if (s.matches(",") && count.get() == 1) {
                            count.set(2);
                        }
                        if (s.matches(",") && count.get() == 0) {
                            count.set(1);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (state == 4) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                List<String> filtered = stream.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (count.get() == 3) {
                            if (s.matches(",")) {
                                i.set(1);
                            } else {
                                System.out.println(s);
                            }
                        }
                        if (s.matches(",") && count.get() == 2) {
                            count.set(3);
                        }
                        if (s.matches(",") && count.get() == 1) {
                            count.set(2);
                        }
                        if (s.matches(",") && count.get() == 0) {
                            count.set(1);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (state == 5) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                List<String> filtered = stream.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (count.get() == 4) {
                            if (s.matches(",")) {
                                i.set(1);
                            } else {
                                System.out.println(s);
                            }
                        }
                        if (s.matches(",") && count.get() == 3) {
                            count.set(4);
                        }
                        if (s.matches(",") && count.get() == 2) {
                            count.set(3);
                        }
                        if (s.matches(",") && count.get() == 1) {
                            count.set(2);
                        }
                        if (s.matches(",") && count.get() == 0) {
                            count.set(1);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (state == 6) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                List<String> filtered = stream.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (count.get() == 5) {
                            if (s.matches(",")) {
                                i.set(1);
                            } else {
                                System.out.println(s);
                            }
                        }
                        if (s.matches(",") && count.get() == 4) {
                            count.set(5);
                        }
                        if (s.matches(",") && count.get() == 3) {
                            count.set(4);
                        }
                        if (s.matches(",") && count.get() == 2) {
                            count.set(3);
                        }
                        if (s.matches(",") && count.get() == 1) {
                            count.set(2);
                        }
                        if (s.matches(",") && count.get() == 0) {
                            count.set(1);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (state == 7 && lettersLeft == 0) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                Stream<String> highScores = Files.lines(scoresPath);
                List<String> filtered = stream.collect(Collectors.toList());
                List<String> scores = highScores.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (count.get() == 6) {
                            if (s.matches(",")) {
                                i.set(1);
                            } else {
                                System.out.println(s);
                            }
                        }
                        if (s.matches(",") && count.get() == 5) {
                            count.set(6);
                        }
                        if (s.matches(",") && count.get() == 4) {
                            count.set(5);
                        }
                        if (s.matches(",") && count.get() == 3) {
                            count.set(4);
                        }
                        if (s.matches(",") && count.get() == 2) {
                            count.set(3);
                        }
                        if (s.matches(",") && count.get() == 1) {
                            count.set(2);
                        }
                        if (s.matches(",") && count.get() == 0) {
                            count.set(1);
                        }
                    }
                });
                scores.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (state == 7) {
            try (Stream<String> stream = Files.lines(Paths.get(getResourceFile("game_state_art.txt").getPath()))) {
                List<String> filtered = stream.collect(Collectors.toList());
                filtered.forEach((s) -> {
                    if (i.get() == 0) {
                        if (count.get() == 7) {
                            if (s.matches(",")) {
                                i.set(1);
                            } else {
                                System.out.println(s);
                            }
                        }
                        if (s.matches(",") && count.get() == 6) {
                            count.set(7);
                        }
                        if (s.matches(",") && count.get() == 5) {
                            count.set(6);
                        }
                        if (s.matches(",") && count.get() == 4) {
                            count.set(5);
                        }
                        if (s.matches(",") && count.get() == 3) {
                            count.set(4);
                        }
                        if (s.matches(",") && count.get() == 2) {
                            count.set(3);
                        }
                        if (s.matches(",") && count.get() == 1) {
                            count.set(2);
                        }
                        if (s.matches(",") && count.get() == 0) {
                            count.set(1);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setSpaces() {
        spacesToDisplay.append('_');
        if (spacesToDisplay.length() != wordToGuess.length()) {
            setSpaces();
        }
    }

    private void correctLetter(char c) {
        if (indx < wordToGuess.length()) {
            if (wordToGuess.charAt(indx) == c) {
                containsCharacter = true;
                spacesToDisplay.setCharAt(indx, c);
                guessedLetters.add(String.valueOf(c));
                lettersLeft--;
                indx++;
                correctLetter(c);
            } else {
                indx++;
                correctLetter(c);
            }
        }
    }

    private void getHighScore() {
        try (Stream<String> stream = Files.lines(scoresPath)) {
            List<String> highScores = stream.collect(Collectors.toList());

            highScores.forEach((s) -> {
                if (s.startsWith("x")) {
                    if (Integer.parseInt(s.substring(17)) >= guesses) {
                        System.out.println("You beat the previous high score!");
                        type = 2;
                        writeToFile();
                    }
                }
            });

        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void generateGame(){
        guesses = 0;
        lettersLeft = 100;
        state = 1;
        type = 0;
        indx = 0;
        highScoreScore = 0;
        missedLetters = "";
        wordToGuess = "";
        highScoreName = "";
        spacesToDisplay = new StringBuilder();
        guessedLetters = new ArrayList<>();
        wordAsList = new ArrayList<>();
        wordGuessed = false;
        play = true;
        containsCharacter = false;
        newGame = true;
        scoresPath = Paths.get("scores.txt").toAbsolutePath();
    }

    // GETTERS
    public String getWordToGuess() {
        return wordToGuess;
    }

    public String getMissedLetters() {
        return missedLetters;
    }

    public int getLettersLeft() {
        return lettersLeft;
    }

    //SETTERS
    public void setWordToGuess(String str) {
        wordToGuess = str;
    }

    public void setMissedLetters(String b) {
        missedLetters = b;
    }

    public void setLettersLeft(int let) {
        lettersLeft = let;
    }
}