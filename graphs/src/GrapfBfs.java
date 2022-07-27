import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GrapfBfs {
    private int vertices;  // number of vertices
    private List<List<Integer>> adj;
    private boolean DfsVisited[];

    GrapfBfs(int v){
        vertices = v;
        adj = new ArrayList<List<Integer>>();
        for (int i=0; i<v; ++i) {
            adj.add(i, new LinkedList<Integer>());
        }
        DfsVisited = new boolean[vertices];
    }

    // Add an edge to the graph
    void addEdge(int source, int destinaton){
        adj.get(source).add(destinaton);
//        adj[v1].addFirst();
    }

    // Driver method to
    public  static void main(String args[]){
        GrapfBfs g = new GrapfBfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        g.DFS(2);
    }

    public void BFS(int root){
        //Mark all vertices as not visited
        boolean[] visited = new boolean[vertices];
        // create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        visited[root] = true;
        queue.add(root);

        while (!queue.isEmpty()){
            // deque the vertex
            root = queue.remove();
            System.out.println(root);

            // Get all adjacent vertices of the dequeued vertex root
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            adj.get(root).forEach(e -> {
                if (!visited[e])
                {
                    visited[e] = true;
                    queue.add(e);
                }
            });
        }
    }

    public void DFS(int curNode){
        DfsVisited[curNode] = true;
        System.out.println(curNode);

        adj.get(curNode).forEach(e -> {
            if(!DfsVisited[e]){
                DFS(e);
            }
        });
    }

}
