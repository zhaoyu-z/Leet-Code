/*
 * @lc app=leetcode.cn id=934 lang=java
 *
 * [934] 最短的桥
 */

// @lc code=start
class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int n;
    // boolean[][] visited;
    int[][] grid;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        // this.visited = new boolean[n][n];

        int startRow = 0, startCol = 0;

        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                    break outerLoop;
                }
            }
        }

        List<int[]> islands = getIsland(startRow, startCol);
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int[] island : islands) {
            queue.offer(island);
        }

        int ans = -1;
        while (!queue.isEmpty()) {
            ans++;
            int numOfIslandCell = queue.size();
            for (int i = 0; i < numOfIslandCell; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (isWater(newRow, newCol)) {
                        queue.offer(new int[]{newRow, newCol});
                        // visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;
                    } else if (isIsland(newRow, newCol)) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    public List<int[]> getIsland(int startRow, int startCol) {
        List<int[]> island = new ArrayList<int[]>();
        // visited[startRow][startCol] = true;
        grid[startRow][startCol] = 2;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{startRow, startCol});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            island.add(cell);
            int row = cell[0], col = cell[1];
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (isIsland(newRow, newCol)) {
                    // visited[newRow][newCol] = true;
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return island;
    }

    public boolean isIsland(int row, int col) {
        // return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 1 && !visited[row][col];
        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 1 && grid[row][col] != 2;
    }

    public boolean isWater(int row, int col) {
        // return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0 && !visited[row][col];
        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0 && grid[row][col] != 2;
    }
}
// @lc code=end

