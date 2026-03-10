package chess;

import chess.io.ChessView;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChessManager {
    private static final String QUIT_COMMAND = "quit";
    private static final String MOVE_COMMAND = "move";
    private static final String START_COMMAND = "start";

    private final ChessView view = new ChessView();
    public Game game = new Game();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        view.showMessage("시작: start / 종료: quit");

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case START_COMMAND -> {
                    game.init();
                    view.setBoard(game.getBoard());

                    view.showMessage("체스를 시작합니다.\n이동: move from to");
                    view.showBoard();
                }
                case MOVE_COMMAND -> {
                    try {
                        String from = tokenizer.nextToken();
                        String to = tokenizer.nextToken();
                        game.move(from, to);

                        view.showBoard();
                    } catch (Exception e) {
                        view.showMessage(e.getMessage());
                    }
                }
                case QUIT_COMMAND -> {
                    return;
                }
                default -> {
                    view.showMessage("지원하지 않는 명령어");
                }
            }
        }
    }

    public static void main(String[] args) {
        ChessManager chessManager = new ChessManager();
        chessManager.run();
    }
}
