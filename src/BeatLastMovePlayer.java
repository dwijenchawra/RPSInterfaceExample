public class BeatLastMovePlayer implements Player {
    private int opponentPreviousMove;

    public BeatLastMovePlayer() {
        this.opponentPreviousMove = RPS.PAPER;
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
