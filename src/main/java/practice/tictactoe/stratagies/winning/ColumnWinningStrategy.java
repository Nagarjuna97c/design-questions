package practice.tictactoe.stratagies.winning;

import practice.tictactoe.models.Board;
import practice.tictactoe.models.Cell;
import practice.tictactoe.models.Symbol;

import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        List<List<Cell>> cells = board.getCells();
        int rows = cells.size();
        int columns = cells.get(0).size();
        for (int column = 0; column < columns; column++) {
            boolean ans = true;
            for (int row = 0; row < rows; row++) {
                if (cells.get(row).get(column).getSymbol() != symbol) {
                    ans = false;
                }
            }
            if (ans) {
                return true;
            }
        }
        return false;
    }
}
