package solutions.pack7_Recursion;

import java.util.Arrays;

public class EqualSubsets {
    public static boolean canPartition_Recurse(int ... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        return computeCanPartition_Recurse(arr, arr.length, target);
    }
    private static boolean computeCanPartition_Recurse(int [] arr, int length, int target) {
        if (target == 0)
            return true;
        if (length == 0)
            return false;
        if (arr[length - 1] == target)
            return true;
        if (arr[length - 1] > target) { // skip this element
            return computeCanPartition_Recurse(arr, length - 1, target);
        }
        return computeCanPartition_Recurse(arr, length - 1, target - arr[length - 1]);
        
    }
    // public static boolean canPartition_Memoiz(int [] arr) {

    // }
    public static boolean canPartition_DP(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int i = target; i >= num; i--) {
                dp[i] = (dp[i] || dp[i - num]);
            }
        }
        return dp[target];
    }
}
