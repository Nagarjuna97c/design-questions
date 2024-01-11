package practice.custombuilder;

import practice.tictactoe.models.GameLevel;
import practice.tictactoe.models.Symbol;

public class Runner {
    public static void main(String[] args) {
        Bot bot = Bot
                    .builder(Symbol.X)
                    .setBotLevel(GameLevel.EASY)
                    .build();
    }
}
