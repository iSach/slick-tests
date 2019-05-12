import game.TestGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public Main() {

    }

    public static void main(String[] args) throws SlickException {

        AppGameContainer appGameContainer = new AppGameContainer(new TestGame("Reversi"));

        appGameContainer.setDisplayMode(TestGame.WIDTH, TestGame.HEIGHT, false);

        appGameContainer.start();
    }
}
