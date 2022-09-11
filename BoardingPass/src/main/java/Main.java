import java.util.Locale;
import java.util.Scanner;

public class Main {
    // This will be where the program is started
    public static void main(String[] args){
        BoardingPass boardingPass = new BoardingPass();
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your full name: ");
        boardingPass.setName(scan.nextLine());
        System.out.println("Please enter your email address: ");
        boardingPass.setEmail(scan.nextLine());
        System.out.println("Please enter your phone number: ");
        boardingPass.setPhoneNumber(scan.nextLine());
        System.out.println("Please enter your age: ");
        boardingPass.setAge(scan.nextInt());
        scan.nextLine();
        System.out.println("Are you a male or female?");
        boardingPass.setGender(!scan.nextLine().toLowerCase(Locale.ROOT).matches("male"));
        System.out.println("Please enter the date you wish to fly: ");
        boardingPass.setDate(scan.nextLine());
        System.out.println("(In 24HR Format) Please enter the time you wish to board the plane: ");
        boardingPass.setDepartTime(scan.nextInt());
        scan.nextLine();
        System.out.println("Where are you intending to fly to?");
        boardingPass.setDestination(scan.nextLine());
        System.out.println("Where are you flying from?");
        boardingPass.setOrigin(scan.nextLine());
        System.out.println("How many miles is your destination from your flight origin?");
        boardingPass.setMilesFromOrigin(scan.nextInt());
        // Sets the ticket price
        boardingPass.setTicketPrice(boardingPass.calculateTicketPrice(boardingPass.getAge(), boardingPass.getGender()));
        // Creates the boarding pass number
        boardingPass.setPassNumber(boardingPass.generateBoardingPass());
        // Calculates the ETA
        boardingPass.calculateETA(boardingPass.getMilesFromOrigin(),boardingPass.getDepartTime());

        boardingPass.writeBoardingPassToFile(boardingPass);

        System.out.println(boardingPass.getAllProperties(boardingPass));
    }
}
