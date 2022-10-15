package snakegame;
import javafx.scene.paint.Color;
public class Food{
    public static final Color COLOR = Color.RED;
    private Point point;
    Color color = Color.RED;
    Food(Point point)
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
