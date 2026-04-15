import java.util.ArrayList;

public class Course {
    private String courseName;
    private int maxSeats;
    private ArrayList<String> registeredStudents;

    // Constructor
    public Course(String courseName, int maxSeats) {
        this.courseName = courseName;
        this.maxSeats = maxSeats;
        this.registeredStudents = new ArrayList<>();
    }

    // Register student
    public void registerStudent(String studentName) {
        if (registeredStudents.size() < maxSeats) {
            if (!registeredStudents.contains(studentName)) {
                registeredStudents.add(studentName);
                System.out.println(studentName + " successfully registered for " + courseName);
            } else {
                System.out.println("Student already registered.");
            }
        } else {
            System.out.println("Course is full.");
        }
    }

    // Drop student
    public void dropStudent(String studentName) {
        if (registeredStudents.contains(studentName)) {
            registeredStudents.remove(studentName);
            System.out.println(studentName + " dropped from " + courseName);
        } else {
            System.out.println("Student not found in this course.");
        }
    }

    // Display details
    public void displayCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Seats: " + registeredStudents.size() + "/" + maxSeats);
        System.out.println("Registered Students: " + registeredStudents);
    }

    // Getter
    public String getCourseName() {
        return courseName;
    }
}
