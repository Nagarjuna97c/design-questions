package practice.tictactoe.stratagies.winning;

import practice.tictactoe.models.Board;
import practice.tictactoe.models.Symbol;

public interface WinningStrategy {
    boolean checkWin(Board board, Symbol symbol);
}
