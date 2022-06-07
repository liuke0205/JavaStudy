package 笔试真题.Shoope;

public class Main_岛屿计算 {
    public static void main(String[] args) {
        System.out.println(numIslands(new String[][]{}));
    }


    public static int numIslands (String[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ("1".equals(grid[i][j])){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public static void dfs(String[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || "0".equals(grid[i][j])){
            return;
        }
        grid[i][j] = "0";
        dfs(grid, i + 1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
