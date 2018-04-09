package tamboro.question.three;

import java.util.Scanner;
import tamboro.question.two.TicTacToe;

public class ComputerPlayer {

  private int limit = 10;

  public static void main(String[] args) {
    ComputerPlayer cp = new ComputerPlayer();

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the no of grids (N*N):");
    int noOfGrid = scan.nextInt();

    cp.setLimit(noOfGrid);

    System.out.println("Enter the name of player: (Example :- (x))");

    scan = new Scanner(System.in);
    String playersNames = scan.next();

    if (noOfGrid < 1) {
      System.out.println("Please enter valid Inputs.");
      System.exit(0);
    }
    TicTacToe game = new TicTacToe(noOfGrid);
    game.initializeBoard();
    System.out.println("Tic-Tac-Toe!");
    int i = -1;
    do {
      System.out.println("Current board layout:");
      game.printBoard();

      try {

        int row = -1;
        int col = -1;
        boolean isMove = false;
        do {

          System.out.println("Player " + playersNames + ",Please Enter the next move. (Example :- (1,1) ");

          scan = new Scanner(System.in);
          String input = scan.nextLine();
          String inputArray[] = input.split(",");

          try {
            row = Integer.parseInt(inputArray[0]);
            col = Integer.parseInt(inputArray[1]);

            isMove = game.move(row, col, playersNames.charAt(0));
            game.setCurrentPlayerMark(playersNames.charAt(0));

          } catch (Exception e) {
            isMove = false;
            i--;
            System.out.println(e.getMessage());
          }

          if (isMove) {
            do {
              if (!game.checkForWin()) {
                try {
                  int move[] = cp.getMove();
                  System.out.println("Computer Move..." + move[0] + "," + move[1]);

                  isMove = game.move(move[0], move[1], 'c');//Computer move
                  game.setCurrentPlayerMark('c');
                } catch (Exception e) {
                  isMove = false;
                  System.out.println(e.getMessage());
                }
              }

            } while (!isMove);
          }

        } while (!isMove);

      } catch (Exception e) {
        System.out.println("Invalid Inputs.");
        System.exit(0);
      }

    } while (!game.checkForWin() && !game.isBoardFull());
    if (game.isBoardFull() && !game.checkForWin()) {
      System.out.println("The game was a tie!");
    } else {
      System.out.println("Current board layout:");
      game.printBoard();
      System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");
    }

  }

  public int[] getMove() {
    int move[] = {(int) Math.floor(Math.random() * limit), (int) Math.floor(Math.random() * limit)};
    return move;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

}
