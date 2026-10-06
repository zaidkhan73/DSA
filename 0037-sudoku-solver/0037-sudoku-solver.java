import java.util.*;

class Solution {
    // rowUsed[r][d] = true matlab row r me digit d already hai
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][] boxUsed = new boolean[9][10];
    List<int[]> empties = new ArrayList<>(); // khali cells ki list

    public void solveSudoku(char[][] board) {
        // Step 1: board scan karo, used digits mark karo, khali cells collect karo
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    empties.add(new int[]{r, c});
                } else {
                    int d = board[r][c] - '0';
                    rowUsed[r][d] = colUsed[c][d] = boxUsed[(r / 3) * 3 + c / 3][d] = true;
                }
            }
        }
        solve(board, 0);
    }

    private boolean solve(char[][] board, int idx) {
        if (idx == empties.size()) return true; // sab cells bhar gaye

        // MRV: idx se aage ke cells me se sabse kam options wala dhundo
        int best = idx, bestCount = 10;
        for (int i = idx; i < empties.size(); i++) {
            int r = empties.get(i)[0], c = empties.get(i)[1];
            int b = (r / 3) * 3 + c / 3, cnt = 0;
            for (int d = 1; d <= 9; d++)
                if (!rowUsed[r][d] && !colUsed[c][d] && !boxUsed[b][d]) cnt++;
            if (cnt < bestCount) { bestCount = cnt; best = i; }
            if (cnt == 0) return false; // dead end, turant wapas
        }

        Collections.swap(empties, idx, best); // best cell ko idx pe laao
        int r = empties.get(idx)[0], c = empties.get(idx)[1];
        int b = (r / 3) * 3 + c / 3;

        for (int d = 1; d <= 9; d++) {
            if (rowUsed[r][d] || colUsed[c][d] || boxUsed[b][d]) continue;

            // choose
            board[r][c] = (char) ('0' + d);
            rowUsed[r][d] = colUsed[c][d] = boxUsed[b][d] = true;

            if (solve(board, idx + 1)) return true;

            // un-choose (backtrack)
            rowUsed[r][d] = colUsed[c][d] = boxUsed[b][d] = false;
            board[r][c] = '.';
        }

        Collections.swap(empties, idx, best); // swap wapas (order restore)
        return false;
    }
}