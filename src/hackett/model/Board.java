package hackett.model;

public class Board {

    private Tile[][] board;

    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 4;

    private int currMaxTile;
    private int tileCount;


    /*
    Constructor initiates the model manager and the 2d grid of tiles.
     */
    public Board() {
        this.board = new Tile[4][4];
        this.currMaxTile = 0;
        this.tileCount = 0;
    }

    public int getTileCount() {
        return this.tileCount;
    }
    public int getCurrMaxTile() {
        return this.currMaxTile;
    }

    public Tile getTileAt(int x, int y) {
        return board[x][y];
    }

    /*
    Called upon when we remove the highest value.
     */
    public int findNewCurrMax() {
        int max = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getVal() > max) {
                        max = board[i][j].getVal();
                    }
                }
            }
        }
        return max;
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
        this.tileCount++;
        if (val > this.currMaxTile) {
            this.currMaxTile = val;
        }

        return true;
    }

    /*
    Overloads with other addTile for if we are adding to a specific tile. This occurs with user input.
     */
    public boolean addTile(int val, int x, int y) {
        if (isFull() || board[x][y] != null) {
            return false;
        }

        Tile newTile = new Tile(val);
        board[x][y] = newTile;
        this.tileCount++;
        if (val > this.currMaxTile) {
            this.currMaxTile = val;
        }

        return true;
    }

    /*
    Based off of the coordinate in the board, we nullify a tile.
    We only do this if 1) we are combining tiles to a different tile, or
    2) we are using a break tool.
    We return a boolean : true if we are successful.
     */
    public boolean removeTile(int row, int col) {

        //only remove if present.
        if (board[row][col] != null) {

            int thisVal = board[row][col].getVal();
            board[row][col] = null;
            this.tileCount--;

            //reset current max if we removed it.
            if (thisVal == this.currMaxTile) {
                this.currMaxTile = findNewCurrMax();
            }

            return true;
        }
        return false;
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
