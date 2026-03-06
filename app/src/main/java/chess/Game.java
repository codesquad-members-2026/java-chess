package chess;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
    private static final String START_COMMAND = "start";
    private static final String QUIT_COMMAND = "quit";
    private static final String MOVE_COMMAND = "move";

    private Board board;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case START_COMMAND ->{
                    board = new Board();
                    board.initialize();
                }
                case QUIT_COMMAND -> {
                    return;
                }
                case MOVE_COMMAND -> {
                    String from = tokenizer.nextToken();
                    String to = tokenizer.nextToken();
                    board.move(from, to);
                    System.out.println(board.showBoard());
                }
                default -> {
                    System.out.println("지원하지 않는 명령어");
                }
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
