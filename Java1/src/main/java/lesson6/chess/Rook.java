package lesson6.chess;

public class Rook extends Figure {

    @Override
    public boolean canMove(int x, int y) {
        return (this.x == x && this.y != y) || (this.x != x && this.y == y);
    }
}
