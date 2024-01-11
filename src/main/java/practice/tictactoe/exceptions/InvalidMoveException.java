package practice.tictactoe.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int row, int column) {
        super("This move is invalid" + row + " " + column);
    }
}
