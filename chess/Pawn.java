public class Pawn extends Piece {

    public void getValidMoves(int row, int col){

        if (row <= 8 && col <= 8){
            System.out.printf("The piece at that location is a %s pawn", isBlack ? "black" : "white");

            if (row ==  2 || row == 7){
                System.out.printf("Valid moves are: %d, %d and %d, %d\n", row + 2, col, row + 1, col);
            }
            else if (isBlack && row == 1 || !isBlack && row == 8){
                System.out.printf("Valid moves are: %d, %d\n", row, col);
            }
            else {
                System.out.printf("Valid moves are: %d, %d\n", row + 1, col + 1);
            }
        }
        else{
            System.out.println("Squares don't exist");
        }

    }
    public String getSymbol(){
        return isBlack ? "P" : "p";
    }

    public String getName(){
        return isBlack ? "(pawn, black)" : "(pawn, white)";
    }

}
