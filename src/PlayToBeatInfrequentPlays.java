import java.util.ArrayList;

public class PlayToBeatInfrequentPlays implements Player {
    private ArrayList<Integer> opponentMovesFrequency; // 0 is rock, 1 is paper, 2 is scissors
    private ArrayList<Integer> opponentMoves;
    private int totalMoves;
    private int numToRemember;

    public PlayToBeatInfrequentPlays(int n) {
        this.opponentMovesFrequency = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            opponentMovesFrequency.add(0);
        }
        this.totalMoves = 0;
        this.numToRemember = n;
        this.opponentMoves = new ArrayList<>();
    }


    @Override
    public int getMove() {
        return generateMove(opponentMovesFrequency, totalMoves);
    }

    private int generateMove(ArrayList<Integer> moves, double totalMoves) {
        double move = Math.random();

        double rockFreq = moves.get(0) / totalMoves;
        double paperFreq = moves.get(1) / totalMoves;
        double scissorsFreq = moves.get(2) / totalMoves;
        // System.out.println(rockFreq + " " + scissorsFreq + " " + paperFreq);
        System.out.println(opponentMoves);
        if (totalMoves >= numToRemember) {
            if (opponentMoves.get(0) == 0) {
                opponentMovesFrequency.set(0, opponentMovesFrequency.get(0) - 1);
            } else if (opponentMoves.get(0) == 1) {
                opponentMovesFrequency.set(1, opponentMovesFrequency.get(1) - 1);
            } else {
                opponentMovesFrequency.set(2, opponentMovesFrequency.get(2) - 1);
            }
            opponentMoves.remove(0);
        }

        if (paperFreq < rockFreq && paperFreq < scissorsFreq) {
            return RPS.SCISSORS;
        } else if (rockFreq < paperFreq && rockFreq < scissorsFreq) {
            return RPS.PAPER;
        } else if (scissorsFreq < paperFreq && scissorsFreq < rockFreq) {
            return RPS.ROCK;
        } else {
            if (totalMoves > 0) {
                if (opponentMoves.get(opponentMoves.size() - 1) == RPS.ROCK) {
                    return RPS.PAPER;
                } else if (opponentMoves.get(opponentMoves.size() - 1) == RPS.SCISSORS) {
                    return RPS.ROCK;
                } else {
                    return RPS.SCISSORS;
                }
            }
        }
        return RPS.ROCK;
    }

    @Override
    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        if (opponentMove == RPS.ROCK) {
            opponentMovesFrequency.set(0, opponentMovesFrequency.get(0) + 1);
        } else if (opponentMove == RPS.PAPER) {
            opponentMovesFrequency.set(1, opponentMovesFrequency.get(1) + 1);
        } else {
            opponentMovesFrequency.set(2, opponentMovesFrequency.get(2) + 1);
        }
        totalMoves++;
        opponentMoves.add(opponentMove);
    }
}
