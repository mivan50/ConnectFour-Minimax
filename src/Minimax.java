public class Minimax {
    public static int[] findBestMove(char[][] board) {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
        int[] columnOrder = {3, 2, 4, 1, 5, 0, 6};

        for (int i : columnOrder) {
            for (int j = 5; j >= 0; j--) {
                if (board[j][i] == ' ') {
                    board[j][i] = 'R';
                    int moveVal = minimax(board, 0, false);
                    board[j][i] = ' ';
                    if (moveVal > bestVal) {
                        bestMove[0] = j;
                        bestMove[1] = i;
                        bestVal = moveVal;
                    }
                    break;
                }
            }
        }

        return bestMove;
    }

    public static int minimax(char[][] board, int depth, boolean isMaximising) {
        char winner = Board.checkWinner(board);
        if (winner != ' ') {
            if (winner == 'Y') {
                return -43 + depth;
            } else {
                return 43 - depth;
            }
        }
        if (Board.isBoardFull(board) || depth >= 7) {
            return 0;
        }

        int[] columnOrder = {3, 2, 4, 1, 5, 0, 6};

        if (isMaximising) {
            int bestScore = Integer.MIN_VALUE;
            for (int i : columnOrder) {
                for (int j = 5; j >= 0; j--) {
                    if (board[j][i] == ' ') {
                        board[j][i] = 'R';
                        int score = minimax(board, depth + 1, false);
                        board[j][i] = ' ';
                        bestScore = Math.max(bestScore, score);
                        break;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i : columnOrder) {
                for (int j = 5; j >= 0; j--) {
                    if (board[j][i] == ' ') {
                        board[j][i] = 'Y';
                        int score = minimax(board, depth + 1, true);
                        board[j][i] = ' ';
                        bestScore = Math.min(bestScore, score);
                        break;
                    }
                }
            }
            return bestScore;
        }
    }
}
