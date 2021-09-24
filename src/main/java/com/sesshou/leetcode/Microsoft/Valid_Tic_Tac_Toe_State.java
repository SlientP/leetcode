package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/7/1 7:32
 * @description：有效的并子游戏
 */
public class Valid_Tic_Tac_Toe_State {
    public static void main(String[] args) {
        Valid_Tic_Tac_Toe_State test = new Valid_Tic_Tac_Toe_State();
        String[] board = new String[]{"XOX", "O O", "XOX"};
        System.out.println(test.validTicTacToeV2(board));
    }

    public boolean validTicTacToe(String[] board) {
        int n = board.length;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int[] dig = new int[2];
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    countX++;
                    rows[i]++;
                    cols[j]++;
                    if (i == j) dig[0]++;
                    if (i + j == n - 1) dig[1]++;
                }
                if (board[i].charAt(j) == 'O') {
                    countO++;
                    rows[i]--;
                    cols[j]--;
                    if (i == j) dig[0]--;
                    if (i + j == n - 1) dig[1]--;
                }
            }
        }
        boolean boolX = false;
        boolean boolO = false;

        for (int i = 0; i < 3; i++) {
            if (!boolO && (cols[i] == -n || rows[i] == -n || dig[0] == -n || dig[1] == -n)) {
                boolO = true;
            }
            if (!boolX && (cols[i] == n || rows[i] == n || dig[0] == n || dig[1] == n)) {
                boolX = true;
            }
        }

        if (countX != countO && countO != countX - 1) return false;
        if (boolX && countO != countX - 1) return false;
        if (boolO && countO != countX) return false;

        return true;
    }

    public boolean validTicTacToeV2(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row: board)
            for (char c: row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }

        if (oCount != xCount && oCount != xCount - 1) return false;
        if (win(board, 'X') && oCount != xCount - 1) return false;
        if (win(board, 'O') && oCount != xCount) return false;
        return true;
    }

    public boolean win(String[] B, char P) {
        // B: board, P: player
        for (int i = 0; i < 3; ++i) {
            if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                return true;
            if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                return true;
        }
        if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
            return true;
        if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
            return true;
        return false;
    }


}
