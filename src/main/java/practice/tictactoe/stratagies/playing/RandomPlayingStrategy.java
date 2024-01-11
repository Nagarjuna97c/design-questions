package practice.tictactoe.stratagies.playing;

import practice.tictactoe.models.Board;
import practice.tictactoe.models.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomPlayingStrategy implements PlayingStrategy{
    public List<Cell> getAvailableCells(Board board) {
        return board.getCells()
                .stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .collect(Collectors.toList());
    }
    @Override
    public Cell play(Board board) {
        List<Cell> availableCells = getAvailableCells(board);
        int randomIndex = (int) (Math.random() * availableCells.size());
        return availableCells.get(randomIndex);
    }
}
