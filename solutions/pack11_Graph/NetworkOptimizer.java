package solutions.pack11_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import java.util.PriorityQueue;

public class NetworkOptimizer {
    /*
     * <input>
     * N is the number of computers (nodes) in the network.
     * M is the number of cables (edges) available for connecting the computers.
     * S is the ID of the starting node. The ID of each node will start from 1 up to N.
     * 
     * <Output>
     * Output a single integer, the total latency of the optimised network. If it is
     * impossible to connect all computers, output -1.
     */

    public int optimizeNetwork(int N, int M, int[][] input) {

        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            Edge edge = new Edge(latency, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdge(edge);
            nodes[node2Id - 1].addEdge(edge);
        }

        /*
         * TASK 2: Implement PRIM's algorithm to find the minimum spanning tree
         * by using latency as the weight
         * 
         * The algorithm should return the total latency of the minimum spanning tree
         */

        Node startNode = nodes[0];
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());

        // implement the algorithm here
        boolean[] inMST = new boolean[N];
        int edgesInMST = 0;

        // Add all edges from the starting node to the priority queue
        inMST[startNode.getId() - 1] = true;
        pq.addAll(startNode.getEdges());

        // Main Loop
        while (!pq.isEmpty() && edgesInMST < N - 1) { // number of edges in MST is N - 1
            Edge minEdge = pq.poll();
            Node targetNode = inMST[minEdge.getNode2().getId() - 1] ? minEdge.getNode1() : minEdge.getNode2(); 

            if (inMST[targetNode.getId() - 1]) {
                continue; // If in MST, skip this edge
            }
            totalLatency += minEdge.getLatency();
            edgesInMST++;

            // Mark as in MST
            inMST[targetNode.getId() - 1] = true;

            // Add all edges from the target node to the priority queue
            for (Edge edge : targetNode.getEdges()) {
                if (!pq.contains(edge)) {
                    pq.add(edge);
                }
            } 
        }
        
        // If not all nodes are connected, return -1
        if (edgesInMST != N - 1) {
            return -1;
        }

        return totalLatency;

    }

    // Overload the optimizeNetwork method
    public int optimizeNetwork(int N, int M, int T, int[][] input) {
        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            int bandwidth = input[i][3];
            EdgeWithBandwidth edge = new EdgeWithBandwidth(latency, bandwidth, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdgeWithBandwidth(edge);
            nodes[node2Id - 1].addEdgeWithBandwidth(edge);
        }

        /*
         * TASK 3: Implement PRIM's algorithm to find the minimum spanning tree
         * by using latency as the weight and
         * the edge that have bandwidth less than T should not be included in the
         * minimum spanning tree
         * 
         * The algorithm should return the total latency of the minimum spanning tree
         */
        Node startNode = nodes[0];
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());

        // implement the algorithm here

        return totalLatency;

    }
}

























