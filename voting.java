import java.util.Scanner;
public class voting{ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bjpVotes = 0;
        int congressVotes = 0;
        int brsVotes = 0;
        int janasenaVotes = 0;
        int numberOfVoters = 15;
        System.out.println(" VOTING SIMULATOR ");
        System.out.println("Total voters to register: " + numberOfVoters);
        System.out.println();  
        int eligibleVoters = 0;
        int ineligibleVoters = 0;
        for (int i = 1; i <= numberOfVoters; i++) {
            System.out.println("Voter #" + i);
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine();    
            if (age < 18) {
                System.out.println("Sorry " + name + ", you are not eligible to vote (Age: " + age + ")");
                System.out.println();
                ineligibleVoters++;
            } else {
                eligibleVoters++;
                System.out.println("You are eligible to vote!");
                System.out.println("\nChoose your candidate:");
                System.out.println("1. BJP");
                System.out.println("2. Congress");
                System.out.println("3. BRS");
                System.out.println("4. Janasena");
                System.out.print("Enter your choice (1-4): ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    bjpVotes++;
                    System.out.println("Thank you " + name + "! You voted for BJP");
                } else if (choice == 2) {
                    congressVotes++;
                    System.out.println("Thank you " + name + "! You voted for Congress");
                } else if (choice == 3) {
                    brsVotes++;
                    System.out.println("Thank you " + name + "! You voted for BRS");
                } else if (choice == 4) {
                    janasenaVotes++;
                    System.out.println("Thank you " + name + "! You voted for Janasena");
                } else {
                    System.out.println("Invalid choice! Vote not counted.");
                }
                System.out.println();
            }
        }
        System.out.println("\n========== VOTING RESULTS ==========");
        System.out.println("Total voters registered: " + numberOfVoters);
        System.out.println("Eligible voters: " + eligibleVoters);
        System.out.println("Ineligible voters (below 18): " + ineligibleVoters);
        System.out.println("\n----- Votes per Candidate -----");
        System.out.println("BJP: " + bjpVotes + " votes");
        System.out.println("Congress: " + congressVotes + " votes");
        System.out.println("BRS: " + brsVotes + " votes");
        System.out.println("Janasena: " + janasenaVotes + " votes");
        System.out.println("\nTotal votes cast: " + (bjpVotes + congressVotes + brsVotes + janasenaVotes));

        System.out.println("\n----- WINNER -----");
        int maxVotes = bjpVotes;
        String winner = "BJP";
        if (congressVotes > maxVotes) {
            maxVotes = congressVotes;
            winner = "Congress";
        }
        if (brsVotes > maxVotes) {
            maxVotes = brsVotes;
            winner = "BRS";
        }
        if (janasenaVotes > maxVotes) {
            maxVotes = janasenaVotes;
            winner = "Janasena";
        }
        System.out.println("Winner: " + winner + " with " + maxVotes + " votes!");
        System.out.println(" ");  
        sc.close();
    }
}