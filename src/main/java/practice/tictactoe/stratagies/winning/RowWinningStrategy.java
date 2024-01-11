package practice.tictactoe.stratagies.winning;

import practice.tictactoe.models.Board;
import practice.tictactoe.models.Cell;
import practice.tictactoe.models.Symbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        List<List<Cell>> cells = board.getCells();
        for (List<Cell> row : cells) {
            boolean win = row.stream()
                    .allMatch(cell -> cell.getSymbol() == symbol);
            if (win) {
                return true;
            }
        }
        return false;
    }
}
