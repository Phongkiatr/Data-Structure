package solutions.pack11_Graph;

public class Edge {
    private int latency;
    private Node Node1;
    private Node Node2;

    public Edge(int latency, Node Node1, Node Node2) {
        this.latency = latency;
        this.Node1 = Node1;
        this.Node2 = Node2;
    }
    public int getLatency() {
        return latency;
    }
    public Node getNode1() {
        return Node1;
    }
    public Node getNode2() {
        return Node2;
    }
    public String toString() {
        return String.format("%s--%s :%d", Node1, Node2, latency);
    }
}
