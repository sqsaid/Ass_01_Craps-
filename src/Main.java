import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        String playAgain = "Y";

        while (playAgain.equalsIgnoreCase("Y")) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;

            System.out.println("\nInitial roll: " + die1 + " + " + die2 + " = " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You crapped out and lost.");
            }
            else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You win!");
            }
            else {
                int point = crapsRoll;
                System.out.println("The point is now " + point + ".");
                boolean done = false;

                while (!done) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int nextRoll = die1 + die2;

                    System.out.print("Next roll: " + die1 + " + " + die2 + " = " + nextRoll + " -> ");

                    if (nextRoll == point) {
                        System.out.println("Made point and won!");
                        done = true;
                    } else if (nextRoll == 7) {
                        System.out.println("Got a seven and lost.");
                        done = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("\nPlay again? (Y/N): ");
            playAgain = in.nextLine();
        }

        System.out.println("Thanks for playing!");
    }
}
