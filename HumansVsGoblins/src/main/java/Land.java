import java.awt.*;

public class Land extends List {
    private Point coords = new Point();
    private boolean containsCharacter;
    private String characterIcon;
    private Class containedCharClass;
    private Object character;

    public Land() {
        coords.setLocation(0,0);
        containsCharacter = false;
        characterIcon = "";
        containedCharClass = null;
        character = null;
    }

    // GRID DISPLAY METHODS
    public void displayTop(){
        System.out.print("   -----------  ");
    }
    public void displaySecond(){
        System.out.print("  |           | ");
    }
    public void displayThird(){
        System.out.print("|" + String.format("%-5s%-5s", "", characterIcon) + " |   ");
    }
    public void displayFourth(){
        System.out.print("  |" + String.format("%-5s%-5s", "", " ") + " | ");
    }
    public void displayBottom(){
        System.out.print("   -----------  ");
    }

    // GETTERS
    public boolean doesContainCharacter() {
        return containsCharacter;
    }
    public Point getCoords(){
        return coords;
    }
    public Class getContainedCharClass(){
        return containedCharClass;
    }
    public Object getCharacter(){
        return character;
    }

    // SETTERS
    public void setContainsCharacter(boolean contains) {
        containsCharacter = contains;
    }
    public void setCoords(Point a){
        coords = a;
    }
    public void setCharacterIcon(String ic){
        characterIcon = ic;
    }
    public void setContainedCharClass(Class ch){
        containedCharClass = ch;
    }
    public void setCharacter(Object obj){
        if(obj == null){
            character = null;
        }
        else if(obj.getClass().getName().matches("Human")){
            character = (Human) obj;
        }
        else{
            character = (Goblin) obj;
        }
    }
}
