import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter num2: ");
        int num2 = sc.nextInt();
        System.out.print("Enter operation (add/sub/mul/div): ");
        String operation = sc.next();
        if (operation.equals("add")) {
            System.out.println("Result: " + add(num1, num2));
        } else if (operation.equals("sub")) {
            System.out.println("Result: " + subtract(num1, num2));
        } else if (operation.equals("mul")) {
            System.out.println("Result: " + multiply(num1, num2));
        } else if (operation.equals("div")) {
            System.out.println("Result: " + divide(num1, num2));
        } else {
            System.out.println("Invalid operation!");
        }
        
        sc.close();
    }
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static float divide(int a, int b) {
        return (float) a / b;
    }
}