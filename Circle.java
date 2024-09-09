public class Circle extends Piece {
    public Circle(int value, String color) {
        super("Circle", value, 1, color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        // Implement movement logic for Circle
        return true;
    }
}
