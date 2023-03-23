package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        List<GameObject> friends = new ArrayList<>();

        for (int y = 0; y < SIDE; y++)
            for (int x = 0; x < SIDE; x++)
                if (false == gameField[x][y].isMine) {

                    for (GameObject field : getNeighbors(gameField[x][y]))
                        if (field.isMine)
                            ++gameField[x][y].countMineNeighbors;

                }
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];

        if (gameObject.isOpen || gameObject.isFlag || isGameStopped)
            return;

        gameObject.isOpen = true;
        --countClosedTiles;
        setCellColor(x, y, Color.GREEN);
        if (gameObject.isMine) {
            setCellValue(gameObject.x, gameObject.y, MINE);
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else if (0 == gameObject.countMineNeighbors) {
            setCellValue(gameObject.x, gameObject.y, "");
            for (GameObject n : getNeighbors(gameObject))
                if (false == n.isOpen)
                    openTile(n.x, n.y);
        } else {
            setCellNumber(x, y, gameObject.countMineNeighbors);
            score += 5;
            setScore(score);

            if (countClosedTiles == countMinesOnField)
                win();
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped)
            return;

        GameObject gameObject = gameField[y][x];

        if (gameObject.isOpen || (countFlags == 0 && !gameObject.isFlag))
            return;


        if (gameObject.isFlag) {
            gameObject.isFlag = false;
            ++countFlags;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        } else {
            gameObject.isFlag = true;
            --countFlags;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "You lost", Color.ORANGE, 100);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GOLD, "You won!", Color.BLUE, 100);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
            return;
        }

        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}