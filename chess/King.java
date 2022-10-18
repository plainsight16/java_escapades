public class King extends Piece{
    public void getValidMoves(int row, int col){
        if (row <= 8 && col <= 8)
            System.out.println("Movement is not implemented");
        else System.out.println("Squares don't exist");
    }
    public String getSymbol(){
        return isBlack ? "K" : "k";
    }
    public String getName(){
        return isBlack ? "(king, black)" : "(king, white)";
    }
}
