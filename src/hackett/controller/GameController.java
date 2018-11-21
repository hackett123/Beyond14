/*
The Controller of Beyond14. Bridges the view to the model yet keeps them separate.
 */


package hackett.controller;

import hackett.model.ModelManager;
import hackett.view.GuiHandler;

import javax.swing.*;

public class GameController {

    private static GameController instance;
    private ModelManager modelManager;
    private GuiHandler guiHandler;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    private GameController() {
        this.modelManager = ModelManager.getInstance(instance);
        SwingUtilities.invokeLater(this.guiHandler = GuiHandler.getInstance(instance));
    }

}
