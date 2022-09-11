import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String var1 = "";
        String var2 = "";
        String var3 = "";
        String var4 = "";

        List<String> var1Array = new ArrayList<>();
        List<String> var2Array = new ArrayList<>();
        List<String> var3Array = new ArrayList<>();

        var1 = scanner.nextLine();
        var2 = scanner.nextLine();
        var3 = scanner.nextLine();

        if(var1.contains(" ")){
            var1Array = List.of((var1.split(" ")));
        }
        if(var2.contains(" ")){
            var2Array = List.of((var2.split(" ")));
        }
        if(var3.contains(" ")){
            var3Array = List.of(var3.split(" "));
        }

        if(var1Array.size() != 0){
            var4 = var3;
            var3 = var2;
            var2 = var1Array.get(1);
            var1 = var1Array.get(0);
        }

        if(var2Array.size() != 0){
            var4 = var3;
            var3 = var2Array.get(1);
            var2 = var2Array.get(0);
        }

        if(var3Array.size() != 0){
            var3 = var3Array.get(0);
            var4 = var3Array.get(1);
        }

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
    }
}
