public class Board {
    private static final int rows = 6;
    private static final int col = 7;

    public static void initialiseBoard(char[][] board) {
        for (int i=0; i<rows; ++i) {
            for (int j=0; j<col; ++j) {
                board[i][j] = ' ';
            }
        }
    }

    public static void display(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Print the top border
        for (int i = 0; i < numCols; i++) {
            System.out.print("+---");
        }
        System.out.println("+");

        // Print grid contents
        for (int row = 0; row < numRows; row++) {
            // Print row content and vertical lines
            for (int col = 0; col < numCols; col++) {
                System.out.print("| " + grid[row][col] + " ");
            }
            System.out.println("|");

            // Print horizontal lines between rows
            for (int j = 0; j < numCols; j++) {
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

    public static boolean isColFull(char[][] board, int col) {
        if (board[0][col] != ' ') {
            return true;
        }
        return false;
    }

    public static void placePlayerDisc(char[][] board, int col) {
        for (int i = 5; i >= 0; --i) {
            if (board[i][col] == ' ') {
                board[i][col] = 'Y';
                break;
            }
        }
    }
}
