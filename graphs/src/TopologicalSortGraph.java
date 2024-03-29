import java.util.ArrayList;
import java.util.Stack;

// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering.
// Topological Sorting for a graph is not possible if the graph is not a DAG.
// Refer to TopologicalSorting.png for Algo
class TopologicalSortGraph
{
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSortGraph(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    void addEdge(int v,int w) { adj.get(v).add(w); }

    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for(int i=0; i< V; i++) {
            if(!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    void topologicalSortUtil(
            int v, boolean visited[],
            Stack<Integer> stack)
    {
        visited[v] = true;
        for (Integer cur : adj.get(v)) {
            if(!visited[cur]) {
                topologicalSortUtil(cur, visited, stack);
            }
        }
        stack.push(v);
    }

    public static void main(String args[])
    {
        TopologicalSortGraph g = new TopologicalSortGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(
                "Following is a Topological " +
                        "sort of the given graph");
        g.topologicalSort();
    }
}
