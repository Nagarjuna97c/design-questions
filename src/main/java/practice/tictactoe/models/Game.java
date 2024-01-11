package practice.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice.tictactoe.exceptions.InvalidMoveException;
import practice.tictactoe.exceptions.InvalidplayersException;
import practice.tictactoe.stratagies.winning.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Game {

    private static final int PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private Board board;
    List<Player> players = new ArrayList<>();
    List<WinningStrategy> winningStrategies = List.of(
            new RowWinningStrategy(),
            new ColumnWinningStrategy(),
            new DiagonalWinningStrategy(),
            new AntiDiagonalWinningStrategy()
    );
    private GameStatus status;
    private int nextPlayerIndex = 0;

    private Game(){}

    public void start(){
        // Assign a random value to start player
        nextPlayerIndex = (int) (Math.random() * players.size());

        // Set the status to IN_PROGRESS
        status = GameStatus.IN_PROGRESS;
    }
    public void makeMove(){
        // Get the next move by the player
        Cell move = getNextMove();

        // Update the board
        board.update(move);

        // Check for winner
        if (checkWinner()) {
            status = GameStatus.COMPLETED;
        }
        // Check for draw
        else if (checkDraw()) {
            status = GameStatus.DRAW;
        }
        else {
            // Update the nextPlayer
            nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        }
    }

    private void validateMove(Cell move) {
        if (!board.isEmpty(move.getRow(), move.getColumn())) {
            throw new InvalidMoveException(move.getRow(), move.getColumn());
        };
    }

    private Cell getNextMove() {
        Player player = players.get(nextPlayerIndex);

        Cell nextMove = player.makeMove(board);
        // validate the move
        validateMove(nextMove);
        nextMove.setSymbol(player.getSymbol());

        return  nextMove;
    }

    public Player getWinner() {
        return players.get(nextPlayerIndex);
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean checkWinner() {
        return winningStrategies.stream().
                anyMatch(winningStrategy -> winningStrategy.checkWin(board, players.get(nextPlayerIndex).getSymbol()));
    }

    private boolean checkDraw() {
        return board.getCells().stream().flatMap(List::stream).allMatch(cell -> cell.getSymbol() != null);
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public static class Builder {
        private Game game;

        private Builder() {
            game = new Game();
        }

        public Builder withSize(int rows, int columns) {
            this.game.board = new Board(rows, columns);
            return this;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return  this;
        }

        public Game build() {
            boolean isValid = validate();
            if (!isValid) {
                throw new InvalidplayersException();
            }
            Game newGame = new Game();
            newGame.board = this.game.board;
            newGame.players = game.players;
            newGame.status = DEFAULT_STATUS;

            return newGame;
        }

        private boolean validate() {

            List<Player> players = game.players;
            if (players.size() != PLAYER_COUNT) {
                return false;
            }

            // If symbols are unique
            Set<Symbol> symbols = players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());

            if (symbols.size() != PLAYER_COUNT) {
                return false;
            }
            return true;
        }
    }
}
