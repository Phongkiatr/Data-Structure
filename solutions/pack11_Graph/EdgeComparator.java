package solutions.pack11_Graph;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge e1, Edge e2) {
        return Integer.compare(e1.getLatency(), e2.getLatency());
    }
}
