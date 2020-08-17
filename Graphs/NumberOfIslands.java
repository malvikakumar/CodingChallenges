public class NumberOfIslands {
    private int height;
    private int width;

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        System.out.println("Number of islands is " + new NumberOfIslands().noOfIslands(grid));
    }

    private int noOfIslands(int[][] grid){
        height = grid.length;

        if(height <= 0 ){
            return 0;
        }

        width = grid[0].length;

        if(width <= 0){
            return 0;
        }

        int count = 0;
        boolean[][] visited = new boolean[height][width];

        for(int i = 0; i < height; i++){
            for(int j = 0; j< width; j++){
                  if(grid[i][j] == 1){
                      count ++;
                      DFSMarkNeighbors(grid, visited, i, j);
                  }
            }
        }
        return count;
    }

    private void DFSMarkNeighbors(int[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i >=height || j>= width ){
            return;
        }
        if(grid[i][j] != 1){
            return;
        }
        if(visited[i][j] == true){
            return;
        }
        visited[i][j] =true;
        grid[i][j] = 0;
        DFSMarkNeighbors(grid, visited, i-1, j);
        DFSMarkNeighbors(grid, visited, i+1, j);
        DFSMarkNeighbors(grid, visited, i, j-1);
        DFSMarkNeighbors(grid, visited, i, j+1);
    }

}
