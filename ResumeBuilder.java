import java.util.*;
class Resume {
    private PersonalDetails personal;
    private String summary;
    private List<String> skills;
    private List<String> certifications;
    private List<Project> projects;
    private Education education;
    
    public Resume() {
        skills = new ArrayList<>();
        certifications = new ArrayList<>();
        projects = new ArrayList<>();
    }
    
    public void setPersonalDetails(PersonalDetails p) { this.personal = p; }
    public void setSummary(String s) { this.summary = s; }
    public void addSkill(String skill) { skills.add(skill); }
    public void addCertification(String cert) { certifications.add(cert); }
    public void addProject(Project proj) { projects.add(proj); }
    public void setEducation(Education edu) { this.education = edu; }
    
    public String generate() {
        StringBuilder resume = new StringBuilder();
        int width = 80;
        
        appendLine(resume, width, '=');
        appendCentered(resume, personal.name.toUpperCase(), width);
        appendLine(resume, width, '=');
        
        resume.append(String.format("Email: %s | Phone: %s\n", personal.email, personal.phone));
        resume.append(String.format("LinkedIn: %s | GitHub: %s\n", personal.linkedin, personal.github));
        appendLine(resume, width, '-');
        
        resume.append("\nPROFESSIONAL SUMMARY\n");
        appendLine(resume, width, '-');
        resume.append(wrapText(summary, width)).append("\n");

        resume.append("\nTECHNICAL SKILLS\n");
        appendLine(resume, width, '-');
        for (int i = 0; i < skills.size() && i < 4; i++) {
            resume.append("• ").append(skills.get(i)).append("\n");
        }
        
        if (education != null) {
            resume.append("\nEDUCATION\n");
            appendLine(resume, width, '-');
            resume.append(education.format());
        }
        
        if (!projects.isEmpty()) {
            resume.append("\nPROJECTS\n");
            appendLine(resume, width, '-');
            for (Project p : projects) {
                resume.append(p.format());
            }
        }
    
        if (!certifications.isEmpty()) {
            resume.append("\nCERTIFICATIONS\n");
            appendLine(resume, width, '-');
            for (String cert : certifications) {
                resume.append("✓ ").append(cert).append("\n");
            }
        }
        
        appendLine(resume, width, '=');
        return resume.toString();
    }
    
    private void appendLine(StringBuilder sb, int width, char ch) {
        for (int i = 0; i < width; i++) sb.append(ch);
        sb.append("\n");
    }
    
    private void appendCentered(StringBuilder sb, String text, int width) {
        int padding = (width - text.length()) / 2;
        for (int i = 0; i < padding; i++) sb.append(" ");
        sb.append(text).append("\n");
    }
    
    private String wrapText(String text, int width) {
        StringBuilder wrapped = new StringBuilder();
        String[] words = text.split(" ");
        int lineLen = 0;
        
        for (String word : words) {
            if (lineLen + word.length() + 1 > width) {
                wrapped.append("\n");
                lineLen = 0;
            }
            if (lineLen > 0) {
                wrapped.append(" ");
                lineLen++;
            }
            wrapped.append(word);
            lineLen += word.length();
        }
        return wrapped.toString();
    }
}

class PersonalDetails {
    String name, email, phone, linkedin, github;
    
    public PersonalDetails(String name, String email, String phone, String linkedin, String github) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.linkedin = linkedin;
        this.github = github;
    }
}

class Project {
    String name, description;
    
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("• ").append(name).append("\n");
        sb.append("  ").append(description).append("\n\n");
        return sb.toString();
    }
}

class Education {
    String institution, degree, year, grade;
    
    public Education(String institution, String degree, String year, String grade) {
        this.institution = institution;
        this.degree = degree;
        this.year = year;
        this.grade = grade;
    }
    
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append(institution).append("\n");
        sb.append(degree).append(" | ").append(year).append(" | ").append(grade).append("\n\n");
        return sb.toString();
    }
}

public class ResumeBuilder {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("      FRESHER RESUME BUILDER - JAVA");
        System.out.println("===============================================\n");
        
        Resume resume = new Resume();
        
        // Personal Details
        System.out.println("=== PERSONAL INFORMATION ===");
        System.out.print("Full Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("LinkedIn: ");
        String linkedin = sc.nextLine();
        System.out.print("GitHub: ");
        String github = sc.nextLine();
        
        resume.setPersonalDetails(new PersonalDetails(name, email, phone, linkedin, github));
    
        System.out.println("\n=== PROFESSIONAL SUMMARY ===");
        System.out.print("Enter summary (third-party phrases): ");
        String summary = sc.nextLine();
        resume.setSummary(summary);
        System.out.println("\n=== TECHNICAL SKILLS (Max 4) ===");
        System.out.print("How many skills? ");
        int skillCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < Math.min(skillCount, 4); i++) {
            System.out.print("Skill " + (i + 1) + ": ");
            resume.addSkill(sc.nextLine());
        }
        

        System.out.println("\n=== EDUCATION ===");
        System.out.print("Institution Name: ");
        String inst = sc.nextLine();
        System.out.print("Degree/Course: ");
        String degree = sc.nextLine();
        System.out.print("Year: ");
        String year = sc.nextLine();
        System.out.print("GPA/Percentage: ");
        String grade = sc.nextLine();
        resume.setEducation(new Education(inst, degree, year, grade));
        
        
        System.out.println("\n=== PROJECTS ===");
        System.out.print("Number of projects: ");
        int projCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < projCount; i++) {
            System.out.println("\n-- Project " + (i + 1) + " --");
            System.out.print("Project Name: ");
            String pName = sc.nextLine();
            System.out.print("Brief Description: ");
            String pDesc = sc.nextLine();
            resume.addProject(new Project(pName, pDesc));
        }
    
        System.out.println("\n=== CERTIFICATIONS ===");
        System.out.print("Number of certifications: ");
        int certCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < certCount; i++) {
            System.out.print("Certification " + (i + 1) + ": ");
            resume.addCertification(sc.nextLine());
        }
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("GENERATING YOUR RESUME...");
        System.out.println("=".repeat(50) + "\n");
        
        System.out.println(resume.generate());
        
        System.out.println("✓ Resume generated successfully!");
    }
}
