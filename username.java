import java.util.Scanner;
public class username {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        StringBuilder username = new StringBuilder(name);
        for (int i = 0; i < username.length(); i++) {
            username.setCharAt(i, Character.toLowerCase(username.charAt(i)));
        }
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == ' ' || username.charAt(i) == '_') {
                username.setCharAt(i, '.');
            }
        }
        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                username.deleteCharAt(i);
                i--; 
            }
        }
        System.out.println("Original name: " + name);
        System.out.println("Username: " + username);  
        sc.close();
    }
}