public class Pyramid extends Piece {
    public Pyramid(int value, String color) {
        super("Pyramid", value, 0, color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        // Implement movement logic for Pyramid
        return true;
    }
}
