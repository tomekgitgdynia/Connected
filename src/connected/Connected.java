package connected;

/**
 *
 * @author Tom Kowszun
 * 
 */
public class Connected {

    public static void main(String[] args) {
        String filename = args[0];
        String cityA = args[1];
        String cityB = args[2];

        SymbolGraph sg = new SymbolGraph(filename);
        Graph integerGraph = sg.graph();
        if (!sg.contains(cityA)) {
            System.out.println("no");
            return;
        }

        int cityIndexA = sg.indexOf(cityA);
        SearchForPaths searchForPaths = new SearchForPaths(integerGraph, cityIndexA);
        if (sg.contains(cityB)) {
            int cityIndexB = sg.indexOf(cityB);
            if (searchForPaths.hasPathTo(cityIndexB)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } else {
            System.out.println("no");
        }
    }

}
