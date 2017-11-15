import java.util.ArrayList;

public class DirectedDFS {
    private boolean marked[];

    public DirectedDFS(DiGraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(DiGraph G, ArrayList<Integer> vertices) {
        marked = new boolean[G.V()];
        for (int v : vertices) {
            if (!marked[v]) { dfs(G, v); }
        }
    }

    private void dfs(DiGraph G, int s) {
        marked[s] = true;
        ArrayList<Integer> adj = G.adj(s);
        for (int v : adj) {
            if (!marked[v]) { dfs(G, v); }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}