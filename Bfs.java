package GraphQuestion;
import java.util.*;

public class Bfs {

    // Function to return BFS traversal of given undirected graph
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from node 0
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            // Traverse all adjacent vertices of the dequeued node
            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    // Function to add an edge to the graph
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 5; // Ensure V > 0
        
        //  Correctly initializing adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>()); // Fix: Initialize inner lists
        }
        
        //  Adding edges correctly
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);
        
        // Ensure graph is not empty before calling BFS
            System.out.println("BFS starting from 0:");
            ArrayList<Integer> bfsResult = bfsOfGraph(V, adj);
            System.out.println(bfsResult);
        
    }
}
