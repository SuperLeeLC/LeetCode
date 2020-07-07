import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : lichao
 * @date : 2020/7/5 4:41 下午
 */

public class Solution {

    private List<List<String>> res;

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<>();
        putQueue(n, 0, row);

        return res;
    }

    // 尝试在一个 n 皇后问题中，摆放第 index 行的皇后位置
    private void putQueue(int n, int index, LinkedList<Integer> row) {

        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第 index 行的皇后摆放在第 i 列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                putQueue(n, index + 1, row);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }
        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {

        assert row.size() == n;

        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for(List<String> board: res) {
            printBoard(board);
        }
    }
}
