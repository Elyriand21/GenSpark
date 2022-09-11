import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BoardingPass {
    String name;
    String email;
    String date;
    String destination;
    String origin;
    String phoneNumber;
    int departTime;
    int age;
    int milesFromOrigin;
    int arrivalTime;
    double eta;
    double ticketPrice;
    long passNumber;
    // True is female, false is male
    boolean gender;

    // Constructor for creating a BoardingPass
    public BoardingPass(){
        this.name = "";
        this.email = "";
        this.phoneNumber = "";
        this.date = "";
        this.destination = "";
        this.origin = "";
        this.gender = false;
        this.age = 0;
        this.departTime = 0;
        this.passNumber = 0;
        this.ticketPrice = 330;
        this.arrivalTime = 0;
        this.milesFromOrigin = 0;
        this.eta = 0;
    }

    // Method to calculate ETA
    public void calculateETA(int milesFromOrigin, int departTime){
        double temp = 0;
        // Average airplane speed = 460-575mph = Rounded to 500mph

        eta = milesFromOrigin / 500.00;

        setArrivalTime((int) (departTime + eta));
        System.out.println("Your flight will take " + eta + " hours to complete!");
    }

    public double calculateTicketPrice(int age, boolean gender){
        // Average US domestic roundtrip flight cost
        double ticketPrice = 330;

        if(age <= 12){
            ticketPrice = ticketPrice - (ticketPrice * .50);
        }
        if(age >= 60){
            ticketPrice = ticketPrice - (ticketPrice * .60);
        }

        // If the person buying the pass is a woman
        if(gender){
            ticketPrice = ticketPrice - (ticketPrice * .25);
        }

        return ticketPrice;
    }

    public long generateBoardingPass(){
        long boardingPassNumber = 0;
        List<String> passNumbers = new ArrayList<>();
        boolean complete = false;

        try{
            passNumbers = Files.readAllLines(Path.of("src/main/resources/boarding_pass_numbers.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        boardingPassNumber = (int) Math.floor(Math.random() * (9999999999L - 100000000L + 1) + 1);
        if(boardingPassNumber < 0){
            boardingPassNumber = boardingPassNumber * -1;
        }
        int numbersOfPasses = passNumbers.size();
        System.out.println(numbersOfPasses);

        while(!complete) {
            int temp = 0;
            for (String s : passNumbers) {
                if (s.matches(String.valueOf(boardingPassNumber))) {
                    boardingPassNumber = (long) (Math.floor(Math.random() * 9000000000L) + 1000000000L);
                }
                else{
                    temp++;
                }
            }
            if(temp == numbersOfPasses){
                complete = true;
            }
        }

        if(numbersOfPasses == 0){
            try{
                Files.writeString(Path.of("src/main/resources/boarding_pass_numbers.txt"), String.valueOf(boardingPassNumber), StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Files.writeString(Path.of("src/main/resources/boarding_pass_numbers.txt"), String.valueOf(System.lineSeparator() + boardingPassNumber), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return boardingPassNumber;
    }

    public void writeBoardingPassToFile(BoardingPass pass){
        try{
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), pass.getName(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getEmail(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getPhoneNumber(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getDate(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getDestination(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getOrigin(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getGender(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getAge(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getDepartTime(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getPassNumber(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getTicketPrice(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), "," + pass.getArrivalTime(), StandardOpenOption.APPEND);
            Files.writeString(Path.of("src/main/resources/boarding_pass_details.txt"), System.lineSeparator(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GETTERS
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;}
    public String getDate() {
        return date;
    }
    public String getDestination() {
        return destination;
    }
    public String getOrigin(){
        return origin;}
    public boolean getGender() {
        return gender;}
    public int getAge() {
        return age;}
    public int getDepartTime() {
        return departTime;
    }
    public long getPassNumber(){
        return passNumber;}
    public double getTicketPrice(){
        return ticketPrice;}
    public int getArrivalTime(){
        return arrivalTime;}
    public String getAllProperties(BoardingPass pass){
        return "Boarding Pass Name: " + pass.getName() +
                "\nBoarding Pass Email: " + pass.getEmail() +
                "\nBoarding Pass Phone Number: " + pass.getPhoneNumber() +
                "\nBoarding Pass Date: " + pass.getDate() +
                "\nBoarding Pass Destination: " + pass.getDestination() +
                "\nBoarding Pass Flight Origin: " + pass.getOrigin() +
                "\nBoarding Pass Gender: " + pass.getGender() +
                "\nBoarding Pass Age: " + pass.getAge() +
                "\nBoarding Pass Departure Time: " + pass.getDepartTime() +
                "\nBoarding Pass Flight Time: " + pass.getFlightTime() +
                "\nBoarding Pass Arrival Time: " + pass.getArrivalTime() +
                "\nBoarding Pass Pass Number: " + pass.getPassNumber() +
                "\nBoarding Pass Ticket Price: $" + pass.getTicketPrice();
    }
    public int getMilesFromOrigin(){
        return milesFromOrigin;}
    public double getFlightTime(){
        return eta;}

    // SETTERS
    public void setName(String str) {
        this.name = str;
    }
    public void setEmail(String str) {
        this.email = str;
    }
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;}
    public void setDate(String str) {
        this.date = str;
    }
    public void setDestination(String str) {
        this.destination = str;
    }
    public void setOrigin(String str){
        this.origin = str;}
    public void setGender(boolean female) {
        this.gender = female;}
    public void setAge(int age) {
        this.age = age;}
    public void setDepartTime(int time) {
        this.departTime = time;
    }
    public void setPassNumber(long num){
        this.passNumber = num;}
    public void setArrivalTime(int num){
        this.arrivalTime = num;}
    public void setTicketPrice(double price){
        this.ticketPrice = price;}
    public void setMilesFromOrigin(int miles){
        this.milesFromOrigin = miles;}
}
