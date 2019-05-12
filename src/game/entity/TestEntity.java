package game.entity;

import game.TestGame;
import game.util.GraphicsUtil;
import org.newdawn.slick.Graphics;

public class TestEntity extends TransitoryEntity {

    private int lastSecond;
    private double angle;

    public TestEntity(TestGame game) {
        super(game, 5000);
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public void onDespawn() {

    }

    @Override
    public void onRender(Graphics graphics) {
        GraphicsUtil.drawOrientedRectangle(getLocation().getX(), getLocation().getY(), 100, 200, angle, graphics);
    }

    @Override
    public void onUpdate(int i) {
        int second = (int) Math.floor(getTimeLived() / 1000);

        if(second != lastSecond) {
            lastSecond = second;
            System.out.println("Lived for: " + lastSecond + "s");
        }

        angle += 0.03;
    }
}
