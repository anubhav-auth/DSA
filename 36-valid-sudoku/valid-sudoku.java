public class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[9];
            for (int col = 0; col < 9; col++) {
                char current = board[row][col];
                if (current != '.') {
                    int num = current - '1'; 
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[9];
            for (int row = 0; row < 9; row++) {
                char current = board[row][col];
                if (current != '.') {
                    int num = current - '1';
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                boolean[] seen = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[boxRow + i][boxCol + j];
                        if (current != '.') {
                            int num = current - '1';
                            if (seen[num]) return false;
                            seen[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}