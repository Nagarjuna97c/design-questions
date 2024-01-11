package practice.tictactoe.exceptions;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException() {
        super("Invalid symbol. Please enter X or O");
    }
}
