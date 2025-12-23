class Student {  
    String name; 
    String location; 
    String hobbies;
    
    public void display() {
        System.out.println("Name: " + name + ", Location: " + location + ", Hobbies: " + hobbies);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();  
        s1.name = "Chinni";  
        s1.location = "warangal";
        s1.hobbies = "cooking,sleeping";
        s1.display();  

        Student s2 = new Student();  
        s2.name = "Keerthi";  
        s2.location = "Hyderabad";
        s2.hobbies = "Eating,playing";
        s2.display();  

        Student s3 = new Student();  
        s3.name = "Sathvika";  
        s3.location = "Hnk";
        s3.hobbies = "dancing, music lover";
        s3.display();

        Student s4 = new Student();  
        s4.name = "Aqsa";  
        s4.location = "College hoatel";
        s4.hobbies = "Reading,Chatting";
        s4.display();

        Student s5 = new Student();  
        s5.name = "Rehmat";  
        s5.location = "Haryana";
        s5.hobbies = "playing";
        s5.display();
    }
}