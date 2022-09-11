public class Main {
    public static void main(String[] args){
        String original = "I am happy to be alive!";

        System.out.println("Original String: " + original);
        System.out.println("Reverse Iterative: " + reverseIterative(original));
        System.out.println("Reverse Functionally: " + reverseFunctionally(original));
    }

    private static String reverseIterative(String str){
        StringBuilder temp = new StringBuilder();
        char[] strChars = str.toCharArray();

        for(int i = strChars.length - 1; i >= 0; i--){
            temp.append(strChars[i]);
        }

        return temp.toString();
    }

    private static String reverseFunctionally(String str) {
        StringBuilder temp = new StringBuilder(str);

        return temp.reverse().toString();
    }
}