package chess;

public class Position {
    public int rank;
    public int file;

    private Position(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public static Position from(String position) {
        int file = position.charAt(0) - 'a';
        int rank = position.charAt(1) - '1';
        return new Position(rank, file);
    }
}
