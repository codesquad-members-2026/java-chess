package chess;

import java.util.Objects;

public class Position {
    public int rank;
    public int file;

    public Position(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public static Position from(String position) {
        int file = position.charAt(0) - 'a';
        int rank = position.charAt(1) - '1';
        return new Position(rank, file);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return rank == position.rank && file == position.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }

    @Override
    public String toString() {
        return String.format("%c%d", file + 'a', rank + 1);
    }
}
