abstract public class Piece {
    boolean isBlack;


    abstract void getValidMoves(int row, int col);
    // prints  what valid moves a piece may have at its current location.
    // This would only be implemented for pawns and rooks.
    // All other pieces must report that this code is not implemented.
    // Make sure that it will not process invalid values.



    abstract  String getSymbol();
    // returns a single character, uppercase if the piece is black, lowercase if the piece is white,
    // for example, in the case for a pawn, ("p" or "P")


    abstract  String getName();
    // returns a string that contains  the piece's colour and the piece's name, ("pawn", "white")


}
