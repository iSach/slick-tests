package game.entity;

import game.TestGame;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EntityManager {

    private List<Entity> entities = new LinkedList<>();
    private TestGame game;

    public EntityManager(TestGame game) {
        this.game = game;
    }

    public void render(Graphics graphics) {
        ArrayList<Entity> ents = new ArrayList<>();
        ents.addAll(entities);
        Iterator<Entity> entityIterator = ents.iterator();
        while (entityIterator.hasNext()) {
            Entity ent = entityIterator.next();
            ent.render(graphics);
        }
    }

    public void update(int i) {
        ArrayList<Entity> ents = new ArrayList<>();
        ents.addAll(entities);
        Iterator<Entity> entityIterator = ents.iterator();
        while (entityIterator.hasNext()) {
            Entity ent = entityIterator.next();
            ent.update(i);
        }
    }

    public void spawnEntity(Entity entity) {
        this.entities.add(entity);
        entity.spawn();
    }

    public void despawnEntity(Entity entity) {
        entity.despawn();
    }

    protected void removeEntity(Entity entity) {
        entities.remove(entity);
    }
}
