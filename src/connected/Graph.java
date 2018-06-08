package connected;

import java.util.ArrayList;

public class Graph {

    private final int numberOfVertices;
    private int numberOfEdges;
    private ArrayList<Integer>[] adj;

    public Graph(int verticesCount) {
        if (verticesCount < 0) {
            throw new IllegalArgumentException("Illegal number of vertices");
        }
        this.numberOfVertices = verticesCount;
        this.numberOfEdges = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[verticesCount];
        for (int v = 0; v < verticesCount; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= getNumberOfVertices()) {
            throw new IllegalArgumentException("Illegal number of vertices");
        }
    }

    public void addEdge(int vertexA, int vertexB) {
        validateVertex(vertexA);
        validateVertex(vertexB);
        setNumberOfEdges(getNumberOfEdges() + 1);
        adj[vertexA].add(vertexB);
        adj[vertexB].add(vertexA);
    }

    // Vertices adjacent to vertex specified
    public Iterable<Integer> adj(int vertex) {
        validateVertex(vertex);
        return adj[vertex];
    }

    /**
     * @return the numberOfEdges
     */
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    /**
     * @param numberOfEdges the numberOfEdges to set
     */
    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    /**
     * @return the numberOfVertices
     */
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

}
