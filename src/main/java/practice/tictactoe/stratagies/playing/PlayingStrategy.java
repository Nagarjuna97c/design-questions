package practice.tictactoe.stratagies.playing;

import practice.tictactoe.models.Board;
import practice.tictactoe.models.Cell;

public interface PlayingStrategy {
    Cell play(Board board);
}
