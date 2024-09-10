public class Pyramid extends Piece {

    Circle a = a
    Triangle b = b
    Square c = c
    
    public Pyramid(int value, String color) {
        super("Pyramid", value, 0, color);

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        return a.isValidMove() && b.isValidMove() && c.isValidMove();
    }
}
