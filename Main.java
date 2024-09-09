import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Player setup
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name, "Black");

        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name, "White");

        // Win condition setup
        System.out.println("Choose a win condition:");
        System.out.println("1. De Corpore (Capture a specific number of pieces)");
        System.out.println("2. De Bonis (Reach a specific value from captured pieces)");
        System.out.println("3. Victoria Magna (Capture pieces that form a specific pattern)");
        System.out.println("4. De Lite (Have the highest sum of piece values and digit count)");
        System.out.print("Enter the number of your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String winCondition;
        switch (choice) {
            case 1:
                winCondition = "De Corpore";
                break;
            case 2:
                winCondition = "De Bonis";
                break;
            case 3:
                winCondition = "Victoria Magna";
                break;
            case 4:
                winCondition = "De Lite";
                break;
            default:
                System.out.println("Invalid choice, defaulting to De Corpore.");
                winCondition = "De Corpore";
                break;
        }

        // Win threshold setup
        System.out.print("Enter the threshold for the win condition (e.g., number of pieces to capture, value to reach): ");
        int winThreshold = scanner.nextInt();

        // Initialize game
        Game game = new Game(player1, player2, winCondition, winThreshold);

        // Game loop
        while (true) {
            System.out.println(game.isPlayer1Turn() ? player1.getName() + "'s turn (Black)" : player2.getName() + "'s turn (White)");
            System.out.print("Enter your move (startX startY endX endY): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int endX = scanner.nextInt();
            int endY = scanner.nextInt();

            game.playTurn(startX, startY, endX, endY);
        }
    }
}
