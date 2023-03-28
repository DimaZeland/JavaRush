package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int lineIndex = 0; lineIndex < SIDE; ++lineIndex)
            for (int columnIndex = 0; columnIndex < SIDE; ++columnIndex)
                setCellColoredNumber(lineIndex, columnIndex, gameField[columnIndex][lineIndex]);
    }

    private void createNewNumber() {
        if (2048 == getMaxTileValue())
            win();

        int columnIndex;
        int lineIndex;

        boolean isCreated = false;
        do {
            columnIndex = getRandomNumber(SIDE);
            lineIndex = getRandomNumber(SIDE);

            if (0 == gameField[lineIndex][columnIndex]) {
                gameField[lineIndex][columnIndex] = 9 == getRandomNumber(10) ? 4 : 2;
                isCreated = true;
            }
        }
        while (false == isCreated);
    }

    private Color getColorByValue(int value) {
        Color cellColour = Color.NONE;

        switch (value) {
            case 0:
                cellColour = Color.RED;
                break;
            case 2:
                cellColour = Color.GOLD;
                break;
            case 4:
                cellColour = Color.ORANGE;
                break;
            case 8:
                cellColour = Color.BLUE;
                break;
            case 16:
                cellColour = Color.DARKSEAGREEN;
                break;
            case 32:
                cellColour = Color.YELLOW;
                break;
            case 64:
                cellColour = Color.ALICEBLUE;
                break;
            case 128:
                cellColour = Color.ANTIQUEWHITE;
                break;
            case 256:
                cellColour = Color.AQUA;
                break;
            case 512:
                cellColour = Color.AQUAMARINE;
                break;
            case 1024:
                cellColour = Color.BEIGE;
                break;
            case 2048:
                cellColour = Color.FUCHSIA;
                break;
            default:
                cellColour = Color.NONE;
        }
        return cellColour;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color cellColor = getColorByValue(value);
        String valueString = 0 == value ? "" : Integer.toString((Integer.valueOf(value)));
        setCellValueEx(x, y, cellColor, valueString);
    }

    private boolean compressRow(int[] row) {
        boolean result = false;
        int insertPosition = 0;

        for (int i = 0; i < SIDE; ++i)
            if (row[i] > 0) {
                if (i != insertPosition) {
                    row[insertPosition] = row[i];
                    row[i] = 0;
                    result = true;
                }
                ++insertPosition;
            }
        return result;
    }

    private boolean mergeRow(int[] row) {
        boolean result = false;

        for (int i = 0; i < row.length - 1; ++i) {
            if (0 != row[i] && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                result = true;
                score += row[i];
                setScore(score);

                //++i;
            }
        }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped)
            if (Key.SPACE == key) {
                isGameStopped = false;
                score = 0;
                setScore(score);
                createGame();
                drawScene();
            } else
                return;

        if (false == canUserMove()) {
            gameOver();
            return;
        }

        if (Key.LEFT == key) {
            moveLeft();
            drawScene();
        } else if (Key.RIGHT == key) {
            moveRight();
            drawScene();
        } else if (Key.UP == key) {
            moveUp();
            drawScene();
        } else if (Key.DOWN == key) {
            moveDown();
            drawScene();
        }
    }

    private void moveLeft() {
        boolean wasCompressed = false;
        boolean wasMerged = false;
        boolean isNewNumberNeeded = false;

        for (int i = 0; i < SIDE; ++i) {
            wasCompressed = compressRow(gameField[i]);
            wasMerged = mergeRow(gameField[i]);

            if (wasMerged)
                compressRow(gameField[i]);

            if (wasCompressed || wasMerged)
                isNewNumberNeeded = true;
        }
        if (isNewNumberNeeded)
            createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] res = new int[SIDE][SIDE];

        for (int i = 0; i < SIDE; i++)
            for (int k = 0; k < SIDE; k++)
                res[k][SIDE - 1 - i] = gameField[i][k];

        gameField = res;
    }

    private int getMaxTileValue() {
        int max = 0;

        for (int lines = 0; lines < gameField.length; ++lines)
            for (int column = 0; column < gameField.length; ++column)
                if (gameField[lines][column] > max)
                    max = gameField[lines][column];

        return max;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.NONE, "YOU WIN", Color.WHITE, 50);
    }

    private boolean canUserMove() {
        for (int y = 0; y < SIDE; ++y)
            for (int x = 0; x < SIDE; ++x) {
                if (gameField[y][x] == 0)
                    return true;
                else if (y < SIDE - 1 && gameField[y][x] == gameField[y + 1][x])
                    return true;
                else if (x < SIDE - 1 && gameField[y][x] == gameField[y][x + 1])
                    return true;
            }
        return false;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.NONE, "GAME OVER", Color.WHITE, 50);

    }
}
