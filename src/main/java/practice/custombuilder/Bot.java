package practice.custombuilder;

import practice.tictactoe.models.*;
import practice.custombuilder.CustomPlayer;
import practice.tictactoe.stratagies.playing.PlayingStrategy;
import practice.tictactoe.stratagies.playing.RandomPlayingStrategy;

//@SuperBuilder
public class Bot extends CustomPlayer {
    private GameLevel level;
    private PlayingStrategy strategy;

    private Bot(Symbol symbol){
        super(symbol);
    }

    public static Builder builder(Symbol symbol) {
        return new Builder(symbol);
    }

    public static class Builder {
        private Bot bot;
        private Builder(Symbol symbol) {
            bot = new Bot(symbol);
        }

        public Builder setBotLevel(GameLevel level) {
            switch (level) {
                case EASY:
                case MEDIUM:
                case HARD:
                    bot.strategy = new RandomPlayingStrategy();
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + level);
            }
            bot.level = level;
            return this;
        }

        public Bot build() {
            Bot newBot = new Bot(bot.getSymbol());
            newBot.level = bot.level;
            newBot.strategy = bot.strategy;
            return newBot;
        }
    }
}
