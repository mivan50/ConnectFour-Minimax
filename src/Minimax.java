import java.util.HashMap;

public class Minimax {
    // Define a transposition table
    private static final HashMap<String, TranspositionEntry> transpositionTable = new HashMap<>();

    public static int[] findBestMove(char[][] board) {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};
        int[] columnOrder = {3, 2, 4, 1, 5, 0, 6};

        for (int i : columnOrder) {
            int j = getEmptySpace(board, i);
            if (j != -1) {
                board[j][i] = 'R';
                int moveVal = minimax(board, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
                board[j][i] = ' ';
                if (moveVal > bestVal) {
                    bestMove[0] = j;
                    bestMove[1] = i;
                    bestVal = moveVal;
                }
            }
        }

        return bestMove;
    }

    public static int minimax(char[][] board, int depth, int alpha, int beta, boolean isMaximising) {
        // Generate a unique key for the current board state
        String boardKey = boardToString(board);

        // Check if the board state is already stored in the transposition table
        if (transpositionTable.containsKey(boardKey)) {
            TranspositionEntry entry = transpositionTable.get(boardKey);
            if (depth - entry.getDepth() <= 6) {
                return entry.getScore();
            }
        }

        char winner = Board.checkWinner(board);
        if (winner != ' ') {
            if (winner == 'Y') {
                return -43 + depth;
            } else {
                return 43 - depth;
            }
        }
        if (Board.isBoardFull(board) || depth >= 15) {
            return 0;
        }

        int[] columnOrder = {3, 2, 4, 1, 5, 0, 6};

        if (isMaximising) {
            int bestScore = Integer.MIN_VALUE;
            for (int i : columnOrder) {
                int j = getEmptySpace(board, i);
                if (j != -1) {
                    board[j][i] = 'R';
                    int score = minimax(board, depth + 1, alpha, beta, false);
                    board[j][i] = ' ';
                    bestScore = Math.max(bestScore, score);
                    alpha = Math.max(alpha, bestScore);
                    if (beta <= alpha)
                        break;
                }
            }
            transpositionTable.put(boardKey, new TranspositionEntry(bestScore, depth)); // Store the board state and its score in the transposition table
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i : columnOrder) {
                int j = getEmptySpace(board, i);
                if (j != -1) {
                    board[j][i] = 'Y';
                    int score = minimax(board, depth + 1, alpha, beta, true);
                    board[j][i] = ' ';
                    bestScore = Math.min(bestScore, score);
                    beta = Math.min(beta, bestScore);
                    if (beta <= alpha)
                        break;
                }
            }
            transpositionTable.put(boardKey, new TranspositionEntry(bestScore, depth)); // Store the board state and its score in the transposition table
            return bestScore;
        }
    }

    private static int getEmptySpace(char[][] board, int col) {
        for (int i = 5; i >= 0; --i) {
            if (board[i][col] == ' ') {
                return i;
            }
        }
        return -1;
    }

    private static String boardToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}
