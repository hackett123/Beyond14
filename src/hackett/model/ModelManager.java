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

    public void generateNextTile() {

    }

    private ModelManager(GameController gameController) {
        this.gameController = gameController;
        this.board = new Board();
    }

}
