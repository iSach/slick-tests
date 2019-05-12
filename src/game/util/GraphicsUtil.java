package game.util;

import org.newdawn.slick.Graphics;

public class GraphicsUtil {

    public static void drawOrientedRectangle(int x, int y, int width, int height, double angle, Graphics g) {
        Point2D a = new Point2D(x, y);

        Point2D b = new Point2D(width, 0).rotate(angle).add(a);
        Point2D c = new Point2D(width, -height).rotate(angle).add(a);
        Point2D d = new Point2D(0, -height).rotate(angle).add(a);

        g.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
        g.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
        g.drawLine(c.getX(), c.getY(), d.getX(), d.getY());
        g.drawLine(d.getX(), d.getY(), a.getX(), a.getY());
    }

}
