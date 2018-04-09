package tamboro.question.two;

public class TicTacToe {

  private char[][] board;
  private char currentPlayerMark;
  private int gridX;
  private int gridY;

  public TicTacToe(int noOfGrid) {
    this.gridX = noOfGrid;
    this.gridY = noOfGrid;
    board = new char[gridX][gridY];
    currentPlayerMark = 'x';
    initializeBoard();
  }

  //Gives us access to currentPlayerMark
  public char getCurrentPlayerMark() {
    return currentPlayerMark;
  }

  public char setCurrentPlayerMark(char user) {
    return currentPlayerMark = user;
  }

  // Set/Reset the board back to all empty values.
  public void initializeBoard() {

    // Loop through rows
    for (int i = 0; i < gridX; i++) {

      // Loop through columns
      for (int j = 0; j < gridY; j++) {
        board[i][j] = '-';
      }
    }
  }

  // Print the current board (may be replaced by GUI implementation later)
  public void printBoard() {
    System.out.println("-------------");

    for (int i = 0; i < gridX; i++) {
      System.out.print("| ");
      for (int j = 0; j < gridY; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }

    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
  // Otherwise the board is full.
  public boolean isBoardFull() {
    boolean isFull = true;

    for (int i = 0; i < gridX; i++) {
      for (int j = 0; j < gridY; j++) {
        if (board[i][j] == '-') {
          isFull = false;
        }
      }
    }

    return isFull;
  }

    // Returns true if there is a win, false otherwise.
  // This calls our other win check functions to check the entire board.
  public boolean checkForWin() {
    return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
  }

  // Loop through rows and see if any are winners.
  private boolean checkRowsForWin() {
    boolean flag = false;
    for (int i = 0; i < gridX - 1; i++) {
      for (int j = 0; j < gridY - 1; j++) {
        if (checkRowCol(board[i][j], board[i][j + 1]) == true) {
          flag = true;
        } else {
          flag = false;
          break;
        }
      }
      if (flag) {
        return flag;
      }
    }
    return flag;
  }

  // Loop through columns and see if any are winners.
  private boolean checkColumnsForWin() {
    boolean flag = false;
    for (int i = 0; i < gridX - 1; i++) {// iterate column 
      for (int j = 0; j < gridY - 1; j++) {// iterate row 
        if (checkRowCol(board[j][i], board[j + 1][i]) == true) {
          flag = true;
        } else {
          flag = false;
          break;
        }
      }
      if (flag) {
        return flag;
      }
    }
    return flag;
  }

  // Check the two diagonals to see if either is a win. Return true if either wins.
  private boolean checkDiagonalsForWin() {

    if (gridX < 2 || gridY < 2) {
      return false;
    }
    boolean flag = false;
    for (int i = 0; i < gridX - 1; i++) {
      if (checkRowCol(board[i][i], board[i + 1][i + 1]) == true) {
        flag = true;
      } else {
        flag = false;
        break;
      }
    }

    if (flag) {
      return flag;
    }

    int j = gridY - 1;
    for (int i = 0; i < gridY - 1; i++) {

      if (checkRowCol(board[i][j], board[i + 1][j - 1]) == true) {
        flag = true;
      } else {
        flag = false;
        break;
      }
      j--;
    }

    return flag;
  }

  // Check to see if all three values are the same (and not empty) indicating a win.
  private boolean checkRowCol(char c1, char c2) {
    return ((c1 != '-') && (c1 == c2));
  }

  // Places a mark at the cell specified by row and col with the mark of the current player.
  public boolean move(int row, int col, char currentPlayer) throws Exception {

    // Make sure that row and column are in bounds of the board.
    if ((row >= 0) && (row < gridX)) {
      if ((col >= 0) && (col < gridY)) {
        if (board[row][col] == '-') {
          board[row][col] = currentPlayer;
          return true;
        } else {
          throw new Exception("Invalid Move ...");
        }
      } else {
        throw new Exception("Invalid Move ...");
      }
    }

    return false;
  }
}
