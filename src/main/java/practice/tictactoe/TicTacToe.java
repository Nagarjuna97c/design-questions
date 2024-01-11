package practice.tictactoe;

import practice.tictactoe.exceptions.InvalidSymbolException;
import practice.tictactoe.models.*;

import java.util.Scanner;

public class TicTacToe {
    private static final  int PLAYER_SIZE = 2;
    private static final  int BOARD_SIZE = 3;

    public static void main(String[] args) {
        // Ask for user input - name, email and symbol
        System.out.println("Welcome to TicTacToe");

        HumanPlayer human = createUser();

        // Create a game
        Game game = createGame(human);
        game.start();



        // Iteratively call mmake move
        // until -> Game is WON or DRAW

        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player player = game.getNextPlayer();
            System.out.println("Next player " + player.getSymbol());
            game.makeMove();
            game.getBoard().printBoard();
        }
        if (game.getStatus() == GameStatus.COMPLETED) {
            System.out.println("Game Over!");
            System.out.println("Winner: " + game.getWinner().getSymbol());
        } else if (game.getStatus() == GameStatus.DRAW) {
            System.out.println("Game Over!");
            System.out.println("It's a draw!");
        }


    }

    private static Game createGame(HumanPlayer player) {
        return Game.builder()
                .withSize(BOARD_SIZE, BOARD_SIZE)
                .withPlayer(player)
                .withPlayer(
                    Bot.builder(decideBotSymbol(player.getSymbol()))
                            .level(GameLevel.EASY)
                            .build()
                )
                .build();
    }

    private static Symbol decideBotSymbol(Symbol symbol) {
        if (symbol == Symbol.X) {
            return Symbol.O;
        }
        return Symbol.X;
    }

    private static HumanPlayer createUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your symbol: X or O");
        Symbol symbol;
        try {
            symbol = Symbol.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidSymbolException();
        }
//        scanner.close();

        User user = new User(name, email, null);

        return new HumanPlayer(symbol, user);
    }
}
