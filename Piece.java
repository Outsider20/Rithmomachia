public abstract class Piece {
    private String shape;
    private int value;
    private int movement;
    private String color;

    public Piece(String shape, int value, int movement, String color) {
        this.shape = shape;
        this.value = value;
        this.movement = movement;
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public int getValue() {
        return value;
    }

    public int getMovement() {
        return movement;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Board board);
}


