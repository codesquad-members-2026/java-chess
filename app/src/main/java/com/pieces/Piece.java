package com.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "white";
    public static final char WHITE_PAWN_REPRESENTATION = 'P';
    public static final char BLACK_PAWN_REPRESENTATION = 'p';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'N';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'n';
    public static final char WHITE_ROOK_REPRESENTATION = 'R';
    public static final char BLACK_ROOK_REPRESENTATION = 'r';
    public static final char WHITE_BISHOP_REPRESENTATION = 'B';
    public static final char BLACK_BISHOP_REPRESENTATION = 'b';
    public static final char WHITE_KING_REPRESENTATION = 'K';
    public static final char BLACK_KING_REPRESENTATION = 'k';
    public static final char WHITE_QUEEN_REPRESENTATION = 'Q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'q';

    private final char representationCharacter;
    private final String color; // 0 - black , 1 - white
    private final String name;

    private Piece(String color, char representation, String name){
        this.color = color;
        this.representationCharacter = representation;
        this.name = name;
    }


    public String getColor(){
        return this.color;
    }

    public char getRepresentation(){
        return this.representationCharacter;
    }

    public String getName(){
        return this.name;
    }

    public boolean isBlack(){
        return this.color.equalsIgnoreCase("black");
    }

    public boolean isWhite(){
        return this.color.equalsIgnoreCase("white");
    }

    public static Piece createWhitePawn(){
        return new Piece(WHITE_COLOR,WHITE_PAWN_REPRESENTATION,"pawn");
    }
    public static Piece createBlackPawn(){
        return new Piece(BLACK_COLOR,BLACK_PAWN_REPRESENTATION,"pawn");
    }

    public static Piece createWhiteKnight(){
        return new Piece(WHITE_COLOR,WHITE_KNIGHT_REPRESENTATION,"knight");
    }
    public static Piece createBlackKnight(){
        return new Piece(BLACK_COLOR,BLACK_KNIGHT_REPRESENTATION,"knight");
    }

    public static Piece createWhiteKing(){
        return new Piece(WHITE_COLOR,WHITE_KING_REPRESENTATION,"king");
    }
    public static Piece createBlackKing(){
        return new Piece(BLACK_COLOR,BLACK_KING_REPRESENTATION,"king");
    }

    public static Piece createWhiteQueen(){
        return new Piece(WHITE_COLOR,WHITE_QUEEN_REPRESENTATION,"queen");
    }
    public static Piece createBlackQueen(){
        return new Piece(BLACK_COLOR,BLACK_QUEEN_REPRESENTATION,"queen");
    }

    public static Piece createWhiteRook(){
        return new Piece(WHITE_COLOR,WHITE_ROOK_REPRESENTATION,"rook");
    }
    public static Piece createBlackRook(){
        return new Piece(BLACK_COLOR,BLACK_ROOK_REPRESENTATION,"rook");
    }
    public static Piece createWhiteBishop(){
        return new Piece(WHITE_COLOR,WHITE_BISHOP_REPRESENTATION,"bishop");
    }
    public static Piece createBlackBishop(){
        return new Piece(BLACK_COLOR,BLACK_BISHOP_REPRESENTATION,"bishop");
    }

}
