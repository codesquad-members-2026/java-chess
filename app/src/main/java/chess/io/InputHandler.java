package chess.io;

import chess.Game;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputHandler {
    private static final String QUIT_COMMAND = "quit";
    private static final String MOVE_COMMAND = "move";

    public Game game;
    private ChessView view;

    public void run() {
        game = new Game();
        view = new ChessView(game.getBoard());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case QUIT_COMMAND -> {
                    return;
                }
                case MOVE_COMMAND -> {
                    String from = tokenizer.nextToken();
                    String to = tokenizer.nextToken();
                    game.move(from, to);

                    view.showBoard();
                }
                default -> {
                    view.showMessage("지원하지 않는 명령어");
                }
            }
        }
    }

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        inputHandler.run();
    }
}
