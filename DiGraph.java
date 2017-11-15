import java.util.ArrayList;

public class DiGraph {
    private final int V;
    private final ArrayList<Integer>[] adj; //adjacency list

    public DiGraph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public ArrayList<Integer> adj(int v) {
        return adj[v];
    }
}