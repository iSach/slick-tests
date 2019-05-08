package game.board;

import game.util.Point2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Board {

    // Board: boardSize x boardSize
    private int boardSize;

    // Length of the side of a single cell.
    private int cellSize;

    // Position of the top left corner of the board
    private Point2D position;

    private Cell[][] cells;

    public Board(int boardSize, int cellSize, Point2D position) {
        this.boardSize = boardSize;
        this.cellSize = cellSize;
        this.position = position;
        this.cells = new Cell[boardSize][boardSize];

        // Fill the board with cells.
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                int x = position.getX() + j * cellSize;
                int y = position.getY() + i * cellSize;
                CellShade shade = (i + j) % 2 == 0 ? CellShade.DARK : CellShade.LIGHT; // 1 case out of 2 is dark
                cells[i][j] = new Cell(new Point2D(x, y), shade, cellSize);
            }
        }
    }

    public void render(GameContainer gc, Graphics g) {

        // Render each cell:
        for(int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j].render(gc, g);
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getCellSize() {
        return cellSize;
    }

    public Point2D getPosition() {
        return position;
    }
}
