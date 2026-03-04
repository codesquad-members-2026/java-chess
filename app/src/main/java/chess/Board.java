package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Piece;


public class Board {
    private static final char EMPTY_SQUARE = '.';
    private static final int SIZE = 8;
    private final List<Piece> board = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    private int pieceCount = 0;

    public void initialize() {
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());

        for (int i = 0; i < 8; i++) {
            whitePieces.add(Piece.createWhitePawn());
            blackPieces.add(Piece.createBlackPawn());
        }

        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());

        board.addAll(whitePieces);
        for (int i = 0; i < 32; i++) {
            board.add(null);
        }
        board.addAll(blackPieces);

        pieceCount = whitePieces.size() + blackPieces.size();
    }

    public void add(Piece pawn) {
        board.add(pawn);
        if (pawn != null) {
            pieceCount++;
        }
    }

    public int pieceCount() {
        return pieceCount;
    }

    public Piece findPiece(int index) {
        return board.get(index);
    }

    private String getPawnsResult(List<Piece> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Piece whitePawn : pawns) {
            sb.append(whitePawn.getRepresentation());
        }
        return sb.toString();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            StringBuilder rowSb = new StringBuilder();
            for (int col = 0; col < SIZE; col++) {
                Piece pawn = board.get(row * SIZE + col);
                char representation = pawn == null ? EMPTY_SQUARE : pawn.getRepresentation();
                rowSb.append(representation);
            }
            sb.append(appendNewLine(rowSb.toString()));
        }
        return sb.toString();
    }
}
