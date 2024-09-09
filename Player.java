public class Player {
    private String name;
    private String color;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean makeMove(int startX, int startY, int endX, int endY, Board board) {
        Piece piece = board.getPieceAt(startX, startY);
        if (piece != null && piece.getColor().equals(this.color)) {
            return board.movePiece(startX, startY, endX, endY);
        }
        return false;
    }
}
