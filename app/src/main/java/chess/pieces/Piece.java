package chess.pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public abstract class Piece {
    public static Piece create(Type type, Color color) {
        return switch (type) {
            case KING -> new King(type, color);
            case QUEEN -> new Queen(type, color);
            case PAWN -> new Pawn(type, color);
            case ROOK -> new Rook(type, color);
            case BISHOP -> new Bishop(type, color);
            case KNIGHT -> new Knight(type, color);
            case NO_PIECE -> Blank.getBlank();
        };
    }

    protected Type type;
    protected final Color color;

    protected Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public abstract Set<Position> getValidMoves(Position from, Board board);

    protected Set<Position> slidingMoves(Position from, Board board, List<Direction> directions) {
        Set<Position> validMoves = new HashSet<>();

        for (Direction direction : directions) {
            int newRank = from.rank + direction.getRankDelta();
            int newFile = from.file + direction.getFileDelta();

            if (newRank < 0 || newRank >= Board.SIZE || newFile < 0 || newFile >= Board.SIZE) {
                continue;
            }

            Position to = new Position(newRank, newFile);
            Piece piece = board.findPiece(to);
            if (piece.getColor() == this.color) {
                continue;
            }

            validMoves.add(new Position(newRank, newFile));
        }
        return validMoves;
    }

    protected Set<Position> steppingMoves(Position from, Board board, List<Direction> directions) {
        Set<Position> validMoves = new HashSet<>();

        for (Direction direction : directions) {
            for (int dist = 1; dist <= Board.SIZE; dist++) {
                int newRank = from.rank + direction.getRankDelta() * dist;
                int newFile = from.file + direction.getFileDelta() * dist;

                if (newRank < 0 || newRank >= Board.SIZE || newFile < 0 || newFile >= Board.SIZE) {
                    break;
                }

                Position to = new Position(newRank, newFile);
                Piece piece = board.findPiece(to);

                if (piece.getColor() == this.color) { // 아군
                    break;
                }

                validMoves.add(new Position(newRank, newFile));

                if (piece.getType() != Type.NO_PIECE) { // 진행 불가
                    break;
                }
            }
        }
        return validMoves;
    }
}
