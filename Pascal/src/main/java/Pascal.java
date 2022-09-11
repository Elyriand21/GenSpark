package main.java;

import java.util.ArrayList;

public class Pascal{
    public ArrayList<Integer> solution(int nth) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Integer> returnList = new ArrayList<>();
        int prev = 1;
        returnList.add(prev);

        for(int i = 1; i <= nth; i++)
        {

            // nCr = (nCr-1 * (n - r + 1))/r
            // Number at position i in row = (previous position in row * (row - (position in row - 1) + 1)) / (position in row - 1)
            int curr = (prev * (nth - i + 1)) / i;
            returnList.add(curr);
            prev = curr;
        }

        return returnList;
    }
}