package game.util;

import org.newdawn.slick.Graphics;

import java.awt.*;

public class Segment {

    private Point2D origin;
    private Point2D end;

    public Segment(Point2D origin, Point2D end) {
        this.origin = origin;
        this.end = end;
    }

    public Segment(int x1, int y1, int x2, int y2) {
        this.origin = new Point2D(x1, y1);
        this.end = new Point2D(x2, y2);
    }

    public Point2D getEnd() {
        return end;
    }

    public Point2D getOrigin() {
        return origin;
    }

    public double getAngle() {
        return Math.atan(((double) (end.getY() - origin.getY())) / ((double) (end.getX() - origin.getX())));
    }

    public void render(Graphics graphics) {
        graphics.drawLine(origin.getX(), origin.getY(), end.getX(), end.getY());
    }

    @Override
    public String toString() {
        return origin.toString() + " -> " + end.toString();
    }
}
