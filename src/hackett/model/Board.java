package hackett.model;

public class Board {

    private Tile[][] board;

    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 4;

    private int currMaxTile;


    /*
    Constructor initiates the model manager and the 2d grid of tiles.
     */
    public Board() {
        this.board = new Tile[4][4];
        System.out.println(this);
    }

    public boolean isEmpty() {
        boolean isEmpty = true;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null) {
                    isEmpty = false;
                }
            }
        }
        return isEmpty;
    }
    public boolean isFull() {
        boolean isFull = true;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == null) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    /*
    Function adds a tile to a random location in the grid, as long as there is a spot
    available. If no spot is available, this returns false and we lose the game.
     */
    public boolean addTile(int val) {

        if (isFull()) return false;

        Tile newTile = new Tile(val);
        int x, y;
        do {
             x = (int) (Math.random() * 4);
             y = (int) (Math.random() * 4);
        } while (board[x][y] != null);


        board[x][y] = newTile;


        return true;
    }

    /*
    Based off of the coordinate in the board, we nullify a tile.
    We only do this if 1) we are combining tiles to a different tile, or
    2) we are using a break tool.
     */
    public void removeTile(int row, int col) {
        board[row][col] = null;
    }


    @Override
    public String toString() {
        String out = "";

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                Tile curr = board[row][col];
                if (curr == null) {
                    out += "x   ";
                } else {
                    out += curr.getVal() + "   ";
                }
            }
            out += "\n";
        }

        return out;
    }

}
