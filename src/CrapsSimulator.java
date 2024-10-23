import java.util.Scanner;

public class CrapsSimulator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Craps Simulator! \n" +
                "The Rules of the Game:\n" +
                "- There is an initial roll of 2 dice resulting in a sum of 2 – 12.\n" +
                "- If the sum is 2, 3, or 12 it is called \"craps\" or \"crapping out\" and the game is over with a loss.\n" +
                "- If the sum is 7 or 11 it is called a \"natural\" and the game is over with a win.\n" +
                "- For all other values, the sum becomes \"the point\" and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win.\n" +
                "- After a win or loss, the next player rolls the die for a new game. In our simulation, the program will simply ask the user if they want to continue to play.\nLet's play!\n");

        int turns = 0;
        int point = 0;
        int turnSum = 0;
        boolean gameOver = false;
        boolean playAgain = true;
        boolean playAgainHasResponse = false;

        do {

            do {
                turnSum = DiceRoll();
                System.out.println("Sum : " + turnSum);
                turns++;
                gameOver = WinOrLose(turns, turnSum, point);
                if (!gameOver) {
                    if (turns == 1) {
                        point = turnSum;
                    }
                    System.out.println("Reroll: You must score a " + point + " to win or a 7 to lose.");
                }
            } while (!gameOver);

            do {
                System.out.println("Would you like to play again? [TRUE/FALSE]");
                if (scan.hasNextBoolean()) {
                    playAgain = scan.nextBoolean();
                    playAgainHasResponse = true;
                } else {
                    System.out.println("You have inputted an invalid response - please try again.");
                    scan.nextLine();
                }
            } while (!playAgainHasResponse);

    } while (playAgain) ;
    }

    public static Integer DiceRoll() {
        int roll1 = (int)(Math.random() * 6) + 1;
        int roll2 = (int)(Math.random() *6) +1;

        System.out.println("Roll 1: " + roll1 + "\nRoll 2: " + roll2);
        return (roll1 + roll2);
    }

    public static boolean WinOrLose(int turns, int turnSum, int point) {
        if (turns == 1) {
            if (turnSum == 7 || turnSum == 1) {
                System.out.println("You won!");
                return true;
            } else if (turnSum == 2 || turnSum == 3 || turnSum == 12) {
                System.out.println("You lost - you crapped out.");
                return true;
            } else {
               return false;
            }
        } else {
            if (turnSum == point) {
                System.out.println("You won!");
                return true;
            } else if (turnSum == 7) {
                System.out.println("You lose - you crapped out.");
                return true;
            } else {
                return false;
            }
        }
    }

}