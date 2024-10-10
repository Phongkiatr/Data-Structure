package solutions.pack12b_SSP;

import java.util.*;

public class Dijkstra {

    int[][] adjMatrix;
    int[] previous, distance;
    boolean[] visted;
    int source;

    public Dijkstra(int[][] adjMatrix, int source) {
        this.adjMatrix = adjMatrix;
        this.source = source;
        previous = new int[adjMatrix.length];
        distance = new int[adjMatrix.length];
        visted = new boolean[adjMatrix.length];
    }
    
    public void findSSP() {

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0; // Distance to the source node is 0
        Arrays.fill(previous, -1); // No previous nodes at the start


        for (int i = 0; i < adjMatrix.length; i++) {
  
            int u = getMinDistanceNode();

            if (u == -1) {
                break;
            }

            visted[u] = true;

            for (int v = 0; v < adjMatrix.length; v++) {
                if (!visted[v] && adjMatrix[u][v] > 0) { // If v is unvisited and there is an edge
                    int newDist = distance[u] + adjMatrix[u][v];
                    if (newDist < distance[v]) {
                        distance[v] = newDist;
                        previous[v] = u; // Update the previous node to trace the path
                    }
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.printf("node %d distance is %d%n", i, distance[i]);
        }
    }

    private int getMinDistanceNode() {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visted[i] && distance[i] < minDist) {
                minDist = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    //Task 2 implement the printAllSSP method to print the shortest path 
    //from the source to all other nodes
    public void printAllSSP() {
        for (int i = 0; i < adjMatrix.length; i++) {
            printShortestPath(i);
        }
    }
    public void printShortestPath(int target) {
        if (distance[target] == Integer.MAX_VALUE) {
            System.out.println("No path from " + source + " to " + target);
        } else {
            System.out.print("Shortest path from " + source + " to " + target + " is ");
            printPath(target);
            System.out.println("\nwith a distance of " + distance[target] + "\n");
        }
    }

    private void printPath(int target) {
        if (previous[target] == -1) {
            System.out.print(target);
        } else {
            printPath(previous[target]);
            System.out.print(" -> " + target);
        }
    }

}
