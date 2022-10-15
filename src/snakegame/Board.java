package snakegame;

import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
public class Board{
    public static final int SIZE = 10;
    public static final Color COLOR = Color.DARKGREEN;

    private final int cols;    
    private final int rows;     

    private snakegame.Snake snake;
    private snakegame.Food food;
    private snakegame.Obstacle obstacle1;
    private snakegame.Obstacle obstacle2;
    private snakegame.Obstacle obstacle3;

    public Board(final double width, final double height) {
        rows = (int) width / SIZE;
        cols = (int) height / SIZE;

       
        snake = new snakegame.Snake(this, new snakegame.Point(rows / 2, cols / 2));

      
        food = new snakegame.Food(getRandomPoint());
        
        obstacle1 = new snakegame.Obstacle(getRandomPoint());
        obstacle2 = new snakegame.Obstacle(getRandomPoint());
        obstacle3 = new snakegame.Obstacle(getRandomPoint());
    }

    public snakegame.Point wrap(snakegame.Point point) {
        int x = point.getX();
        int y = point.getY();
        if (x >= rows) x = 0;
        if (y >= cols) y = 0;
        if (x < 0) x = rows - 1;
        if (y < 0) y = cols - 1;
        return new snakegame.Point(x, y);
    }

    private snakegame.Point getRandomPoint() {
        Random random = new Random();
        snakegame.Point point;
        do {
            point = new snakegame.Point(random.nextInt(rows), random.nextInt(cols));
        } while (point.equals(snake.getHead()));
        return point;
    }
    public void update() {
        if (food.getPoint().equals(snake.getHead())) {
            snake.extend();
            food.setPoint(getRandomPoint());
        } 
        else if (obstacle1.getPoint().equals(snake.getHead()) || obstacle2.getPoint().equals(snake.getHead()) || obstacle3.getPoint().equals(snake.getHead())){
            snake.setIsSafe(false);
        }
        else {
            snake.move();
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return cols * SIZE;
    }

    public snakegame.Snake getSnake() {
        return snake;
    }

    public snakegame.Food getFood() {
        return food;
    }
    public snakegame.Obstacle getObstacle1() {
        return obstacle1;
    }
    public snakegame.Obstacle getObstacle2() {
        return obstacle2;
    }
    public snakegame.Obstacle getObstacle3() {
        return obstacle3;
    }
}
