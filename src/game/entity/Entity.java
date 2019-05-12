package game.entity;

import game.TestGame;
import game.util.Point2D;
import org.newdawn.slick.Graphics;

public abstract class Entity {

    private TestGame game;
    private int timeLived; // age (ms)
    private Point2D location;

    public Entity(TestGame game) {
        this(game, new Point2D(TestGame.WIDTH / 2, TestGame.HEIGHT / 2));
    }

    public Entity(TestGame game, Point2D location) {
        this.game = game;
        this.location = location;
    }

    public final void spawn() {

        onSpawn();
    }

    public final void despawn() {
        game.getEntityManager().removeEntity(this);

        onDespawn();
    }

    public void render(Graphics graphics) {

        onRender(graphics);
    }

    /**
     * @param i     ms since last call
     */
    public void update(int i) {
        timeLived += i;

        onUpdate(i);
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }

    public final int getTimeLived() {
        return timeLived;
    }

    public abstract void onSpawn();

    public abstract void onDespawn();

    public abstract void onRender(Graphics graphics);

    public abstract void onUpdate(int i);
}
