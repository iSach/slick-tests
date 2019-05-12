package game;

import game.entity.EntityManager;
import game.entity.StormEntity;
import game.entity.TestEntity;
import game.render.RenderQueue;
import game.util.Point2D;
import org.newdawn.slick.*;

public class TestGame extends BasicGame {

    public static Image LOGO;
    public static int WIDTH = 1024;
    public static int HEIGHT = 769;

    private RenderQueue renderQueue;
    private EntityManager entityManager;

    public TestGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) {
        try {
            LOGO = new Image("/Users/sachalewin/IdeaProjects/SlickTest/assets/logo.png");
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        // Init board
        // this.board = new Board(8, 60, new Point2D(100, 150));

        this.renderQueue = new RenderQueue(this);

        this.entityManager = new EntityManager(this);
    }

    @Override
    public void update(GameContainer gameContainer, int i) {
        entityManager.update(i);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        // Render the beautiful logo
        if (LOGO != null)
            LOGO.draw(gc.getWidth() / 2 - 200, 30, 400, 100);

        entityManager.render(g);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        StormEntity storm = new StormEntity(this, 60);
        storm.setLocation(new Point2D(x, y));
        entityManager.spawnEntity(storm);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
