import java.util.Scanner;
import java.util.Random;

import java.util.Random;
import java.util.Scanner;

class Runner {
  public static void main(String[] args) {
    Board board = new Board();
    Player player1 = new Player();
    Player player2 = new Player();

    Scanner scanner = new Scanner(System.in);

    // Set player names
    System.out.print("Enter Player 1 name: ");
    player1.Player(scanner.next());

    System.out.print("Enter Player 2 name: ");
    player2.Player(scanner.next());

    // Determine starting player randomly
    Player currentPlayer = (Math.random() < 0.5) ? player1 : player2;

    while (true) {
      // Generate a random pile size between 10 and 50
      board.genPile();
      board.displayPile();

      while (Board.numPieces > 0) {
        System.out.println(currentPlayer.getName() + ", it's your turn. Enter number of pieces to take: ");

        int num;
        if (currentPlayer.isComputer()) {
            System.out.println(currentPlayer.takePiecesComputer());
        } else {

          
          while (!scanner.hasNextInt()) {
              System.out.println("Invalid input. Please enter a number: ");
              scanner.next(); // Consume the invalid input
          }
            num = scanner.nextInt();
            currentPlayer.takePieces(num);
        }

        
        board.displayPile();

        if (Board.numPieces <= 1) {
          System.out.println(currentPlayer.getName() + " wins!");
          currentPlayer.score++;

          // Display scores
          System.out.println("Scores - " + player1.getName() + ": " + player1.score + " " + player2.getName() + ": " + player2.score);

          // Ask if players want to play again
          System.out.println("Do you want to play again? (yes/no): ");
          String choice = scanner.next();
          if (choice.equals("yes")) {
            break; // Exit the inner loop to restart the game
          } else {
            scanner.close();
            return; // End the program
          }
        } else {
          // Switch to the other player for the next turn
          currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
      }
    }
  }
}