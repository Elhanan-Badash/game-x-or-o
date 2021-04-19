package com.company;

import java.util.Scanner;

public class XOBoard {
    Scanner scanner = new Scanner(System.in);
    int col = 3;
    int row = 3;
    char[][] board = new char[col][row];
    boolean gameIsPlayed = true;
    int inputRow;
    int inputCol;
    char turnPlayer = 'X';
    int gamesCounter = 0;

    public void run(){
        printBoard();

        while (gameIsPlayed){
            System.out.printf("Please enter a number from 1-3 for a row" +
                    " and also a number from 1-3 for a column\n" +
                    turnPlayer + " Now it's your turn\n" );
            inputRow = getUserInput(scanner) - 1;
            inputCol = getUserInput(scanner) - 1;

            if(isFreeCell()){
                System.out.println("The place on the board is not available, please come back again");
            }else {
                put();
                Display();
                System.out.print(Status());

                if(turnPlayer == 'X'){
                    turnPlayer = 'O';
                }else {
                    turnPlayer = 'X';
                }
            }

        }
    }

    public void printBoard(){
        for(int i = 0; i < this.col; i++){
            System.out.print("| ");
            for(int j = 0; j < row; j++) {
                board[i][j] = '@';
                System.out.print(board[i][j] + " | ");
            }
            System.out.print("\n-------------\n" );
        }
    }

    public int getUserInput(Scanner scanner){
        int inputIndex = -1;

        while(inputIndex < 0 || inputIndex > 3){

            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            inputIndex = scanner.nextInt();
                if (inputIndex < 0 || inputIndex > 3) {
                    System.out.println("Not valid input!");
                    System.out.println("Enter the free box index 1-3");
                }
        }

        return inputIndex;
    }

    public void put(){
        board[inputRow][inputCol] = turnPlayer;
        gamesCounter++;
    }

    public boolean isFreeCell(){
        return board[inputRow][inputCol] == 'X' || board[inputRow][inputCol] == 'O';
    }

    public String Status(){
       if((board[0][0] == turnPlayer && board[0][1] == turnPlayer && board[0][2] == turnPlayer) ||
               (board[1][0] == turnPlayer && board[1][1] == turnPlayer && board[1][2] == turnPlayer) ||
               (board[2][0] == turnPlayer && board[2][1] == turnPlayer && board[2][2] == turnPlayer) ||
               (board[0][0] == turnPlayer && board[1][0] == turnPlayer && board[2][0] == turnPlayer) ||
               (board[0][1] == turnPlayer && board[1][1] == turnPlayer && board[2][1] == turnPlayer) ||
               (board[0][2] == turnPlayer && board[1][2] == turnPlayer && board[2][2] == turnPlayer) ||
               (board[0][0] == turnPlayer && board[1][1] == turnPlayer && board[2][2] == turnPlayer) ||
               (board[0][2] == turnPlayer && board[1][1] == turnPlayer && board[2][0] == turnPlayer)){

           gameIsPlayed = false;
           return "The big winner is : " + turnPlayer;

       }
        if(gamesCounter == 9){
            gameIsPlayed = false;
           return "The game ended without a win {Draw}";
        }
        return "The game is still alive and everyone has a chance {None}\n";
    }

    public void Display(){
        for(int i = 0; i < col; i++){
            System.out.print("| ");
            for(int j = 0; j < row; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.print("\n-------------\n" );
        }
    }
}
