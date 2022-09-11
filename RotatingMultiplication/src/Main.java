import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // Input: 2,5,6,4
        // Output: 120,48,40,60
        int[] test = {2,5,6,4};

        System.out.println(Arrays.toString(product(test)));
    }

    public static int[] product(int[] nums){
        // Creation of arrays to hold products
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] product = new int[nums.length];

        // First element in the left array will always be 1
        left[0] = 1;
        // Last element in the right array will always be 1
        right[nums.length - 1] = 1;

        // Traverse the array, generating products up to i - 1
        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i -1] * left[i - 1];
        }
        // Traverse the array from the right, generating products up to i + 1
        for(int e = nums.length - 2; e >= 0; e--){
            right[e] = nums[e + 1] * right[e + 1];
        }

        for(int a = 0; a < nums.length; a++){
            product[a] = left[a] * right[a];
        }

        return product;
    }
}