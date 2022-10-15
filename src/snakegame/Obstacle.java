package snakegame;

import javafx.scene.paint.Color;
public class Obstacle{
    public static final Color COLOR = Color.GOLD;
    private Point point;
    Color color = Color.RED;
    Obstacle(Point point)
    {
        this.point = point;  
    }
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
