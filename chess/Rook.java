public class Rook extends Piece{
    public void getValidMoves(int row, int col){
        if (row <= 8 && col <= 8) {
            System.out.printf("The piece at that location is a %s rook\n", isBlack ? "black" : "white");

            System.out.print("Valid moves are: ");

            //Vertically
            for (int j = 1; j <= 8; j++) {
                if (j != row) {
                    System.out.printf("%d,%d ", j, col);
                }
            }
            System.out.print("and");
            System.out.println();

            //Horizontally
            for (int i = 1; i <= 8; i++) {
                if (i != col) {
                    System.out.printf("%d,%d ", row, i);
                }
            }
            System.out.println();
        }
        else {
            System.out.println("Squares don't exist");
        }
    }
    public String getSymbol(){
        return isBlack ? "R" : "r";
    }
    public String getName(){
        return isBlack ? "(rook, black)" : "(rook, white)";
    }
}
