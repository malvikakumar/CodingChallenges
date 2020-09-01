package Graphs;
import java.util.*;

public class ShortestPathInWeightedGraph {
    /*
    BFS Solution - modified

    Need below structures:
    Queue - int[]
    visited - boolean[]
    weight - int[] - to store min path of each vertex after calculating it
    path - store weight of each edge - can be matrix

    Core solution :

    Queue q = new Queue();
    boolean[] visited = new boolean[];
    int[] weight = new int[];

    Arrays.fill(weight, -1);
    q.add(source);
    visited[source] = true;

    while(!q.isEmpty()) {
        int cur = q.remove();
        int min = Integer.MAX_VALUE;
        cur.forEach(v => {
            if(!visited) {
                q.add(v);
                visited[v] = true;
            } else if(weight[v] != -1) {
                // Above condition to avoid considering vertices whose weight we didn't yet calculate
                weight[cur] = Math.min(min, weight[v]+path[v][cur]);
            }
        });
    }
    return weight[destination];
     */
}
