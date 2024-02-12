public class Board {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[93m";

    public static void initialiseBoard(char[][] board) {
        for (int i=0; i<ROWS; ++i) {
            for (int j=0; j<COLS; ++j) {
                board[i][j] = ' ';
            }
        }
    }

    public static void display(char[][] grid) {
        for (int i = 0; i < COLS; i++) {
            System.out.print("+---");
        }
        System.out.println("+");

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print("| " + getColour(grid[row][col]) + grid[row][col] + " " + RESET);
            }
            System.out.println("|");

            for (int j = 0; j < COLS; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }

        System.out.print("  ");
        for (int i=0; i<7; ++i) {
            System.out.print(i + "   ");
        }
        System.out.println();
    }

    private static String getColour(char token) {
        return switch (token) {
            case 'R' -> RED;
            case 'Y' -> YELLOW;
            default -> "";
        };
    }

    public static void placePlayerDisc(char[][] board, int col) {
        for (int i = 5; i >= 0; --i) {
            if (board[i][col] == ' ') {
                board[i][col] = 'Y';
                break;
            }
        }
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char checkWinner(char[][] board) {
        // Check horizontal
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                char winner = checkFour(board[row][col], board[row][col + 1], board[row][col + 2], board[row][col + 3]);
                if (winner != ' ') {
                    return winner;
                }
            }
        }

        // Check vertical
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                char winner = checkFour(board[row][col], board[row + 1][col], board[row + 2][col], board[row + 3][col]);
                if (winner != ' ') {
                    return winner;
                }
            }
        }

        // Check diagonal (from top-left to bottom-right)
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                char winner = checkFour(board[row][col], board[row + 1][col + 1], board[row + 2][col + 2], board[row + 3][col + 3]);
                if (winner != ' ') {
                    return winner;
                }
            }
        }

        // Check diagonal (from bottom-left to top-right)
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                char winner = checkFour(board[row][col], board[row - 1][col + 1], board[row - 2][col + 2], board[row - 3][col + 3]);
                if (winner != ' ') {
                    return winner;
                }
            }
        }

        return ' ';
    }

    private static char checkFour(char a, char b, char c, char d) {
        if (a == b && a == c && a == d && a != ' ') {
            return a;
        }
        return ' ';
    }
}