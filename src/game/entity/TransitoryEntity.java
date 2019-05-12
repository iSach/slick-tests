package game.entity;

import game.TestGame;
import org.newdawn.slick.Graphics;

public abstract class TransitoryEntity extends Entity {

    /*
    Life span in milliseconds.
     */
    private int lifespan;

    public TransitoryEntity(TestGame game, int lifespan) {
        super(game);

        this.lifespan = lifespan;
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public void onDespawn() {}

    @Override
    public void onRender(Graphics graphics) {

    }

    @Override
    public void update(int i) {
        super.update(i);

        if(getTimeLived() > lifespan) {
            despawn();
        }
    }
}

