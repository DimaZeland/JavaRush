package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        GameObject cur;
        int size = snakeParts.size();

        for (int i = 0; i < size; ++i) {
            cur = snakeParts.get(i);
            Color snakeColor = isAlive ? Color.BLACK : Color.RED;

            if (0 == i)
                game.setCellValueEx(cur.x, cur.y, Color.NONE, HEAD_SIGN, snakeColor, 75);
            else if (i > 0)
                game.setCellValueEx(cur.x, cur.y, Color.NONE, BODY_SIGN, snakeColor, 75);
        }
    }

    public void setDirection(Direction direction) {
        if (this.direction == Direction.UP && direction == Direction.DOWN)
            return;
        else if (this.direction == Direction.DOWN && direction == Direction.UP)
            return;
        else if (this.direction == Direction.LEFT && direction == Direction.RIGHT)
            return;
        else if (this.direction == Direction.RIGHT && direction == Direction.LEFT)
            return;
        else if (this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x)
            return;
        else if (this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x)
            return;
        else if (this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y)
            return;
        else if (this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y)
            return;
        else
            this.direction = direction;
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();

        if (newHead.x >= SnakeGame.WIDTH || newHead.y >= SnakeGame.HEIGHT
                || newHead.x < 0 || newHead.y < 0) {
            isAlive = false;
            return;
        }

        if (true == checkCollision(newHead)) {
            isAlive = false;
            return;
        }

        snakeParts.add(0, newHead);

        if (newHead.y == apple.y && newHead.x == apple.x) {
            apple.isAlive = false;
        } else {
            removeTail();
        }
    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0);
        int headX = head.x;
        int headY = head.y;

        switch (direction) {
            case LEFT:
                headX -= 1;
                break;
            case DOWN:
                headY += 1;
                break;
            case RIGHT:
                headX += 1;
                break;
            case UP:
                headY -= 1;
                break;
            default:
                headY += 1;
        }
        return new GameObject(headX, headY);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject obj) {
        boolean collision = false;

        for (GameObject snakePart :
                snakeParts) {
            if (snakePart.x == obj.x && snakePart.y == obj.y)
                collision = true;
        }

        return collision;
    }

    public int getLength() {
        return snakeParts.size();
    }
}

