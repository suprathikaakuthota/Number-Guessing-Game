import java.util.ArrayList;
import java.util.Scanner;
public class restaurent {
    static class MenuItem {
        String name;
        double price;
         MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Bajra Khichdi", 120.0));
        menu.add(new MenuItem("Kadhi Pakora", 100.0));
        menu.add(new MenuItem("Besan Masala Roti", 80.0));
        menu.add(new MenuItem("Singri Ki Sabzi", 150.0));
        menu.add(new MenuItem("Methi Gajar", 110.0));
        menu.add(new MenuItem("Kachri Ki Sabzi", 130.0));
        menu.add(new MenuItem("Bathua Raita", 70.0));
        menu.add(new MenuItem("Churma", 90.0));
        menu.add(new MenuItem("Lassi", 60.0));
        menu.add(new MenuItem("Alsi Ki Pinni", 50.0));
         ArrayList<MenuItem> currentOrder = new ArrayList<>();
        System.out.println("   WELCOME TO HARYANA DHABA   ");
         while (true) {
            System.out.println("\n1. Display Menu");
            System.out.println("2. Order");
            System.out.println("3. Payment");
            System.out.println("4. Quit");
            System.out.print("\nEnter your choice: ");
         int choice = sc.nextInt();
            if (choice == 1) {
                displayMenu(menu);
            } 
            else if (choice == 2) {
                displayMenu(menu);
                System.out.print("\nEnter item number to order: ");
                int itemNum = sc.nextInt();
                  if (itemNum >= 1 && itemNum <= menu.size()) {
                    currentOrder.add(menu.get(itemNum - 1));
                    System.out.println("✓ " + menu.get(itemNum - 1).name + " added to order!");
                } else {
                    System.out.println("Invalid item number!");
                }
            } 
            else if (choice == 3) {
                generateBill(currentOrder);
                break;
            } 
            else if (choice == 4) {
                System.out.println("Dhanyavaad! Dobara aana! Ram Ram ji!");
                System.out.println("Visit again! 🙏");
                break;
            } 
            else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
    static void displayMenu(ArrayList<MenuItem> menu) {
        System.out.println("              MENU");
        System.out.printf("%-5s %-25s %s\n", "No.", "FOOD NAME", "PRICE (₹)");
          for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%-5d %-25s ₹%.2f\n", 
                (i + 1), menu.get(i).name, menu.get(i).price);
        }
    }
    static void generateBill(ArrayList<MenuItem> order) {
        System.out.println(" FINAL BILL ");
        if (order.isEmpty()) {
            System.out.println("No items ordered!");
            System.out.println("\nThank you for visiting!");
            return;
        }
        System.out.printf("%-25s %s\n", "FOOD NAME", "PRICE (₹)");
         double total = 0;
        for (MenuItem item : order) {
            System.out.printf("%-25s ₹%.2f\n", item.name, item.price);
            total += item.price;
        }
        System.out.printf("%-25s ₹%.2f\n", "TOTAL BILL", total);
        System.out.println(" Dhanyavaad! Dobara aana! Ram Ram ji!");
    }
}