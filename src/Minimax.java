import java.util.HashMap;
import java.util.Map;

public class Minimax {
    // Transposition table to store evaluated positions
    private static Map<String, Integer> transpositionTable = new HashMap<>();

    public static int[] findBestMove(char[][] board) {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;

        for (int i = 0; i <= 6; i++) {
            for (int j = 5; j >= 0; j--) {
                if (board[0][i] != ' ') {
                    break;
                }
                if (board[j][i] == ' ') {
                    board[j][i] = 'R';
                    int moveVal = minimax(board, 0, false, alpha, beta);
                    board[j][i] = ' ';
                    if (moveVal > bestVal) {
                        bestMove[0] = j;
                        bestMove[1] = i;
                        bestVal = moveVal;
                    }
                    alpha = Math.max(alpha, bestVal);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
        }

        return bestMove;
    }

    public static int minimax(char[][] board, int depth, boolean isMaximising, int alpha, int beta) {
        String boardString = boardToString(board); // Convert board to string for hash table lookup
        if (transpositionTable.containsKey(boardString)) {
            return transpositionTable.get(boardString); // Return cached value if available
        }

        char winner = Board.checkWinner(board);
        if (winner != ' ') {
            if (winner == 'Y') {
                int score = -43 + depth;
                transpositionTable.put(boardString, score); // Cache the score
                return score;
            }
            else {
                int score = 43 - depth;
                transpositionTable.put(boardString, score); // Cache the score
                return score;
            }
        }
        if (Board.isBoardFull(board)) {
            return 0;
        }

        if (isMaximising) {
            int bestScore = Integer.MIN_VALUE;
            for (int i=0; i<=6; i++) {
                for (int j=5; j>=0; j--) {
                    if (board[0][i] != ' ') {
                        break;
                    }
                    if (board[j][i] == ' ') {
                        board[j][i] = 'R';
                        int score = minimax(board, depth + 1, false, alpha, beta);
                        board[j][i] = ' ';
                        bestScore = Math.max(bestScore, score);
                        alpha = Math.max(alpha, bestScore);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            transpositionTable.put(boardString, bestScore); // Cache the score
            return bestScore;
        }
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int i=0; i<=6; i++) {
                for (int j=5; j>=0; j--) {
                    if (board[0][i] != ' ') {
                        break;
                    }
                    if (board[j][i] == ' ') {
                        board[j][i] = 'Y';
                        int score = minimax(board, depth + 1, true, alpha, beta);
                        board[j][i] = ' ';
                        bestScore = Math.min(bestScore, score);
                        beta = Math.min(beta, bestScore);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            transpositionTable.put(boardString, bestScore); // Cache the score
            return bestScore;
        }
    }

    // Utility method to convert board to string for hash table lookup
    private static String boardToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}
