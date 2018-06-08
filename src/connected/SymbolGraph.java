package connected;

import java.util.ArrayList;
import java.util.TreeMap;

public class SymbolGraph {

    private final TreeMap<String, Integer> nameToIndexMap;
    private final String[] keys;
    private final Graph graph;

    public SymbolGraph(String filename) {
        nameToIndexMap = new TreeMap<>();

        ArrayList<String> fileContents = FileRead.readFile(filename);

        int size = fileContents.size();
        for (int j = 0; j < size; j++) {
            String[] splitLine = fileContents.get(j).split(",");
            for (int i = 0; i < splitLine.length; i++) {
                if (!nameToIndexMap.containsKey(splitLine[i].trim())) {
                    nameToIndexMap.put(splitLine[i].trim(), nameToIndexMap.size());
                }
            }
        }

        // Relate vertice names to indexes
        keys = new String[nameToIndexMap.size()];
        for (String name : nameToIndexMap.keySet()) {
            keys[nameToIndexMap.get(name)] = name;
        }

        graph = new Graph(nameToIndexMap.size());


        // Add the edges to the graph
        for (int j = 0; j < size; j++) {
            String[] splitLine = fileContents.get(j).split(",");
            int v = nameToIndexMap.get(splitLine[0].trim());
            for (int i = 1; i < splitLine.length; i++) {
                int w = nameToIndexMap.get(splitLine[i].trim());
                graph.addEdge(v, w);
            }
        }
    }

    public boolean contains(String s) {
//        System.out.println("Searching for  " + s);
        return nameToIndexMap.containsKey(s);
    }

    public int indexOf(String vertexName) {
        return nameToIndexMap.get(vertexName);
    }

    public String nameOf(int vertexIndex) {
        validateVertex(vertexIndex);
        return keys[vertexIndex];
    }

    public Graph graph() {
        return graph;
    }

    private void validateVertex(int vertex) {
        int vertexCount = graph.getNumberOfVertices();
        if (vertex < 0 || vertex >= vertexCount) {
            throw new IllegalArgumentException("Illegal vertex " + vertex);
        }
    }

}
