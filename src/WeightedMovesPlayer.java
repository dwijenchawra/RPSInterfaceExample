import java.util.ArrayList;

public class WeightedMovesPlayer implements Player {
    ArrayList<Integer> opponentsLast10Moves = new ArrayList<Integer>();


    public int getMove() {
        return 0;
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        opponentsLast10Moves.add(opponentMove);

    }
}
