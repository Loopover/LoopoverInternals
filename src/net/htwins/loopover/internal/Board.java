package net.htwins.loopover.internal;

public class Board {
    private int[][] board;
    private int width;
    private int height;
    
    public Board(int width, int height) {
        board = new int[width][height];
        this.width = width;
        this.height = height;
        int i = 0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                board[x][y] = i;
                i++;
            }
        }
    }
    
    public void moveRow(int row, int length) {
        int[] newRow = new int[height];
        for(int i = 0; i < width; i++) {
            int newPos = i+length;
            newPos %= width;
            if(newPos < 0) newPos += width;
            newRow[newPos] = board[i][row];
        }
        for(int i = 0; i < width; i++) {
            board[i][row] = newRow[i];
        }
    }
    
    public void moveColumn(int column, int length) {
        int[] newColumn = new int[width];
        for(int i = 0; i < width; i++) {
            int newPos = i+length;
            newPos %= width;
            if(newPos < 0) newPos += width;
            newColumn[newPos] = board[column][i];
        }
        for(int i = 0; i < width; i++) {
            board[column][i] = newColumn[i];
        }
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getSquare(int x, int y) {
        return board[x][y];
    }
    
    public int[] findPiece(int num) {
        for(int i = 0; i < width; i++)
            for(int j = 0; j < height; j++)
                if(board[i][j] == num)
                    return new int[] {i, j};
        return null;
    }
}
