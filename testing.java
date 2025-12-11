import java.util.Random;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        int num = rand.nextInt(100) + 1; // Random number between 1-100
        int guess;
        int attempts = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        
        while (true) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;
            
            if (guess == num) {
                System.out.println("Congratulations! You guessed it in " + attempts + " attempts!");
                break;
            } else if (guess < num) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        
        sc.close();
    }
}