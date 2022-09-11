package java.main;

import java.util.ArrayList;

public class SubArray {
    public ArrayList<Integer> solution(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Integer> returnList = new ArrayList<>();

        int maxSoFar = 0,
                maxEndHere = 0,
                start = 0,
                end = 0,
                tempIndx = 0;

        if (nums.size() == 0 || nums.size() == 1) {
            return nums;
        }

        for (int i = 0; i < nums.size(); i++) {
            maxEndHere += nums.get(i);

            if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
                start = tempIndx;
                end = i;
            }

            if (maxEndHere <= 0) {
                maxEndHere = 0;
                tempIndx = i + 1;
            }

        }

        for (int i = start; i <= end; i++) {
            returnList.add(nums.get(i));
        }

        if(returnList.get(0) == 0){
            returnList.remove(0);
        }

        return returnList;
    }
}
