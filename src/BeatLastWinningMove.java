public class BeatLastWinningMove implements Player {
    private int lastWinningMove;

    public BeatLastWinningMove() {
        this.lastWinningMove = RPS.ROCK;
    }

    @Override
    public int getMove() {
        if (lastWinningMove == RPS.ROCK) {
            return RPS.PAPER;
        } else if (lastWinningMove == RPS.SCISSORS) {
            return RPS.ROCK;
        } else {
            return RPS.SCISSORS;
        }
    }

    @Override
    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        if (outcome == RPS.OPPONENT) {
            lastWinningMove = opponentMove;
        } else {
            lastWinningMove = yourMove;
        }
    }
}
