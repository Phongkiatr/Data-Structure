package solutions.pack7_Recursion;

import java.util.HashMap;
import java.util.Map;

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
    public static boolean canPartition_Memoiz(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        
        Map<String, Boolean> memo = new HashMap<>();
        
        return computeCanPartition_Memoiz(arr, target, 0, memo);
    }

    private static boolean computeCanPartition_Memoiz(int[] arr, int target, int currentIndex, Map<String, Boolean> memo) {
        if (target == 0) {
            return true;
        }
        if (currentIndex >= arr.length || target < 0) {
            return false;
        }
        
        String currentKey = currentIndex + "-" + target;
        
        // is result already calculated ?
        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }
        // Including the current element 
        if (computeCanPartition_Memoiz(arr, target - arr[currentIndex], currentIndex + 1, memo)) {
            memo.put(currentKey, true);
            return true;
        }
        // Exclude the current element
        if (computeCanPartition_Memoiz(arr, target, currentIndex + 1, memo)) {
            memo.put(currentKey, true);
            return true;
        }
        
        memo.put(currentKey, false);
        return false;
    }
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
