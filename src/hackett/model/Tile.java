package hackett.model;

import java.awt.Color;

public class Tile {

    private int val;
    private Color tileColor;
    private Color textColor;
    private static final Color ZERO = new Color(0x006652);
    private static final Color ONE = new Color(0xc5f9ef);
    private static final Color TWO = new Color(0xffaa60);
    private static final Color THREE = new Color(0x033a4c);
    private static final Color FOUR = new Color(0xffeaec);
    private static final Color FIVE = new Color(0xfff789);
    private static final Color SIX = new Color(0xff8787);


    /*
    Constructor. Initiates value and gives a color.
     */
    public Tile(int val) {
        this.val = val;
        setColor(this.val);
    }


    /*
    Getter for value.
     */
    public int getVal() {
        return this.val;
    }

    /*
    Get tile color
     */
    public Color getTileColor() {
        return this.tileColor;
    }

    /*
    Get text color
     */
    public Color getTextColor() {
        return this.textColor;
    }

    /*
    Raise our value by one after the n tiles are combined. Note only one is incremented,
    and the others are thrown away (to null).
     */
    public void incrementVal() {
        this.setColor(++this.val);
    }

    /*
    Set the color of our tile, we have seven colors. After 7, we loop again.
     */
    private void setColor(int val) {
        switch (val % 7) {
            case 0 :
                this.tileColor = ZERO;
                this.textColor = Color.WHITE;
                break;
            case 1 :
                this.tileColor = ONE;
                this.textColor = Color.BLACK;
                break;
            case 2 :
                this.tileColor = TWO;
                this.textColor = Color.BLACK;
                break;
            case 3 :
                this.tileColor = THREE;
                this.textColor = Color.WHITE;
                break;
            case 4 :
                this.tileColor = FOUR;
                this.textColor = Color.BLACK;
                break;
            case 5 :
                this.tileColor = FIVE;
                this.textColor = Color.BLACK;
                break;
            case 6 :
                this.tileColor = SIX;
                this.textColor = Color.BLACK;
                break;
        }
    }

}
