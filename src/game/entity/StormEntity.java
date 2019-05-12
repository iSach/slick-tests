package game.entity;

import game.TestGame;
import game.util.GraphicsUtil;
import game.util.Point2D;
import game.util.Segment;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StormEntity extends TransitoryEntity {

    private List<Segment> segments = new ArrayList<>();
    private Random random = new Random();
    private int length;
    private double deviationAngle = Math.PI / 8;

    public StormEntity(TestGame game, int length) {
        super(game, 1200);

        this.length = length;
    }

    @Override
    public void onSpawn() {
        // Generate points
        Point2D startPoint = getLocation();

        double randomAngle = randomDouble(Math.PI / 10, 9 * Math.PI / 10);

        Point2D newPoint = new Point2D(startPoint.getX() + (int) (length * Math.cos(randomAngle)), startPoint.getY() + (int) (length * Math.sin(randomAngle)));

        Segment s = new Segment(startPoint, newPoint);

        segments.add(s);

        generateTree(4, s, length);
    }

    private void generateTree(int branches, Segment start, int maxLength) {
        if (branches > 0) {
            for (int i = 0; i < branches; i++) {
                // Generate new segment
                Point2D from = start.getEnd();

                double randomAngle = randomDouble(start.getAngle() - deviationAngle, start.getAngle() + deviationAngle);
                int randomLength = (int) (randomDouble(0.6, 1) * maxLength);

                Point2D to = new Point2D(from.getX() + (int) (randomLength * Math.cos(randomAngle)), from.getY() + (int) (randomLength * Math.sin(randomAngle)));

                Segment segment = new Segment(from, to);

                segments.add(segment);

                generateTree(branches - 1, segment, (int) (0.9 * maxLength));
            }
        }
    }

    @Override
    public void onDespawn() {

    }

    @Override
    public void onRender(Graphics graphics) {
        // Render segments
        ArrayList<Segment> segs = new ArrayList<>();
        segs.addAll(segments);
        Iterator<Segment> iterator = segs.iterator();
        while (iterator.hasNext()) {
            Segment s = iterator.next();
            s.render(graphics);
        }
    }

    @Override
    public void onUpdate(int i) {

    }

    static double randomDouble(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    static int randomInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return min + (max - min) * r.nextInt();
    }
}
