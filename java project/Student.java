import java.time.LocalDate;
import java.util.Scanner;
public class Student {
    private String name;
    private String surname;
    private int studentID;
    private int yearOfAdmission;
    private int numbOfCourses;
    private String course;
    private String currentSemester;
    String answer;
    Scanner input = new Scanner(System.in);
    public Student(String name, String surname, int studentID, int yearOfAdmission) {
       this.name = name;
       this.surname = surname;
       this.studentID = studentID;
       this.yearOfAdmission = yearOfAdmission; 
    }
    public void getEnrolled() {
        do {
            System.out.println("Enter the semester you are currently traversing (Winter, Spring):");
            currentSemester = input.nextLine();
            if (!currentSemester.equals("Winter") && !currentSemester.equals("Spring")) {
                System.out.println("Invalid semester.Please enter 'Winter' or 'Spring'.");
            }
        } while (!currentSemester.equals("Winter") && !currentSemester.equals("Spring"));
        do {
            System.out.println("Enter the course you want to get enrolled in:");
            course = input.nextLine();
            numbOfCourses = numbOfCourses + 1;
            System.out.println("You have enrolled in:" + " " + course); 
            System.out.println("Do you want to enroll in another course?(Yes,No)");
            answer = input.nextLine();
        } while(numbOfCourses < 15 && answer.equals("Yes") );
        System.out.println("You have enrolled in:" + " " + numbOfCourses + " " + "courses.");
    }
    @Override public String toString() {
        return name + " " + surname + " " + "has student ID: " + studentID + "and got registered in: " + yearOfAdmission;
    }
}
