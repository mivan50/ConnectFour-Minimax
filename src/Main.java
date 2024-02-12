import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int turn = 1;
        boolean gameEnd = false;
        char[][] gameBoard = new char[6][7];
        Board.initialiseBoard(gameBoard);
        char currPlayer;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to go first or second");
        String ans = scanner.next();
        if (ans.equals("first")) {
            currPlayer = 'Y';
        }
        else {
            currPlayer = 'R';
        }

        while (!gameEnd) {
            Board.display(gameBoard);

            if (currPlayer == 'Y') {
                System.out.println("Choose where to place disc");
                int playerCol = scanner.nextInt();
                while (playerCol > 6 || playerCol < 0 || gameBoard[0][playerCol] != ' ') {
                    System.out.println("That is not available!");
                    System.out.println("Choose where to place token");
                    playerCol = scanner.nextInt();
                }
                Board.placePlayerDisc(gameBoard, playerCol);
            }
            else {
                System.out.println("Computer move!");
                int[] compMove = Minimax.findBestMove(gameBoard, turn);
                gameBoard[compMove[0]][compMove[1]] = 'R';
            }

            char winner = Board.checkWinner(gameBoard);
            ++turn;

            if (winner != ' ') {
                Board.display(gameBoard);
                if (winner == 'Y') {
                    System.out.println("Player has won!");
                }
                else {
                    System.out.println("Computer has won!");
                }
                gameEnd = true;
            }
            else if (turn == 43) {
                Board.display(gameBoard);
                System.out.println("It's a tie!");
                gameEnd = true;
            }

            if (currPlayer == 'Y') {
                currPlayer = 'R';
            }
            else {
                currPlayer = 'Y';
            }
        }
    }
}