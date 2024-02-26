package com.example.chess.pieces;
import com.example.chess.app.*;

/**
 * The basis for a standard chess piece
 *
 * @author Daniel Wang
 * @author Dustin LEe
 */
public abstract class Piece {
	/**
     * Tracks if the piece is white
     */
    private boolean white = true;
    /**
     * Tracks if the piece has made a move yet
     */
    public boolean firstMove = true;
    /**
     * Tracks if the starting x and y coordinate of the piece 
     */
    public int startX, startY;
    
    /**
     * Constructor
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param white piece color
     */
    public Piece(int startX, int startY, boolean white) {
    	this.startX = startX;
    	this.startY = startY;
    	this.white = white;
    }
    
    /**
     * Getter for int x
     *
     * @return the x-coordinate
     */
    public int getX() {  
    	return startX;
    }
    /**
     * Getter for int y
     *
     * @return the y-coordinate
     */
    public int getY() {
    	return startY;
    }
    /**
     * Getter for boolean white
     *
     * @return True if the piece is white
     */
    public boolean isWhite(){
        return this.white;
    }
    
    /**
     * Used to validate if a horizontal path is clear 
     *
     * @param newX the new x coordinate the piece wants to go to
     * @param newY the new y coordinate the piece wants to go to
     * @param board The chess board
     * @return True if the path is clear
     */
    public boolean isHorizontalClear(int newX, int newY, Board board) {
    	int deltaX = Math.abs(newX - startX);
        int deltaY = Math.abs(newY - startY);
        
    	//Vertical Movement - Check for clear path
        if (deltaX==0) {
        	//Moving up
        	if (newY<startY) {
        		for (int i=newY+1; i<startY; i++) {
        			if (!board.isEmpty(startX, i)) return false;
        		}
        		return true;
        	}
        	
        	//Moving down
        	if (newY>startY) {
        		for (int i=startY+1; i<newY; i++) {
        			if (!board.isEmpty(startX, i)) return false;
        		}
        		return true;
        	}
        	
        }
        
        
        // Horizontal Movement - Check for clear path
        if (deltaY==0) {
        	//Moving left
        	if (newX<startX) {
        		for (int i=newX+1; i<startX; i++) {
        			if (!board.isEmpty(i, startY)) return false;
        		}
        		return true;
        	}
        	
        	//Moving right
        	if (newX>startX) {
        		for (int i=startX+1; i<newX; i++) {
        			if (!board.isEmpty(i, startY)) return false;
        		}
        		return true;
        	}
        	
        }
        
        return false;
    }
    
    /**
     * Used to validate if a diagonal path is clear 
     *
     * @param newX the new x coordinate the piece wants to go to
     * @param newY the new y coordinate the piece wants to go to
     * @param board The chess board
     * @return True if the path is clear
     */
    public boolean isDiagonalClear(int newX, int newY, Board board) {

     // Upward Movement - Check for clear path
        if (newY<startY) {
        	//Moving left
        	if (newX<startX) {
        		for (int i=newX+1, j = newY+1; i<startX && j<startY; i++, j++) {
        			if (!board.isEmpty(i,j)) return false;
        		}
        		return true;
        	}
        	
        	//Moving right
        	if (newX>startX) {
        		for (int i=newX-1, j = newY+1; i>startX && j<startY; i--, j++) {
        			if (!board.isEmpty(i,j)) return false;
        		}
        		return true;
        	}
        }
        
        // Downward Movement - Check for clear path
        if (newY>startY) {
        	//Moving left
        	if (newX<startX) {
        		for (int i=newX+1, j = newY-1; i<startX && j>startY; i++, j--) {
        			if (!board.isEmpty(i,j)) return false;
        		}
        		return true;
        	}
        	
        	//Moving right
        	if (newX>startX) {
        		for (int i=newX-1, j = newY-1; i>startX && j>startY; i--, j--) {
        			if (!board.isEmpty(i,j)) return false;
        		}
        		return true;
        	}
        }
        
     
        return false;
    	
    }
    
    /**
     * Used by each chess piece to validate if a move is legal
     *
     * @param newX the new x coordinate the piece wants to go to
     * @param newY the new y coordinate the piece wants to go to
     * @param isNewSpotEmpty boolean value identifies if the new spot is empty
     * @param board The chess board
     * @return True if the piece can move ot the end point legally, false otherwise
     */
    public abstract boolean isLegalMove(int newX, int newY, boolean isNewSpotEmpty, Board board);
    /**
     * Tracks if pawn is eligible for promotion
     */
    public char promotion;
    /**
     * Tracks if en passant is possible
     */
    public boolean enpassant;
    /**
     * Tracks if castling is possible
     */
    public char castling = '0';

    /**
     * Gets the name of the piece
     *
     * @return String of the piece name
     */
    public abstract String getPiecename();
}