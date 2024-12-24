import java.util.Arrays;

public class ShortestPathCalculator {

    private static int findMinIndex(int[] distance, boolean[] visited) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minValue) {
                minValue = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findShortestCost(int[][] adjacencyMatrix, int source, int target) {
        int n = adjacencyMatrix.length;
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        while (true) {
            // Find the vertex with the minimum distance
            int current = findMinIndex(distance, visited);
            if (current == -1 || current == target) break;
            visited[current] = true;

            // Update the distances to neighboring vertices
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (!visited[neighbor] && adjacencyMatrix[current][neighbor] != Integer.MAX_VALUE) {
                    int newDist = distance[current] + adjacencyMatrix[current][neighbor];
                    if (newDist < distance[neighbor]) {
                        distance[neighbor] = newDist;
                    }
                }
            }
        }

        return distance[target];
    }
}
