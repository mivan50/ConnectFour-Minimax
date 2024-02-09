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
                while (playerCol > 6 || playerCol < 0 || Board.isColFull(gameBoard, playerCol)) {
                    System.out.println("That is not available!");
                    System.out.println("Choose where to place token");
                    playerCol = scanner.nextInt();
                }
                Board.placePlayerDisc(gameBoard, playerCol);
            }
            else {

            }
        }
    }
}
