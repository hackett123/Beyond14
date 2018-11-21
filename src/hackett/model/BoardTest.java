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
    void testRemoveTile() {
        Board board = new Board();
        
    }
}