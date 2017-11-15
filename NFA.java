import java.util.Stack;

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
            if (re[i] == '(' || re[i] == '+') {
                op.push(i);
            }
            else if (re[i] == ')') {
                int or = op.pop();
                if (re[or] == '+') {
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
        DirectedDFS dfs = new DirectedDFS(this.G, 0);
        ArrayList<Integer> reachable = dfs.reachable();
        for (int i = 0; i < txt.length; i++) {
            char character = txt.charAt(i);
            
        }
        return true;
    }
}