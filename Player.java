import java.util.Random;
import java.util.Random;
import java.util.Random;

class Player {
  public String playerName;
  public int score = 0;

  // Change the constructor method name to match the class name
  public void Player(String name) {
    playerName = name;
  }

  // Fix the takePieces method to correctly update numPieces
  public int takePieces(int num) {
    if (num <= Board.numPieces / 2) {
      this.score += num;
      Board.numPieces -= num; // Fix this line
      return Board.numPieces;
    } else {
      System.out.println("You are taking too many pieces! :(");
      return 0;
    }
  }

  // Fix the takePiecesComputer method to correctly update numPieces
  public int takePiecesComputer() {
    Random rand = new Random();
    int num = rand.nextInt(Board.numPieces/2+1); 
    this.score += num;
    Board.numPieces -= num; // Fix this line
    return num;
  }

  public String getName() {
    return this.playerName;
  }

  public boolean isComputer() {
    return this.playerName.toLowerCase().contains("computer");
  }
}