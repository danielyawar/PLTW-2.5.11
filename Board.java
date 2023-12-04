import java.util.Random;

class Board {
  static int numPieces;
  static String pieces;

  public void genPile() {
    Random rand = new Random();
    numPieces = rand.nextInt(41) + 10; // Change to include 50
  }

  public void displayPile() {
    String object = "- ";
    String displayPile = "";
    for (int i = 0; i < numPieces; i++) {
      displayPile += object;
    }
    System.out.println(displayPile);
  }
}