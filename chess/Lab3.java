import java.util.HashMap;
import java.util.Scanner;

public class Lab3 {

    static Scanner input = new Scanner (System.in);
    static String[][] board = buildBoard();
    static Pawn pawn = new Pawn();
    static Rook rook = new Rook();
    static Knight knight = new Knight();
    static Bishop bishop = new Bishop();
    static Queen queen = new Queen();
    static King king = new King();

    static boolean playAgain = true;


    public static void main(String[] args) {

        printBoard();

        while(playAgain){
            switch (menuSystem()) {
                case "1" -> movePiece();
                case "2" -> checkValidMoves();
                case "3" -> printBoard();
                case "Q" -> quit();
            }
        }
    }


    //helper function to menuSystem()
    public static void displayPrompt(){
        System.out.println("1. Move a piece.");
        System.out.println("2. Check a piece for valid moves.");
        System.out.println("3. Redraw the board.");
        System.out.println("Q. Quit.");

    }
    public static String menuSystem(){
        var validOptions = new HashMap<String, Boolean>();
        validOptions.put("1", true);
        validOptions.put("2", true);
        validOptions.put("3", true);
        validOptions.put("Q", true);
        boolean isInvalid = true;
        String response = "";
        while(isInvalid){
            displayPrompt();
            response = input.next();
            if (validOptions.getOrDefault(response, false)){
                isInvalid = false;

            }
            else {
                System.out.println("Valid options are 1, 2, 3 or Q.");
            }
        }
        return response;
    }

    public static String[][] buildBoard(){

        return new String[][]
                {

                {"      ", "   1  ", "   2  ", "   3  ", "   4  ", "   5  ", "   6  ", "   7  ", "   8  "},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  1   ", "|  r  ", "|  n  ", "|  b  ", "|  q  ", "|  k  ", "|  b  ", "|  n  ", "|  r  |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  2   ", "|  p  ", "|  p  ", "|  p  ", "|  p  ", "|  p  ", "|  p  ", "|  p  ", "|  p  |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  3   ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  4   ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  5   ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  6   ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  7   ", "|  P  ", "|  P  ", "|  P  ", "|  P  ", "|  P  ", "|  P  ", "|  P  ", "|  P  |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},

                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"  8   ", "|  R  ", "|  N  ", "|  B  ", "|  K  ", "|  Q  ", "|  B  ", "|  N  ", "|  R  |"},
                {"      ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     ", "|     |"},
                {"      ", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----", "+-----+"}
        };
    }

    //helper function to buildBoard
    public static void printBoard(){
        for(String[] row : board){
            for (String element : row){
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static void checkValidMoves(){
        int row = 0, column = 0;
        row = validateValue(row, true);
        column = validateValue(column, false);

        String piece = board[offsetRow(row)][column];
        piece = convertPiece(piece);

        switch (piece) {
            case "p" -> {
                pawn.isBlack = false;
                pawn.getValidMoves(row, column);
            }
            case "P" -> {
                pawn.isBlack = true;
                pawn.getValidMoves(row, column);
            }
            case "r" -> {
                rook.isBlack = false;
                rook.getValidMoves(row, column);
            }
            case "R" -> {
                rook.isBlack = true;
                rook.getValidMoves(row, column);
            }
            case "n" -> {
                knight.isBlack = false;
                knight.getValidMoves(row, column);
            }
            case "N" -> {
                knight.isBlack = true;
                knight.getValidMoves(row, column);
            }
            case "b" -> {
                bishop.isBlack = false;
                bishop.getValidMoves(row, column);
            }
            case "B" -> {
                bishop.isBlack = true;
                bishop.getValidMoves(row, column);
            }
            case "q" -> {
                queen.isBlack = false;
                queen.getValidMoves(row, column);
            }
            case "Q" -> {
                queen.isBlack = true;
                queen.getValidMoves(row, column);
            }
            case "k" -> {
                king.isBlack = false;
                king.getValidMoves(row, column);
            }
            case "K" -> {
                king.isBlack = true;
                king.getValidMoves(row, column);
            }
            default -> System.out.println("Can't resolve piece");
        }
    }
    private static String convertPiece(String piece){
        return piece.split("")[3];
    }

    private static int offsetRow(int row){
        return 3 + (row - 1) * 4;
    }

    public static void movePiece(){

        //Locate Piece
        System.out.println("What piece do you want to move?");

        int row = 0, col = 0;

        row = offsetRow(validateValue(row, true)); // Offset Value

        col = validateValue(col, false);

        //Targeted Pieces
        System.out.println("Where do you wish to move this piece?");

        int targetedRow = 0, targetedColumn = 0;

        targetedRow = offsetRow(validateValue(targetedRow, true)); // Offset Value

        targetedColumn = validateValue(targetedColumn, false);

        //Move Piece
        String[] pieceArray = board[row][col].split("");
        String piece = pieceArray[3];
        
        if (piece.equals(" ")){
            System.out.println("You have selected a blank piece, try again");
        }
        else{
            pieceArray[3] = " ";
            board[row][col] = "";

            for (String p : pieceArray){
                board[row][col] += p;
            }

            String[] targetPieceArray = board[targetedRow][targetedColumn].split("");
            targetPieceArray[3] = piece;
            System.out.println();
            board[targetedRow][targetedColumn] = "";

            for (String targetPiece : targetPieceArray){
                board[targetedRow][targetedColumn] += targetPiece;
            }
        }
    }

    // helper function to movePiece
    private static int validateValue(int value, boolean isRow){
        boolean isInvalid = true;

        while (isInvalid){
            System.out.printf("Enter the %s number: ", isRow ? "row" : "column");
            String userValue = input.next();

            try{
                value = Integer.parseInt(userValue);
                if (value < 1 || value > 8){
                    System.out.printf("Valid %s numbers are from 1 - 8", isRow ? "row" : "column");
                }
                else {
                    isInvalid = false;
                }

            }catch(NumberFormatException ex){
                System.out.println("Input must be integer valid from 1 - 8, try again");
            }

        }
        return value;
    }

    public static void quit(){
        System.out.println("Thanks for playing");
        playAgain = false;
    }




}
