public class Board {
    private Piece[][] grid = new Piece[8][16];

    public Board() {
        initializePieces();
    }

    private void initializePieces() {
        // Initialize Black Pieces
        grid[0][0] = new Circle(2, "Black");
        grid[0][1] = new Triangle(6, "Black");
        grid[0][2] = new Square(12, "Black");
        grid[0][3] = new Circle(20, "Black");
        grid[0][4] = new Pyramid(30, "Black");

        // Initialize White Pieces
        grid[7][15] = new Circle(2, "White");
        grid[7][14] = new Triangle(6, "White");
        grid[7][13] = new Square(12, "White");
        grid[7][12] = new Circle(20, "White");
        grid[7][11] = new Pyramid(30, "White");

        // Additional pieces initialization as per the game rules
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = grid[startX][startY];
        if (piece != null && piece.isValidMove(startX, startY, endX, endY, this)) {
            grid[endX][endY] = piece;
            grid[startX][startY] = null;
            return true;
        }
        return false;
    }

    public Piece getPieceAt(int x, int y) {
        return grid[x][y];
    }
}

