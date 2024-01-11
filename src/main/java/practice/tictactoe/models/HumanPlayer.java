package practice.tictactoe.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import practice.tictactoe.models.User;

import java.util.Scanner;

@SuperBuilder
public class HumanPlayer extends Player {
    private User user;

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public Cell makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row and column number:");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new Cell(row, column, getSymbol());
    }
}
