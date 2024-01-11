package practice.tictactoe.models;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class Player {
    private Symbol symbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract Cell makeMove(Board board);
}
