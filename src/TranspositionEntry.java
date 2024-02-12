
public class TranspositionEntry {
    private final int score;
    private final int turn;

    public TranspositionEntry(int score, int turn) {
        this.score = score;
        this.turn = turn;
    }

    public int getScore() {
        return score;
    }

    public int getTurn() {
        return turn;
    }
}