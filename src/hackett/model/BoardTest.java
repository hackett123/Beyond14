package hackett.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testIsEmptyOnEmpty() {
        Board board = new Board();
        assertTrue(board.isEmpty(), "Empty board is empty");
    }

    @Test
    void testIsEmptyOnFull() {
        Board board = new Board();
        for (int i = 0; i < 16; i++) {
            board.addTile((int) (Math.random() * 10));
        }

        assertFalse(board.isEmpty(), "Full board is not empty");
    }

    @Test
    void testIsEmptyOnNonEmpty() {
        Board board = new Board();
        board.addTile(2);
        assertFalse(board.isEmpty(), "Nonempty board is not empty");
    }

    @Test
    void testIsFullOnFull() {
        Board board = new Board();
        for (int i = 0; i < 16; i++) {
            board.addTile((int) (Math.random() * 10));
        }

        assertTrue(board.isFull(), "Full board is full");
    }

    @Test
    void testIsFullOnNonFull() {
        Board board = new Board();

        board.addTile(2);
        board.addTile(4);

        assertFalse(board.isFull(), "Non-full board is not full");
    }

    @Test
    void testIsFullOnEmpty() {
        Board board = new Board();
        assertFalse(board.isFull(), "Empty board is not full");
    }

    @Test
    void testRemoveTileSuccessful() {
        Board board = new Board();
        board.addTile(1, 0, 0);
        board.removeTile(0, 0);
        assertTrue(board.isEmpty(), "Add one, remove one");
    }

    @Test
    void testAddTileAtPos() {
        Board board = new Board();
        board.addTile(1, 3, 2);
        assertTrue(board.getTileAt(3, 2) != null);
    }

    @Test
    void testRemoveTileNull() {
        Board board = new Board();
        assertFalse(board.removeTile(0, 0), "Remove from null space");
    }

    @Test
    void testFindNewCurrMaxAllNull() {
        Board board = new Board();
        assertEquals(-1, board.findNewCurrMax(), "Find max on null board");
    }
    @Test
    void testFindNewCurrMaxOneTile() {
        Board board = new Board();
        board.addTile(1, 0, 0);
        board.addTile(2, 0, 1);
        board.removeTile(0, 1);
        assertEquals(board.getCurrMaxTile(), 1);
        assertEquals(board.findNewCurrMax(), 1, "New max");
    }

    @Test
    void testTileCountNull() {
        Board board = new Board();
        assertEquals(board.getTileCount(), 0, "Empty board count");
    }
    @Test
    void testTileCountSingleton() {
        Board board = new Board();
        board.addTile(1);
        assertEquals(board.getTileCount(), 1, "Singleton board count");
    }
    @Test
    void testTileCountMulti() {
        Board board = new Board();
        board.addTile(1);
        board.addTile(1);
        assertEquals(board.getTileCount(), 2, "Multi board count");
    }
    @Test
    void testTileCountFull() {
        Board board = new Board();
        for (int i = 0; i < 16; i++) {
            board.addTile(i);
        }

    }
}