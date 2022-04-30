import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Human {
    private Point coords = new Point();
    private int health;
    private int strength;
    private String name;
    private String icon;
    private String sex;

    public Human(){
        // Min Health = 10 Max Health = 30
        health = (int) Math.floor(Math.random() * (30 - 10 + 1) + 10);
        // Min Strength = 3 Max Strength = 8
        strength = (int) Math.floor(Math.random() * (8 - 3 + 1) + 3);
        // 1 = Male, 2 = Female
        if(Math.floor(Math.random() * (2 - 1 + 1) + 1) == 1){
            name = setHumanMaleName();
            sex = "Male";
            icon = "♂";
        }
        else{
            name = setHumanFemaleName();
            sex = "Female";
            icon = "♀";
        }
        // Sets coords to be random
        coords.setLocation(((int) Math.floor(Math.random() * (4 + 1) + 0)), ((int) Math.floor(Math.random() * (4 + 1) + 0)));
    }

    private String setHumanMaleName(){
        String nameHold = "";
        List<String> names = new ArrayList<>();
        try {
            File obj = getResourceFile("human_male_names.txt");
            if (!obj.exists()) {
                throw new FileNotFoundException();
            }
            try {
                names = Files.readAllLines(Paths.get(obj.getPath()));
            } catch (IOException i) {
                System.out.println("Error has occured");
            }
            Random random = new Random();
            nameHold = names.get(random.nextInt(names.size()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return nameHold;
    }
    private String setHumanFemaleName(){
        String nameHold = "";
        List<String> names = new ArrayList<>();
        try {
            File obj = getResourceFile("human_male_names.txt");
            if (!obj.exists()) {
                throw new FileNotFoundException();
            }
            try {
                names = Files.readAllLines(Paths.get(obj.getPath()));
            } catch (IOException i) {
                System.out.println("Error has occured");
            }
            Random random = new Random();
            nameHold = names.get(random.nextInt(names.size()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return nameHold;
    }

    public void move(String direction){
        if(direction.equals("n") && this.getCoords().getY() != 0){
            this.coords.setLocation(this.coords.getX(), (this.coords.getY() - 1));
        }
        else if(direction.equals("n") && this.getCoords().getY() == 0){
            throw new RuntimeException("You cannot move north! There's nowhere to go!");
        }
        if(direction.equals("s") && this.getCoords().getY() != 4){
            this.coords.setLocation(this.coords.getX(), (this.coords.getY() + 1));
        }
        else if(direction.equals("s") && this.getCoords().getY() == 4){
            throw new RuntimeException("You cannot move south! There's nowhere to go!");
        }
        if(direction.equals("e") && this.getCoords().getX() != 4){
            this.coords.setLocation((this.coords.getX() + 1), this.coords.getY());
        }
        else if(direction.equals("e") && this.getCoords().getX() == 4){
            throw new RuntimeException("You cannot move east! There's nowhere to go!");
        }
        if(direction.equals("w") && this.getCoords().getX() != 0){
            this.coords.setLocation((this.coords.getX() - 1), this.coords.getY());
        }
        else if(direction.equals("w") && this.getCoords().getX() == 0){
            throw new RuntimeException("You cannot move west! There's nowhere to go!");
        }
    }

    public int attack(){
        return getStrength();
    }

    // GETTERS
    public int getHealth(){
        return health;
    }
    public int getStrength(){
        return strength;
    }
    public String getName(){
        return name;
    }
    public String getSex(){
        return sex;
    }
    public String getIcon(){
        return icon;
    }
    public Point getCoords(){
        return coords;
    }

    // SETTERS
    public void setHealth(int hp) {
        health = hp;
    }
    public void setStrength(int str){
        strength = str;
    }
    public void setName(String str){
        name = str;
    }
    public void setSex(String str){
        sex = str;
    }
    public void setCoords(Point a){
        coords = a;
    }
    public void setIcon(String ic){
        icon = ic;
    }

    // Locates the file that contains the list of words
    private File getResourceFile(final String filename) {
        URL url = this.getClass().getClassLoader().getResource(filename);

        File obj = new File(url.getFile());

        return obj;
    }
}
