package LabWeek10;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student{
    private String name;
    private String ID;
    private List<Integer> grades;

    public Student(String name, String ID, List<Integer> grades){
        this.name = name;
        this.ID = ID;
        this.grades = grades;
    }

    public String printInfo(){
        return "Students name: " + this.name + "\nStudents ID: " + this.ID + "\nGrades: " + this.grades;
    }
}

class GradeAnalyzer{
    private List<Integer> grades;

    public GradeAnalyzer(List<Integer> grades){
        this.grades = grades;
    }

    public double calculateAverage(){
        if(grades.isEmpty()){
            return 0;
        }

        int sum = 0;
        for(int grade : grades){
            sum += grade;
        }

        return (double)sum / grades.size();
    }

    public String printSummary(){
        return "Grade Summary" + "\nGrades: " + this.grades + "\n Average: " + calculateAverage();
    }
}

class Start{
    public static void main(String[] args){
        List<Integer> grades = Arrays.asList(6,6,7,8,10);
        Student student = new Student("Imad Dumanjić", "ID2004", grades);
        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(grades);

        try {
            System.out.println("Student Info:");
            Method printStudentInfo = Student.class.getDeclaredMethod("printInfo");
            String studentInfo = (String) printStudentInfo.invoke(student);
            System.out.println(studentInfo);

            System.out.println("\nAnalyze Grades:");
            Method calculateAverageMethod = GradeAnalyzer.class.getDeclaredMethod("calculateAverage");
            double average = (double) calculateAverageMethod.invoke(gradeAnalyzer);
            System.out.println("Calculated Average: " + average);

            Method printSummaryMethod = GradeAnalyzer.class.getDeclaredMethod("printSummary");
            printSummaryMethod.invoke(gradeAnalyzer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
