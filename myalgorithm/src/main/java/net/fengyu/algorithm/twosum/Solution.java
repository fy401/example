package net.fengyu.algorithm.twosum;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main( String[] args ) {

        String str = "abcde";
        System.out.println(str.substring(0,1));

//        Solution s = new Solution();
//
//        int[] nums = {-3,2,5,7,11,3,15};
//
//        s.twoSum(nums,10);
    }

    public int[] twoSum(int[] nums, int target) {

        int[] retArray = new int[2];

        // <|nums[i]-halftarget|,i>
        Map<Float,Integer> map = new HashMap<Float,Integer>(2*nums.length);

        float halftarget = (float)target/2;

        for(int i=0;i<nums.length;i++) {
            float distance = Math.abs(nums[i]-halftarget);
            if(map.containsKey(distance)) {
                retArray[0] = map.get(distance);
                retArray[1] = i;
                return retArray;
            } else {
                map.put(distance,i);
            }
        }


        //str



        return null;
    }





    private void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]).append("  ");
        }
        System.out.println(sb.toString());
    }
}
