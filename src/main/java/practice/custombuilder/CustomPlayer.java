package practice.custombuilder;

import lombok.Getter;
import practice.tictactoe.models.Symbol;
@Getter
public abstract class CustomPlayer {
    private Symbol symbol;

    public CustomPlayer(Symbol symbol) {
        this.symbol = symbol;
    }
}
