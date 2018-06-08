package connected;

import java.util.ArrayDeque;

public class SearchForPaths {
    private final boolean[] hasPath; 

    public SearchForPaths(Graph graph, int s) {
        hasPath = new boolean[graph.getNumberOfVertices()];
        validateVertex(s);
        searchGraph(graph, s);
    }

    private void searchGraph(Graph graph, int s) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        hasPath[s] = true;
        q.push(s);

        while (!q.isEmpty()) {
            int v = q.pop();
            for (int w : graph.adj(v)) {
                if (!hasPath[w]) {
                    hasPath[w] = true;
                    q.push(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return hasPath[v];
    }

    private void validateVertex(int v) {
        int numberOfVertices = hasPath.length;
        if (v < 0 || v >= numberOfVertices)
            throw new IllegalArgumentException("Illegal vertex");
    }

}
