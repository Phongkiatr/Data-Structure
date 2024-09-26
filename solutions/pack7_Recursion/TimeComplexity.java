package solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class TimeComplexity {
    public static void main(String[] args) {
        // SubsetsTime();
        GridPathsTime();
    }
    static void SubsetsTime() {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        long startTime = System.currentTimeMillis();
        Subsets.printAllSubsets_Recurse(set);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Using Recursive: " + (endTime - startTime) + "ms.");

        startTime = System.currentTimeMillis();
        Subsets.printAllSubsets_DP(set);
        endTime = System.currentTimeMillis();
        System.out.println("Time Using Dynamic Programming: " + (endTime - startTime) + "ms.");

    }
    static void GridPathsTime() {
        int[][] path = new int[1000][1000];
        long startTime = System.currentTimeMillis();
        System.out.println(GridPaths.numberOfPaths(path));
        long endTime = System.currentTimeMillis();
        System.out.println("Time Using: " + (endTime - startTime) + "ms.");
    }
}
