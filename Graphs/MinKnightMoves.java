package Graphs;

import java.util.*;

public class MinKnightMoves {
    public static void main(String[] args) {

        System.out.println(minPathOfKnight(8,2,1,4,0));
        System.out.println(minPathOfKnight(8,0,0,7,0));
    }

    // Use BFS. Don't use DFS as it gives StackOverflowError
    public static int minPathOfKnight(int n, int startRow, int startCol, int endRow, int endCol) {
        int[][] directions = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

        endRow = Math.abs(endRow);
        endCol = Math.abs(endCol);

        Queue<int[]> queue = new LinkedList<int[]>();
        Set<String> visited = new HashSet<>();
        int count = 0;
        queue.add(new int[] {startRow,startCol});
        visited.add(startRow+","+startCol);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] current = queue.remove();
                int curX = current[0];
                int curY = current[1];
                if (curX == endRow && curY == endCol) {
                    return count;
                }
                for (int[] curIndex : directions) {
                    int newX = curX + curIndex[0];
                    int newY = curY + curIndex[1];
                    if (!visited.contains(newX + "," + newY) && newX >= 0 && newY >= 0 && newX < n && newY < n) {
                        queue.add(new int[] {newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            count++;
        }
    return -1;
    }
}
