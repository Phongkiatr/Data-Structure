package solutions.pack12b_SSP;

import java.util.*;

class State {
    int[] array;
    int steps;

    public State(int[] array) {
        this.array = array.clone();
        this.steps = 0;
    }

    public State(int[] array, int steps) {
        this.array = array.clone();
        this.steps = steps;
    }

    public int[] getArray() {
        return array;
    }

    public int getSteps() {
        return steps;
    }

    // Override equals to compare arrays inside the state
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        State state = (State) obj;
        return Arrays.equals(array, state.array);
    }

    // Override hashCode to ensure states with the same array are treated the same
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
