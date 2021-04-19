package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Mordechai", 'X');
        Player player2 = new Player("Reuben", 'O');
        XOBoard board = new XOBoard();
        board.run();


    }
}
