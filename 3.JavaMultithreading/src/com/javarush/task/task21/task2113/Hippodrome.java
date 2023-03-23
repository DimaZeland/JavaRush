package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void move() {
        for (Horse horse : horses)
            horse.move();
    }

    void print() {
        for (Horse horse : horses)
            horse.print();

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Lucky1", 3, 0));
        game.getHorses().add(new Horse("Slevin2", 3, 0));
        game.getHorses().add(new Horse("Homer3", 3, 0));

        game.run();
        game.printWinner();
    }

    public Horse getWinner() {
        Horse winner = new Horse("", 0, 0);

        for (Horse horse : horses)
            if (horse.getDistance() > winner.getDistance())
                winner = horse;

        return winner;
    }

    public void printWinner() {
        String result = "Winner is " + getWinner().getName() + "!";

        System.out.println(result);
    }
}
