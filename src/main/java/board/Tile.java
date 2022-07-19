package board;

import java.util.HashMap;
import java.util.Map;

import pieces.Piece;
import com.google.common.collect.ImmutableMap;

public abstract class Tile {
    protected final int coordinate;

    private final Map<Integer, EmptyTile> EMPTY_TILES = generateAllPossibleEmptyTile();

    private Map<Integer, EmptyTile> generateAllPossibleEmptyTile() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for (var i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public final Tile createTile(final int coordinate, final Piece piece) {
        return piece != null ? new OcupiedTile(coordinate, piece) : EMPTY_TILES.get(coordinate);
    }
    private Tile(int coordinate) {
        this.coordinate = coordinate;
    }

    public abstract boolean isOcupied();
    public abstract Piece getPiece();

    public final class EmptyTile extends Tile {

        private EmptyTile(int coordinate) {
            super(coordinate);
        }

        @Override
        public boolean isOcupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }

    public final class OcupiedTile extends Tile {

        private final Piece pieceOnTile;

        private OcupiedTile(final int coordinate, final Piece pieceOnTile) {
            super(coordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isOcupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }
}
