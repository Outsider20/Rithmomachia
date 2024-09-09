public class Square extends Piece {
    public Square(int value, String color) {
        super("Square", value, 4, color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        // Implement movement logic for Square
        return true;
    }
}
