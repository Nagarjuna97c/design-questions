package practice.tictactoe.exceptions;

public class InvalidplayersException extends RuntimeException{
    public InvalidplayersException() {
        super("Invalid list of players!");
    }
}
