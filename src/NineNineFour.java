/*
In a given grid, each cell can have one of three values:

        the value 0 representing an empty cell;
        the value 1 representing a fresh orange;
        the value 2 representing a rotten orange.
        Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

        Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



        Example 1:



        Input: [[2,1,1],[1,1,0],[0,1,1]]
        Output: 4
        Example 2:

        Input: [[2,1,1],[0,1,1],[1,0,1]]
        Output: -1
        Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
        Example 3:

        Input: [[0,2]]
        Output: 0
        Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

*/

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NineNineFour {
    @Test
    public void testImplIn1() {
        int[][] input= {{2,1,1},{1,1,0},{0,1,1}};

        int time = orangesRotting(input);
        Assert.assertEquals(4, time);
    }
    @Test
    public void testImplIn2() {
        int[][] input= {{0,2}};

        int time = orangesRotting(input);
        Assert.assertEquals(0, time);
    }

    @Test
    public void testImplIn3() {
        int[][] input= {{2,1,1},{0,1,1},{1,0,1}};

        int time = orangesRotting(input);
        Assert.assertEquals(-1, time);
    }
    public int orangesRotting(int[][] grid) {
        int minute = 0;
        int notRottenOranges = 0;
        Queue<int[]> rottenOranges = new LinkedList<>();
        int rows = grid.length;
        int columns = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if(grid[row][column] == 2)
                    rottenOranges.add(new int[]{row, column});
                if(grid[row][column] == 1)
                    notRottenOranges++;
            }
        }

        int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};

        while (!rottenOranges.isEmpty()){
            Queue<int[]> newRottenOranges = new LinkedList<>();

            while (!rottenOranges.isEmpty()){
                int[] coordinate = rottenOranges.poll();
                for (int[] direction : directions) {
                    int newRow = coordinate[0] + direction[0];
                    int newColumn = coordinate[1] + direction[1];

                    if (0<=newRow && newRow<rows && 0<=newColumn && newColumn<columns && grid[newRow][newColumn] == 1 ){
                        newRottenOranges.add(new int[]{newRow, newColumn});
                        grid[newRow][newColumn] = 2;
                        notRottenOranges --;
                    }
                }
            }
            if (!newRottenOranges.isEmpty()) {
                rottenOranges = newRottenOranges;
                minute++;
            }
        }


        return notRottenOranges != 0 ? -1:minute;
    }
}
