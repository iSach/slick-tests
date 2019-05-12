package game.util;

public class Point2D {

    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point2D rotate(double angle) {
        int new_x = (int) (x * Math.cos(angle) - y * Math.sin(angle));
        int new_y = (int) (x * Math.sin(angle) + y * Math.cos(angle));
        this.x = new_x;
        this.y = new_y;

        return this;
    }

    public Point2D add(int x, int y) {
        this.x += x;
        this.y += y;

        return this;
    }

    public Point2D add(Point2D point2D) {
        this.x += point2D.getX();
        this.y += point2D.getY();

        return this;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
