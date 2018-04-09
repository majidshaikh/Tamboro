package tamboro.question.two;

import java.util.Scanner;

public class TicTacPlayer {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the no of grids (N*N):");
    int noOfGrid = scan.nextInt();

    System.out.println("Enter the no of playes");
    int noOfPlayers = scan.nextInt();

    System.out.println("Enter the names of players: (Example :- (x,y,z))");

    scan = new Scanner(System.in);
    String playersNames = scan.nextLine();

    String playersNamesArray[] = playersNames.split(",");

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
          i++;
          if (i == noOfPlayers) {
            i = 0;
          }
          System.out.println("Player " + playersNamesArray[i] + ",Please Enter the next move. (Example :- (1,1) ");

          scan = new Scanner(System.in);
          String input = scan.nextLine();
          String inputArray[] = input.split(",");

          try {
            row = Integer.parseInt(inputArray[0]);
            col = Integer.parseInt(inputArray[1]);

            isMove = game.move(row, col, playersNamesArray[i].charAt(0));

            game.setCurrentPlayerMark(playersNamesArray[i].charAt(0));
          } catch (Exception e) {
            isMove = false;
            i--;
            System.out.println(e.getMessage());
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
}
