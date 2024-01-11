package practice.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cell {
    private int row;
    private int column;
    private Symbol symbol;

    public Cell() {}
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
