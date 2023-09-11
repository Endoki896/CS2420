package messCode.meeting03.tetromino;

import java.awt.Point;

public abstract class Tetromino {
    protected Point[] squares;
    protected byte orientation;

    public Tetromino()
    {
        this.orientation = 0;
        this.squares = new Point[4];
    }

    public Point[] getSquares() {
        return this.squares;
    }

    public void moveLeft() {
        for (Point p : this.squares) {
            p.translate(-1, 0);
        }
    }

    public void moveRight() {
        for (Point p : this.squares) {
            p.translate(1, 0);
        }
    }

    public void moveDown() {
        for (Point p : this.squares) {
            p.translate(0, 1);
        }
    }

    public abstract void rotateCW();

    public abstract void rotateCCW();
}