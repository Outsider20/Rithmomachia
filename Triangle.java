public class Triangle extends Piece {
    public Triangle(int value, String color) {
        super("Triangle", value, 3, color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        // Implement movement logic for Triangle
        return true;
    }
}
