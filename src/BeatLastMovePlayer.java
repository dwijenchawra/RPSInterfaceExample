public class BeatLastMovePlayer implements Player {
    int opponentPreviousMove;

    public BeatLastMovePlayer() {
        this.opponentPreviousMove = RPS.ROCK;
    }

    @Override
    public int getMove() {
        return opponentPreviousMove;
    }

    @Override
    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        this.opponentPreviousMove = opponentMove;
    }
}
