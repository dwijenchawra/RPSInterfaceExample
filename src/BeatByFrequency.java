public class BeatByFrequency implements Player {
    private int[] opponentMoves; // 0 is rock, 1 is paper, 2 is scissors
    private double totalMoves;

    public BeatByFrequency() {
        opponentMoves = new int[3];
        this.totalMoves = 0;
    }

    @Override
    public int getMove() {
        return generateMove(opponentMoves, totalMoves);
    }

    private int generateMove(int[] moves, double totalMoves) {
        double move = Math.random();
        double rockFreq = opponentMoves[0] / totalMoves;
        double paperFreq = opponentMoves[1] / totalMoves;
        double scissorsFreq = opponentMoves[2] / totalMoves;
        if (move < rockFreq) {
            return RPS.PAPER;
        } else if (move >= rockFreq && move < rockFreq + paperFreq) {
            return RPS.SCISSORS;
        } else {
            return RPS.PAPER;
        }
    }

    @Override
    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        if (opponentMove == RPS.ROCK) {
            opponentMoves[0]++;
        } else if (opponentMove == RPS.PAPER) {
            opponentMoves[1]++;
        } else {
            opponentMoves[2]++;
        }
        totalMoves++;
    }
}
