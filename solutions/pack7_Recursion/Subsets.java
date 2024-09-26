package solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void printAllSubsets_Recurse(List<Integer> set) {
        List<Integer> subSet = new ArrayList<>();
        generateSubsets(set, subSet, 0);
    }

    private static void generateSubsets(List<Integer> set, List<Integer> subSet, int index) {
        if (index == set.size()) {
            System.out.println(subSet);
            return;
        }

        // Exclude the current element
        generateSubsets(set, subSet, index + 1);

        // Include the current element
        subSet.add(set.get(index));
        generateSubsets(set, subSet, index + 1);

        // Remove current element
        subSet.remove(subSet.size() - 1);
    }
    public static void printAllSubsets_DP(List<Integer> set) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        
        allSubsets.add(new ArrayList<>());
        
        for (int num : set) {
            int n = allSubsets.size();
            
            for (int i = 0; i < n; i++) {
                List<Integer> newSubset = new ArrayList<>(allSubsets.get(i));
                newSubset.add(num);
                allSubsets.add(newSubset);
            }
        }
        
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}
