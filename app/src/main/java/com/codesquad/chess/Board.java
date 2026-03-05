package com.codesquad.chess;
import com.codesquad.chess.pieces.Piece;
import com.codesquad.chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;


public class Board {
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public void initialize() {

        addBlackSpecialPieces();
        for (int i = 0; i < 8; i++) blackPieces.add(Piece.createBlackPawn());

        for (int i = 0; i < 8; i++) whitePieces.add(Piece.createWhitePawn());
        addWhiteSpecialPieces();
    }

    private void addBlackSpecialPieces() {
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());
    }

    private void addWhiteSpecialPieces() {
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());
    }

    public int pieceCount() {
        return whitePieces.size() + blackPieces.size();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        String blankRank = StringUtils.appendNewLine("........");

        sb.append(StringUtils.appendNewLine(getPieceRepresentation(blackPieces.subList(0, 8))));
        sb.append(StringUtils.appendNewLine(getPieceRepresentation(blackPieces.subList(8, 16))));
        sb.append(blankRank).append(blankRank).append(blankRank).append(blankRank);
        sb.append(StringUtils.appendNewLine(getPieceRepresentation(whitePieces.subList(0, 8))));
        sb.append(StringUtils.appendNewLine(getPieceRepresentation(whitePieces.subList(8, 16))));

        return sb.toString();
    }

    private String getPieceRepresentation(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) sb.append(piece.getRepresentation());
        return sb.toString();
    }
}