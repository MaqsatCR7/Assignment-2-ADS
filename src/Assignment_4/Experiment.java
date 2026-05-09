package Assignment_4;

import java.util.Random;

public class Experiment {

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100}; // Талап етілген өлшемдер

        for (int size : sizes) {
            System.out.println("\n--- Testing Graph Size: " + size + " ---");
            Graph g = createRandomGraph(size);
            runTraversals(g, 0, size <= 10); // Тек кіші граф үшін аралау ретін шығарамыз
        }
    }

    private Graph createRandomGraph(int vertices) {
        Graph g = new Graph();
        for (int i = 0; i < vertices; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < vertices * 1.5; i++) {
            int from = rand.nextInt(vertices);
            int to = rand.nextInt(vertices);
            if (from != to) g.addEdge(from, to);
        }
        return g;
    }

    public void runTraversals(Graph g, int startNode, boolean printOrder) {
        // BFS өлшеу
        long startTime = System.nanoTime();
        if (printOrder) System.out.print("BFS Order: ");
        g.bfs(startNode);
        long endTime = System.nanoTime();
        System.out.println("\nBFS Time: " + (endTime - startTime) + " ns");

        // DFS өлшеу
        startTime = System.nanoTime();
        if (printOrder) System.out.print("DFS Order: ");
        g.dfs(startNode);
        endTime = System.nanoTime();
        System.out.println("\nDFS Time: " + (endTime - startTime) + " ns");
    }
}