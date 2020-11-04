package ArraysAndStrings;

public class Rotate2DArray {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
    
        // transpose matrix
        for (int i = 0; i < n; i++) {
          for (int j = i; j < n; j++) {
            int tmp = matrix[j][i];
            matrix[j][i] = matrix[i][j];
            matrix[i][j] = tmp;
          }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n / 2; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[i][n - j - 1];
            matrix[i][n - j - 1] = tmp;
          }
        }
      }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[0].length; j++) {
                System.out.print(a[i][j]+" , ");
            }
            System.out.println();
        }
    }
}

// TC: O(n); SC: O(1)