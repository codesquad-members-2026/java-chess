package chess;

public class Game {
    // 검증이나 계산은 game이 board는 최종 작업만
    private final Board board;

    public Game() {
        board = new Board();
        board.initialize();
    }

    public void move(String from, String to) {
        board.move(from, to);
    }

    public Board getBoard() {
        return board;
    }


}
