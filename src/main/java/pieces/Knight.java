package pieces;

import board.Board;
import board.Move;
import board.Tile;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    final int[] CANDIDATE_LEGAL_MOVES = { -6, -10, -15, -17, 6, 10, 15, 17 };

    public Knight(final int piecePos, final Alliance pieceAlliance) {
        super(piecePos, pieceAlliance);
    }

    @Override
    public final List<Move> calLegalMoves(Board board) {
        final List<Move> candidateMoves = new ArrayList<>();
        for (int candidateMove : CANDIDATE_LEGAL_MOVES) {
            int candidateCoordiante = this.piecePos + candidateMove;
            if (candidateCoordiante >= 64 || candidateCoordiante < 0) {
                Tile candidateTile = Board.getTile(candidateCoordiante);
                if (!candidateTile.isOcupied()) {
                    candidateMoves.add(new Move());
                } else {
                    if (candidateTile.getPiece().getPieceAlliance() != this.pieceAlliance) {
                        candidateMoves.add(new Move());
                    }
                }
            }
        }
        return candidateMoves;
    }



}
