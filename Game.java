import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author duane
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private boolean isPlayer1Turn;

    private String winCondition; // Stores the selected win condition
    private int winThreshold;    // Stores the threshold for the selected win condition

    private int player1Captured = 0;
    private int player2Captured = 0;
    private int player1Value = 0;
    private int player2Value = 0;
    private List<Integer> player1CapturedValues = new ArrayList<>();
    private List<Integer> player2CapturedValues = new ArrayList<>();
    private int player1DigitCount = 0;
    private int player2DigitCount = 0;

    public Game(Player player1, Player player2, String winCondition, int winThreshold) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.isPlayer1Turn = true;
        this.winCondition = winCondition;
        this.winThreshold = winThreshold;
    }

    public void playTurn(int startX, int startY, int endX, int endY) {
        Player currentPlayer = isPlayer1Turn ? player1 : player2;
        if (currentPlayer.makeMove(startX, startY, endX, endY, board)) {
            Piece capturedPiece = board.getPieceAt(endX, endY);
            if (capturedPiece != null) {
                capturePiece(currentPlayer, capturedPiece);
            }
            if (checkWin()) {
                System.exit(0);
            }
            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    private void capturePiece(Player player, Piece piece) {
        int value = piece.getValue();
        int digits = countDigits(value);

        if (player.equals(player1)) {
            player1Captured++;
            player1Value += value;
            player1CapturedValues.add(value);
            player1DigitCount += digits;
        } else {
            player2Captured++;
            player2Value += value;
            player2CapturedValues.add(value);
            player2DigitCount += digits;
        }
    }

    private boolean checkWin() {
        switch (winCondition) {
            case "De Corpore":
                return checkDeCorpore();
            case "De Bonis":
                return checkDeBonis();
            case "Victoria Magna":
                return checkVictoriaMagna();
            case "De Lite":
                return checkDeLite();
            default:
                return false;
        }
    }

    private boolean checkDeCorpore() {
        if (player1Captured >= winThreshold) {
            System.out.println(player1.getName() + " wins by De Corpore!");
            return true;
        } else if (player2Captured >= winThreshold) {
            System.out.println(player2.getName() + " wins by De Corpore!");
            return true;
        }
        return false;
    }

    private boolean checkDeBonis() {
        if (player1Value >= winThreshold) {
            System.out.println(player1.getName() + " wins by De Bonis!");
            return true;
        } else if (player2Value >= winThreshold) {
            System.out.println(player2.getName() + " wins by De Bonis!");
            return true;
        }
        return false;
    }
    
     static boolean checkIsAP(int arr[], int n)
    {
        if (n == 1)
            return true;
         
        // Sort array
        Arrays.sort(arr);
         
        // After sorting, difference between
        // consecutive elements must be same.
        int d = arr[1] - arr[0];
        for (int i = 2; i < n; i++)
            if (arr[i] - arr[i-1] != d)
                return false;
         
        return true;
    }

    private boolean checkProperVictory() {
        if (checkArithmeticProgression(player1CapturedValues)) {
            System.out.println(player1.getName() + " wins by Victoria Magna (Arithmetic Progression)!");
            return true;
        } else if (checkArithmeticProgression(player2CapturedValues)) {
            System.out.println(player2.getName() + " wins by Victoria Magna (Arithmetic Progression)!");
            return true;
        }
        
        return false;
    }

    private boolean checkDeLite() {
        if (player1Value > player2Value && player1DigitCount > player2DigitCount) {
            System.out.println(player1.getName() + " wins by De Lite!");
            return true;
        } else if (player2Value > player1Value && player2DigitCount > player1DigitCount) {
            System.out.println(player2.getName() + " wins by De Lite!");
            return true;
        }
        return false;
    }
    
    // Check if the list forms an arithmetic series
    public static boolean isArithmetic(List<Double> numbers) {
        if (numbers.size() != 3 && numbers.size() != 4) {
            return false;
        }
        double diff = numbers.get(1) - numbers.get(0);
        for (int i = 1; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1) - numbers.get(i) != diff) {
                return false;
            }
        }
        return true;
    }

    // Check if the list forms a geometric series
    public static boolean isGeometric(List<Integer> numbers) {
        if (numbers.size() != 4) {
            return false;
        }
        double ratio = numbers.get(1) / numbers.get(0);
        for (int i = 1; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1) / numbers.get(i) != ratio) {
                return false;
            }
        }
        return true;
    }

    // Check if the list forms a harmonic series
    public static boolean isHarmonic(List<Integer> numbers) {
        if (numbers.size() != 4) {
            return false;
        }
        double reciprocal1 = 1 / numbers.get(0);
        double reciprocal2 = 1 / numbers.get(1);
        double reciprocal3 = 1 / numbers.get(2);
        double reciprocal4 = 1 / numbers.get(3);
        
        double diff = reciprocal2 - reciprocal1;
        return (reciprocal3 - reciprocal2 == diff && reciprocal4 - reciprocal3 == diff);
    }

    public static void counter(List<Integer> numbers) {
        
        // Counters
        int arithmeticCount = 0;
        int geometricCount = 0;
        int harmonicCount = 0;

        // Check the list
        if (isArithmetic(numbers)) {
            arithmeticCount++;
        }
        if (isGeometric(numbers)) {
            geometricCount++;
        }
        if (isHarmonic(numbers)) {
            harmonicCount++;
        }

        // Output the results
        System.out.println("Arithmetic series passed: " + arithmeticCount);
        System.out.println("Geometric series passed: " + geometricCount);
        System.out.println("Harmonic series passed: " + harmonicCount);
        
        int totalSeriesCounter;
        totalSeriesCounter = arithmeticCount + geometricCount + harmonicCount;
        
        System.out.println( );
        
        switch (totalSeriesCounter){
            case 0 -> {
                System.out.println( );
            }
            case 1 -> {
                System.out.println( );
            }
            case 2 -> {
                System.out.println( );
            }
            case 3 -> {
                
            }
        }
    }
}
