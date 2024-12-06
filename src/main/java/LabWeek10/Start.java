package LabWeek10;
import java.lang.reflect.Field;
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

    public void printSummary(){
        System.out.println("Grade Summary:");
        System.out.println("Grades: " + this.grades);
        System.out.println("Average: " + calculateAverage());
    }
}

class Start{
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        List<Integer> grades = Arrays.asList(6,6,7,8,10);
        Student student = new Student("Imad Dumanjić", "ID2004", grades);
        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(grades);

        System.out.println("Student field names:");
        Field[] studentFields = student.getClass().getDeclaredFields();
        for(Field studentField : studentFields){
            studentField.setAccessible(true);
            System.out.println("Field name: " + studentField.getName() + ", field Value: " + studentField.get(student));
        }

        System.out.println("-------------------------");

        System.out.println("GradeAnalyzer field names:");
        Field[] gradeFields = gradeAnalyzer.getClass().getDeclaredFields();
        for(Field gradeField : gradeFields){
            gradeField.setAccessible(true);
            System.out.println("Field name: " + gradeField.getName() + ", field Value: " + gradeField.get(gradeAnalyzer));
        }

        System.out.println("-------------------------");

        System.out.println("Student methods:");
        Method[] studentMethods = student.getClass().getDeclaredMethods();
        for(Method studentMethod : studentMethods){
            if(studentMethod.getName().equals("printInfo")){
                studentMethod.setAccessible(true);
                if(studentMethod.getReturnType() != void.class){
                    Object value = studentMethod.invoke(student);
                    System.out.println("Method name: " + studentMethod.getName() + ", method value:\n " + value);
                }
                else{
                    studentMethod.invoke(student);
                    System.out.println(studentMethod.getName() +  " method invoked.");
                }
            }
        }

        System.out.println("-------------------------");

        System.out.println("Grade Analyzer methods");
        Method[] gradeMethods = gradeAnalyzer.getClass().getDeclaredMethods();
        for(Method gradeMethod : gradeMethods){
            if(gradeMethod.getName().equals("calculateAverage") | gradeMethod.getName().equals("printSummary")){
                gradeMethod.setAccessible(true);
                if(gradeMethod.getReturnType() != void.class){
                    Object result = gradeMethod.invoke(gradeAnalyzer);
                    System.out.println("Method name: " + gradeMethod.getName() + ", method values: " + result);
                }

                else{
                    gradeMethod.invoke(gradeAnalyzer);
                    System.out.print(gradeMethod.getName() + " method invoked.");
                }
            }
        }
    }
}
