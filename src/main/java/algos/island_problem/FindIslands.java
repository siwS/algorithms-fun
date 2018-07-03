package algos.island_problem;

/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 *
 * Input : mat[][] = {{0, 1, 1, 0, 0},
 *                    {0, 1, 0, 0, 1},
 *                    {1, 0, 0, 1, 1},
 *                    {0, 0, 0, 0, 0},
 *                    {1, 0, 1, 0, 1},
 * Output : 5
 * Complexity is O(ROW * COLUMNS)
 */

public class FindIslands {

    private static boolean within_boundaries(int x, int y, int lengthX, int lengthY) {
        return x >= 0 && x < lengthX && y >= 0 && y < lengthY;
    }

    private static void move(int[][] matrix, boolean[][] visited, int x, int y) {
        if (within_boundaries(x, y, matrix.length, matrix[0].length) && !visited[x][y]) {
            DFS(matrix, visited, x, y);
        }
    }

    private static void DFS(int[][] matrix, boolean[][] visited, int x, int y) {
        if (visited[x][y])
            return;

        System.out.println("Visiting node x=" + x + " y=" + y);
        visited[x][y] = true;

        if (matrix[x][y]==0) {
            return;
        }

        move(matrix, visited, x-1, y-1);
        move(matrix, visited, x-1, y);
        move(matrix, visited, x-1, y+1);
        move(matrix, visited, x, y-1);
        move(matrix, visited, x, y+1);
        move(matrix, visited, x+1, y-1);
        move(matrix, visited, x+1, y);
        move(matrix, visited, x+1, y+1);
    }

    private static int calculate_islands(int[][] matrix){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int how_many_dfs = 0;

        for (int i=0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j]==1) {
                    DFS(matrix, visited, i, j);
                    how_many_dfs++;
                }
            }
        }
        return how_many_dfs;
    }

    public static void main(String[] args) {
        int[][] matrix =   {{1, 1, 0, 0, 0},
                            {0, 1, 0, 0, 1},
                            {1, 0, 0, 1, 1},
                            {0, 0, 0, 0, 0},
                            {1, 0, 0, 1, 1},
                            {0, 0, 0, 0, 0},
                            {1, 0, 0, 1, 1},
                            {0, 1, 0, 0, 1},
                            {1, 0, 1, 0, 1}};


        int number_of_islands = calculate_islands(matrix);
        System.out.println(number_of_islands);
    }
}
