package pieces;

import board.Board;
import board.Move;

import java.util.List;

public abstract class Piece {
    protected final int piecePos;
    protected final Alliance pieceAlliance;


    public Piece(final int piecePos, final Alliance pieceAlliance) {
        this.piecePos = piecePos;
        this.pieceAlliance = pieceAlliance;
    }

    public abstract List<Move> calLegalMoves(Board board);
    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    };
}
