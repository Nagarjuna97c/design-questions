package com.scaler.lld.tictactoe.models;

import com.scaler.lld.tictactoe.strategies.PlayingStrategy;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import practice.tictactoe.models.GameLevel;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class Bot extends Player {

    private PlayingStrategy playingStrategy;
    private GameLevel level;

    @Override
    public BoardCell play(Board board) {
        // TODO Auto-generated method stub
        return null;
    }

}
