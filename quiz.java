import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class quiz {
    
    public static void main(String[] args) {
        String[] questions = {
            "What is the capital of India?\nA) Mumbai\nB) Delhi\nC) Kolkata\nD) Chennai",
            "Which data structure follows FIFO?\nA) Stack\nB) Queue\nC) Tree\nD) Graph",
            "What is the size of int in Java?\nA) 2 bytes\nB) 4 bytes\nC) 8 bytes\nD) 16 bytes",
            "Which keyword is used to inherit a class?\nA) implements\nB) inherits\nC) extends\nD) super",
            "Which company developed Java?\nA) Microsoft\nB) Sun Microsystems\nC) Oracle\nD) IBM",
            "Who is the founder of Java?\nA) James Gosling\nB) Dennis Ritchie\nC) Bjarne Stroustrup\nD) Guido van Rossum",
            "Which of these is NOT a primitive data type?\nA) int\nB) boolean\nC) String\nD) char",
            "What is the default value of boolean in Java?\nA) true\nB) false\nC) 0\nD) null",
            "Which data type is used to store a single character?\nA) string\nB) char\nC) character\nD) byte",
            "What is the range of byte data type?\nA) -128 to 127\nB) 0 to 255\nC) -256 to 255\nD) -64 to 63"
        };
        
        ArrayList<String> answers = new ArrayList<>();
        answers.add("B");
        answers.add("B");
        answers.add("B");
        answers.add("C");
        answers.add("B");
        answers.add("A");
        answers.add("C");
        answers.add("B");
        answers.add("B");
        answers.add("A");
        
        LinkedList<Integer> order = new LinkedList<>();
        for (int i = 0; i < questions.length; i++) {
            order.add(i);
        }
        
        Collections.shuffle(order);
        
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        for (int i = 0; i < order.size(); i++) {
            int index = order.get(i);
            System.out.println("Question " + (i + 1) + ": " + questions[index]);
            try {
                String userAnswer = scanner.nextLine();
                if (userAnswer.trim().equalsIgnoreCase(answers.get(index))) {
                    score++;
                }
            } catch (Exception e) {
                System.out.println("Invalid input detected");
                scanner.nextLine();
            }
        }
        
        System.out.println("Final Score: " + score + " out of " + questions.length);
        scanner.close();
    }
}