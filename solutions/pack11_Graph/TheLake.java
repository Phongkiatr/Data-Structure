package solutions.pack11_Graph;

public class TheLake {
    public int findTotalMaxDepth(int[][] input) {
        int totalMaxDepth = 0;
        boolean[][] visited = new boolean[input.length][input[0].length];
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                if (!visited[row][col]) {
                    int curDepth = findTotalMaxDepth(input, visited, row, col);
                    totalMaxDepth = (curDepth > totalMaxDepth) ? curDepth : totalMaxDepth;
                }
            }
        }

        return totalMaxDepth;
    }

    public int findTotalMaxDepth(int[][] input, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int total = input[row][col];
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == y)
                    continue;
                int xPrime = row + x;
                int yPrime = col + y;
                if (xPrime < 0 || xPrime >= input.length)
                    continue;
                if (yPrime < 0 || yPrime >= input[row].length)
                    continue;
                if (!visited[xPrime][yPrime] && input[xPrime][yPrime] > 0)
                    total += findTotalMaxDepth(input, visited, xPrime, yPrime);
            }
        }
        return total;
    }
}