package People;
import java.util.ArrayList;
import java.util.List;

class Student extends Person {
    private int credits;
    private int studentId;
    private List<Double> grades;

    Student(String name, String address, int studentId) {
        super(name, address);
        this.credits = 0;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public int credits() {
        return credits;
    }

    public void study(){
        this.credits++;
    }

    public void addGrade(double grade) {
        if (grade < 5 || grade > 10) {
            System.out.println("Grade must be between 5 and 10.");
        } else {
            grades.add(grade);
            System.out.println("Grade added: " + grade);
        }
    }

    public String toString(){
        return super.toString() + "\nCredits: " + this.credits + "\nStudent ID: " + this.studentId;
    }

    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki", 1234);
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());

        olli.addGrade(9.0);
        olli.addGrade(11.0);
        System.out.println("Grades: " + olli.getGrades());
    }
}
