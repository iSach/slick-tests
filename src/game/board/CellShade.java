package game.board;

import org.newdawn.slick.Color;

public enum CellShade {

    LIGHT(Color.gray),
    DARK(Color.darkGray);

    private Color color;

    CellShade(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
