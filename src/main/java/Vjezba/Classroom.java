package Vjezba;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Classroom{
    private ArrayList<Student> students;

    Classroom(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudentById(int id){
        for(Student student : students){
            if(student.getId() == id){
                students.remove(student);
            }
        }
    }

    public ArrayList<Student> getStudentsByName(String name){
        ArrayList<Student> filteredStudents = new ArrayList<>();

        for(Student student : students){
            if(student.getName().equals(name)){
                filteredStudents.add(student);
            }
        }

        return filteredStudents;
    }

    public static void main(String[] args){
        Classroom classroom = new Classroom();

        classroom.addStudent(new Student(1, "Imad", 20, 5));
        classroom.addStudent(new Student(2, "Haris", 21, 4));
        classroom.addStudent(new Student(3, "Harun", 22, 3));
        classroom.addStudent(new Student(4, "Jusa", 23, 2));

        System.out.println("All students are: ");
        for(Student student : classroom.students){
            System.out.println(student);
        }

        classroom.removeStudentById(3);

        System.out.println("Updated students are: ");
        for(Student student : classroom.students){
            System.out.println(student);
        }
    }
}
