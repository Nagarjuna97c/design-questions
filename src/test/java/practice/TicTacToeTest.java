package practice;

import practice.tictactoe.models.*;
import practice.tictactoe.stratagies.playing.RandomPlayingStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private Game game;

    @Before
    public void setUp() {
        this.game = createGame();
    }

    private Game createGame() {

        HumanPlayer human = HumanPlayer
                .builder()
                .symbol(Symbol.O)
                .user(new User("Hari", "test@gmail.com", null))
                .build();

        Bot bot = Bot
                .builder(Symbol.X)
                .level(GameLevel.EASY)
                .build();

        Game game = Game.builder()
                .withSize(3, 3)
                .withPlayer(human)
                .withPlayer(bot)
                .build();

        return game;
    }

    @Test
    public void testDimensions() {

        List<List<Cell>> cells = game.getBoard().getCells();
        assertEquals("If board is created, number of rows should be equal to input", 3, cells.size());

        List<Cell> firstRow = cells.get(0);
        assertEquals("If board is created, number of columns should be equal to input", 3, firstRow.size());

    }
}
