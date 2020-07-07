/**
 * @author : lichao
 * @date : 2020/7/4 10:30 下午
 */

public class Solution {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || word == null) {
            throw new IllegalArgumentException("board or word can not be null");
        }

        m = board.length;
        if (m == 0) {
            throw new IllegalArgumentException("board can not be empty");
        }

        n = board[0].length;
        if (n == 0) {
            throw new IllegalArgumentException("board can not be empty");
        }

        visited = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 从 board[startX][startY] 开始，寻找 word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {

        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {

            visited[startX][startY] = true;

            // 从 startX startY 出发，向 4 个方向寻找
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] &&
                        searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
