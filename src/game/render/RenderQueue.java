package game.render;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class RenderQueue {

    private BasicGame game;

    private volatile List<WaitingRendereable> toRender;

    public RenderQueue(BasicGame game) {
        this.game = game;

        this.toRender = new ArrayList<>();
    }

    public void render(Graphics graphics) {
        for(WaitingRendereable rendereable : toRender) {
            rendereable.render(graphics);
        }
        toRender.clear();
    }

    public void addToQueue(WaitingRendereable toRender, boolean prioritize) {
        if(prioritize)
            this.toRender.add(0, toRender);
        else
            this.toRender.add(toRender);
    }

    public void addToQueue(WaitingRendereable toRender) {
        addToQueue(toRender, false);
    }

}
