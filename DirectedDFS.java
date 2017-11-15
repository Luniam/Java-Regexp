import java.util.ArrayList;

public class DirectedDFS {
    private ArrayList<Integer> reachable;

    public DirectedDFS(DiGraph G, int s) {
        reachable = new ArrayList<Integer>();
        dfs(G, s);
    }

    public DirectedDFS(DiGraph G, ArrayList<Integer> vertices) {
        reachable = new ArrayList<Integer>();
        for (int i = 0; i < vertices.size(); i++) {
            dfs(G, vertices.get(i));
        }
    }

    private void dfs(DiGraph G, int s) {
        ArrayList<Integer> adj = G.adj(s);
        for (int i = 0; i < adj.size(); i++) {
            if (!reachable.contains(adj.get(i))) {
                dfs(G, adj.get(i));
                reachable.add(adj.get(i));
            }
        }
    }

    public boolean marked(int v) {
        return reachable.contains(v);
    }

    public ArrayList<Integer> reachable() {
        return this.reachable();
    }
}