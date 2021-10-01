package arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (!set.add(board[j][i]) && board[j][i] != '.') return false;
            }
            set = new HashSet<>();
        }
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (!set.add(board[i][j]) && board[i][j] != '.') return false;
            }
            set = new HashSet<>();
        }

        for (int j = 0; j < board[0].length; j = j + 3) {
            for (int i = 0; i < board.length; i = i + 3) {

                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (!set.add(board[k][l]) && board[k][l] != '.'){
                            return false;
                        }
                    }
                }
                set = new HashSet<>();

            }
        }
        return true;
    }
}
