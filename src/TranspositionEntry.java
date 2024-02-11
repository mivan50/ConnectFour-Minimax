
public class TranspositionEntry {
    private final int score;
    private final int depth;

    public TranspositionEntry(int score, int depth) {
        this.score = score;
        this.depth = depth;
    }

    public int getScore() {
        return score;
    }

    public int getDepth() {
        return depth;
    }
}