import game.ReversiGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public Main() {

    }

    public static void main(String[] args) throws SlickException {

        AppGameContainer appGameContainer = new AppGameContainer(new ReversiGame("Reversi"));

        appGameContainer.setDisplayMode(1024, 768, false);

        appGameContainer.start();
    }
}
