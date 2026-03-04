package chess;

import java.util.Scanner;

public class Game {
    private static final String START_COMMAND = "start";
    private static final String QUIT_COMMAND = "quit";

    private Board board;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case START_COMMAND ->{
                    board = new Board();
                    board.initialize();
                }
                case QUIT_COMMAND -> {
                    return;
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
