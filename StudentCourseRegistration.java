import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        // Sample courses
        courses.add(new Course("Math", 2));
        courses.add(new Course("Science", 3));
        courses.add(new Course("History", 2));

        int choice;

        do {
            System.out.println("\n===== Course Registration System =====");
            System.out.println("1. Register for a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View course details");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();

                    Course courseToRegister = findCourse(courses, courseName);
                    if (courseToRegister != null) {
                        courseToRegister.registerStudent(name);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String dropName = scanner.nextLine();

                    System.out.print("Enter course name: ");
                    String dropCourse = scanner.nextLine();

                    Course courseToDrop = findCourse(courses, dropCourse);
                    if (courseToDrop != null) {
                        courseToDrop.dropStudent(dropName);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 3:
                    for (Course c : courses) {
                        c.displayCourseDetails();
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        scanner.close();
    }

    // Helper method to find a course
    public static Course findCourse(ArrayList<Course> courses, String name) {
        for (Course c : courses) {
            if (c.getCourseName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}
