package com.example.chess.app;
import com.example.chess.pieces.*;

/**
 * Has the Starting board
 *
 * @author Daniel Wang
 * @author Dustin Lee
 */
public class Board {
	/**
     * 2d array of Squares
     */
	public Piece[][] board;
	
	/**
     * Constructor
     *
     * Creates a new 8x8 array of Pieces and initialize each Piece to
     * the correct chess piece and player color in the beginning of a
     * standard chess match
     */
	public Board(){
		
        board = new Piece[8][8];
        //Blacks pieces
        board[0][0] = new Rook(0,0,false);
    	board[0][1] = new Knight(1,0,false);
    	board[0][2] = new Bishop(2,0,false);
    	board[0][3] = new Queen(3,0,false);
    	board[0][4] = new King(4,0,false);
    	board[0][5] = new Bishop(5,0,false);
    	board[0][6] = new Knight(6,0,false);
    	board[0][7] = new Rook(7,0,false);

        for(int i = 0; i < 8; i++) {
        	board[1][i] = new Pawn(i,1,false);
        }

        //Whites pieces
        board[7][0] = new Rook(0,7,true);
        board[7][1] = new Knight(1,7,true);
        board[7][2] = new Bishop(2,7,true);
        board[7][3] = new Queen(3,7,true);
        board[7][4] = new King(4,7,true);
        board[7][5] = new Bishop(5,7,true);
        board[7][6] = new Knight(6,7,true);
        board[7][7] = new Rook(7,7,true);

        for(int i = 0; i < 8; i++) {
        	board[6][i] = new Pawn(i,6,true);
        } 
		
        
    }
	
	
	/**
     * Constructor
     *
     * Creates a new empty 8x8 array of Pieces
     *
     * @param empty Placeholder boolean value
     */
	public Board(boolean empty) {
		board = new Piece[8][8];
	} 
	
	
	
	/**
     * Detects if a given index on the board is empty
     *
     * @param x The x coordinate on the board
     * @param y The y coordinate on the board
     * @return True if the index is empty 
     */
	public boolean isEmpty(int x, int y) {
		if (x<0 || x>7 || y<0 || y>7) return false;
		if(board[y][x] == null) return true;
		else return false;
	} 
	
	/**
     * Gets the piece associated with the given index on the board
     *
     * @param x The x coordinate on the board
     * @param y The y coordinate on the board
     * @return the piece
     */
	public Piece getPiece(int x, int y) { 
		return board[y][x]; 
	} 
	
	/**
     * Adds a piece to the board
     *
     * @param x The x coordinate on the board
     * @param y The y coordinate on the board
     * @param piece The piece that is being added to the board
     */
	public void addPiece(int x, int y, Piece piece) { 
		board[y][x] = piece; 
	} 
	 
	/**
     * Moves a selected piece to another location
     *
     * @param oldX The x coordinate of the selected piece
     * @param oldY The y coordinate of the selected piece
     * @param newX The x coordinate of the new location
     * @param newY The y coordinate of the new location
     */
	public void movePiece(int oldX, int oldY, int newX, int newY) { 
		board[newY][newX] = board[oldY][oldX]; 
		board[oldY][oldX] = null; 
		board[newY][newX].startX = newX; 
		board[newY][newX].startY = newY; 

	} 				

	
	
	/**
    * Prints the current state of the chess board formatted
    */
   public void display() {
       	/**
        * For printing ## every other square
        */
       boolean hash = false;
       System.out.println();
       for(int i = 0; i < 8; i++) {
           for(int j = 0; j < 8; j++) {
               if(board[i][j] == null && hash)
                   System.out.print("## ");
               else if(board[i][j] == null)
                   System.out.print("   ");
               else
                   System.out.print(board[i][j].getPiecename() + " ");

               hash = !hash;
           }
           System.out.println(8 - i);
           hash = !hash;
       }
       System.out.println(" a  b  c  d  e  f  g  h\n");
   }

}
