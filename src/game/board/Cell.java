package game.board;

import game.util.Point2D;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Cell {

    private Point2D topLeftCorner;
    private CellShade shade;

    // Length of a cell side.
    private int size;

    public Cell(Point2D topLeftCorner, CellShade shade, int size) {
        this.topLeftCorner = topLeftCorner;
        this.shade = shade;
        this.size = size;
    }

    public void render(GameContainer gameContainer, Graphics g) {
        Color color = g.getColor();
        g.setColor(shade.getColor());
        g.fillRect((float) topLeftCorner.getX(), (float) topLeftCorner.getY(), size, size);
        g.setColor(color);
    }

    public CellShade getShade() {
        return shade;
    }

    public int getSize() {
        return size;
    }

    public Point2D getTopLeftCorner() {
        return topLeftCorner;
    }

    public Point2D getCenter() {
        int x = topLeftCorner.getX() + size / 2;
        int y = topLeftCorner.getY() + size / 2;
        return new Point2D(x, y);
    }
}
