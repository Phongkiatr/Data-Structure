package solutions.pack11_Graph;

public class EdgeWithBandwidth extends Edge {
    private int bandwidth;

    public EdgeWithBandwidth(int latency, int bandwidth, Node Node1, Node Node2) {
        super(latency, Node1, Node2);
        this.bandwidth = bandwidth;
    }

    public int getBandwidth() {
        return bandwidth;
    }
    
}
