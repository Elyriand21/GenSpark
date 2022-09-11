package main.java;

import java.util.ArrayList;

public class PascalRewrite {
    public ArrayList<Integer> solution(int nth) {
        ArrayList<Integer> returnList = new ArrayList<>();
        int prev = 1;
        returnList.add(prev);

        for(int i = 1; i <= nth; i++){
            int curr = prev * (nth - i + 1) / i;
            returnList.add(curr);
            prev = curr;
        }

        return returnList;
    }
}
