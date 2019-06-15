package hackett.model;

import hackett.controller.GameController;

public class ModelManager {

    private static ModelManager instance;
    private GameController gameController;
    private Board board;

    public static ModelManager getInstance(GameController gameController) {
        if (instance == null) {
            instance = new ModelManager(gameController);
        }
        return instance;
    }

    /*
    Taken from user input.
    1. Add tile to board at position x,y
    2. Combine tiles recursively onto this position.
        a. search through neighbors, if same value, remove.
        d. increment tile at position x,y
     */
    public void placeTile(int value, int x, int y) {
        board.addTile(value, x, y);
        scourRemoveCombine(value, x, y);



    }

    private void scourRemoveCombine(int value, int x, int y) {

        boolean increment = false;

        //scour for neighbors and remove if same value
        for (int i = -1; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    try {
                        Tile curr = board.getTileAt(x + i, y + j);
                        if (curr != null) {
                            if (curr.getVal() == value) {
                                increment = true;
                                board.removeTile(x + i, y + j);
                            }
                        }
                    } catch (IndexOutOfBoundsException ie) {
                        //do nothing
                    }
                }
            }
        }

        if (increment) {
            board.getTileAt(x, y).incrementVal();
            scourRemoveCombine(board.getTileAt(x, y).getVal(), x, y);
        }
    }

    /*
    Called after a tile is placed, this decides what tile is to be added
    next. Returns an int.
     */
    public int generateNextValue() {
        int out = 0;
        if (board.getCurrMaxTile() < 8) {
            out = (int) (Math.random() * 5);
        } else if (board.getCurrMaxTile() < 15) {
            out = 4 + (int) (Math.random() * 5);
        } else {
            out = 9 + (int) (Math.random() * 5);
        }
        return out;
    }

    private ModelManager(GameController gameController) {
        this.gameController = gameController;
        this.board = new Board();
    }

}
