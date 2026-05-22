package BONUS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bonus_task {

    static class Edge {
        int toVertex;
        int weight;

        public Edge(int toVertex, int weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }
    }

    static class Graph {
        private final int verticesCount;
        private final List<Edge>[] adjList;

        @SuppressWarnings("unchecked")
        public Graph(int verticesCount) {
            this.verticesCount = verticesCount;
            this.adjList = new ArrayList[verticesCount];
            for (int i = 0; i < verticesCount; i++) {
                this.adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int fromVertex, int toVertex, int weight) {
            adjList[fromVertex].add(new Edge(toVertex, weight));
        }

        public void dijkstra(int start) {
            int[] distances = new int[verticesCount];
            boolean[] visited = new boolean[verticesCount];

            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[start] = 0;

            for (int i = 0; i < verticesCount; i++) {
                int minDistance = Integer.MAX_VALUE;
                int currentVertex = -1;

                for (int v = 0; v < verticesCount; v++) {
                    if (!visited[v] && distances[v] < minDistance) {
                        minDistance = distances[v];
                        currentVertex = v;
                    }
                }

                if (currentVertex == -1) {
                    break;
                }

                visited[currentVertex] = true;

                for (Edge edge : adjList[currentVertex]) {
                    int neighbor = edge.toVertex;
                    int weight = edge.weight;

                    if (distances[currentVertex] != Integer.MAX_VALUE && distances[currentVertex] + weight < distances[neighbor]) {
                        distances[neighbor] = distances[currentVertex] + weight;
                    }
                }
            }

            System.out.println("--- Dijkstra Algorithm Results (Start Vertex: " + start + ") ---");
            for (int v = 0; v < verticesCount; v++) {
                if (distances[v] == Integer.MAX_VALUE) {
                    System.out.println("Vertex " + v + ": Unreachable");
                } else {
                    System.out.println("Vertex " + v + ": Shortest Distance = " + distances[v]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 3, 4);
        g.addEdge(2, 4, 5);
        g.addEdge(3, 4, 1);

        g.dijkstra(0);
    }
}