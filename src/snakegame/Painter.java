package snakegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static snakegame.Board.SIZE;
public class Painter {


    public static void paint(Board board, GraphicsContext gc) {
        gc.setFill(Board.COLOR);
        gc.fillRect(0, 0, board.getWidth(), board.getHeight());

        // Now the Food
        gc.setFill(Food.COLOR);
        paintPoint(board.getFood().getPoint(), gc);
        
        gc.setFill(Obstacle.COLOR);
        paintPoint(board.getObstacle1().getPoint(), gc);
        
        gc.setFill(Obstacle.COLOR);
        paintPoint(board.getObstacle2().getPoint(), gc);
        
        gc.setFill(Obstacle.COLOR);
        paintPoint(board.getObstacle3().getPoint(), gc);

        // Now the snake
        Snake snake = board.getSnake();
        gc.setFill(Snake.COLOR);
        snake.getPoints().forEach(point -> paintPoint(point, gc));
        if (!snake.isSafe()) {
            gc.setFill(Snake.DEAD);
            paintPoint(snake.getHead(), gc);
        }
    }

    private static void paintPoint(Point point, GraphicsContext gc) {
        gc.fillRect(point.getX() * SIZE, point.getY() * SIZE, SIZE, SIZE);
    }

    public static void paintResetMessage(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Hit ENTER to reset.", 10, 10);
    }
}