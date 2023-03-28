package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Простая программа
*/

public class SymbolGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(8, 3);
        final String str = "JAVARUSH";

        for (int i = 0; i < str.length(); ++i)
            setCellValueEx(i, 1, Color.ORANGE, String.valueOf(str.charAt(i)));
    }
}
