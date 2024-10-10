package solutions.pack12b_SSP;

import java.util.*;

public class Task3 {
    
    public int stateSpace(int[] beginState, int[] goalState){
        InterfaceSwapAdjacentPairs swapPairs = (state) -> {
            int[] newState = state.clone();
            for (int i = 0; i < state.length - 1; i += 2) {
                int temp = newState[i];
                newState[i] = newState[i + 1];
                newState[i + 1] = temp;
            }
            return newState;
        };

        InterfaceSwapCorrespondingHalves swapHalves = (state) -> {
            int n = state.length / 2;
            int[] newState = state.clone();
            for (int i = 0; i < n; i++) {
                int temp = newState[i];
                newState[i] = newState[i + n];
                newState[i + n] = temp;
            }
            return newState;
        };

        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        
        queue.add(new State(beginState));  // Add the initial state
        visited.add(new State(beginState));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            if (Arrays.equals(currentState.array, goalState)) {
                return currentState.steps; // Return the number of operations when reaching the goal
            }

            // swap adjacent pairs
            int[] swappedPairs = swapPairs.swapAdjacentPairs(currentState.array);
            State newStatePairs = new State(swappedPairs, currentState.steps + 1);
            if (!visited.contains(newStatePairs)) {
                queue.add(newStatePairs);
                visited.add(newStatePairs);
            }

            // swap corresponding halves
            int[] swappedHalves = swapHalves.swapCorrespondingHalves(currentState.array);
            State newStateHalves = new State(swappedHalves, currentState.steps + 1);
            if (!visited.contains(newStateHalves)) {
                queue.add(newStateHalves);
                visited.add(newStateHalves);
            }
        }
        return -1;
    }

}
