package practice.tictactoe.stratagies.winning;

import practice.tictactoe.models.Board;
import practice.tictactoe.models.Cell;
import practice.tictactoe.models.Symbol;

import java.util.List;

public class AntiDiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        List<List<Cell>> cells = board.getCells();
        int rows = cells.size();
        int columns = cells.get(0).size();
        if (rows != columns) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            if (cells.get(i).get(rows - i - 1).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
