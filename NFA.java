import java.util.Stack;
import java.util.ArrayList;

public class NFA {
    private char[] re; //holds the characters in the regular expression
    private DiGraph G; // holds the epsilon transitions as a directed graph
    private int M; // length of the regular expression

    public NFA(String regexp) {
        M = regexp.length();
        re = regexp.toCharArray();
        G = buildEpsilonTransitionGraph();
    }

    // builds a directed graph from all the epsilon transitions present in the NFA
    private DiGraph buildEpsilonTransitionGraph() {
        DiGraph G = new DiGraph(M+1); // one extra state as the accept state
        Stack<Integer> op = new Stack<Integer>();
        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') {
                op.push(i);
            }
            else if (re[i] == ')') {
                int or = op.pop();
                if (re[or] == '|') {
                    lp = op.pop();
                    G.addEdge(or, i);
                    G.addEdge(lp, or+1);
                }
                else { lp = or; }
            }
            if (i < M-1 && re[i+1] == '*') {
                G.addEdge(lp, i+1);
                G.addEdge(i+1, lp);
            }
            if (re[i] == '(' || re[i] == ')' || re[i] == '*') {
                G.addEdge(i, i+1);
            }
        }
        return G;
    }

    public boolean matched(String txt) {
        DirectedDFS dfs = new DirectedDFS(G, 0);
        ArrayList<Integer> reachable = new ArrayList<Integer>();
        for (int i = 0; i < G.V(); i++) {
            if (dfs.marked(i)) {
                reachable.add(i);
            }
        }
        for (int i = 0; i < txt.length(); i++) {
            ArrayList<Integer> match = new ArrayList<Integer>();
            char character = txt.charAt(i);
            for (int v : reachable) {
                if (v == M) { continue; }
                if (re[v] == character) {
                    match.add(v+1);
                }
            }
            dfs = new DirectedDFS(G, match);
            reachable = new ArrayList<Integer>();
            for (int j = 0; j < G.V(); j++) {
                if (dfs.marked(j)) {
                    reachable.add(j);
                }
            }
        }
        for (int v : reachable) {
            if (v == M) { return true; }
        }
        return false;
    }
}