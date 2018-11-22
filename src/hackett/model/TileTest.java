package hackett.model;

import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TileTest {

    @Test
    void testGetVal() {
        Tile tile = new Tile(3);
        assertEquals(tile.getVal(), 3, "Get value");
    }

    @Test
    void testGetTileColor() {
        Tile tile = new Tile(2);
        assertEquals(tile.getTileColor(), new Color(0xffaa60), "Tile color");

    }

    @Test
    void testGetTextColor() {
        Tile tile = new Tile(4);
        assertEquals(tile.getTextColor(), Color.BLACK, "Text color");
    }

    @Test
    void testIncrementVal() {
        Tile tile = new Tile(5);
        tile.incrementVal();
        assertEquals(tile.getVal(), 6, "Tile increment value");
        assertEquals(tile.getTextColor(), Color.BLACK, "Text color changed");
        assertEquals(tile.getTileColor(), new Color(0xff8787), "Tile color changed");
    }
}