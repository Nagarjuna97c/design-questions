package practice.tictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Board {
    private List<List<Cell>> cells = new ArrayList<>();

    public Board(int rows, int columns) {
        System.out.println("setting up the board");
        List<List<Cell>> cells = new ArrayList<>();
        IntStream.range(0, rows).forEach(row -> {
            List<Cell> rowCells = new ArrayList<>();
            IntStream.range(0, columns).forEach(column -> rowCells.add(new Cell(row, column)));
            cells.add(rowCells);
        });
        this.cells = cells;
    }


    public boolean isEmpty(int row, int column) {
        return  cells.get(row).get(column).getSymbol() == null;
    }

    public void update(Cell move) {
        cells.get(move.getRow()).get(move.getColumn()).setSymbol(move.getSymbol());
    }

    public void printBoard() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                Symbol cellSymbol = cell.getSymbol();
                System.out.print((cellSymbol == null ? "-" : cellSymbol) + " ");
            }
            System.out.println();
        }
    }
}
