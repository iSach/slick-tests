package game;

import game.board.Board;
import game.util.Point2D;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;

public class ReversiGame extends BasicGame {

    public static Image LOGO;

    private Board board;

    public ReversiGame(String title) {
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
        this.board = new Board(8, 60, new Point2D(100, 150));
    }

    @Override
    public void update(GameContainer gameContainer, int i) {

    }

    @Override
    public void render(GameContainer gc, Graphics g) {

        // Render the beautiful logo
        if (LOGO != null)
            LOGO.draw(gc.getWidth() / 2 - 200, 30, 400, 100);

        // Render our board
        board.render(gc, g);
    }

    @Override
    public void keyPressed(int key, char c) {
        // Tests...

        if(c >= 'a' && c <= 'h') {
            if(Keyboard.isKeyDown(Keyboard.KEY_1)) {
                System.out.println(Character.toUpperCase(c) + "1");
            }
        }
    }
}
