package LabWeek11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class StudentSystem{
    private List<Student> students;

    public StudentSystem(String filename) throws IOException, InvalidStudentDataException{
        this.students = readStudents(filename);
        validateStudentData(students);

    }

    public StudentSystem(List<Student> students) throws InvalidStudentDataException{
        this.students = students;
        validateStudentData(students);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> readStudents(String filename){
        List<Student> studentList = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(filename)
            );
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split(",");
                if(words.length == 5){
                    int id = Integer.parseInt(words[0].trim());
                    String name = words[1].trim();
                    String university = words[2].trim();
                    String department = words[3].trim();
                    double gpa = Double.parseDouble(words[4].trim());

                    studentList.add(new Student(id, name, university, department, gpa));
                }
                bufferedReader.close();
            }
        } catch(IOException e){
            System.out.println("Unable to read file.");
        }
        return studentList;
    }

    public int noOfStudents(){
        return students.size();
    }

    public Optional<Student> getStudentById(int id){
        for(Student student : students){
            if(student.getID() == id){
                return Optional.of(student);
            }
        }
        return Optional.ofNullable(null);
    }

    public Student getHighestGPAStudent() throws EmptyStudentListException {
            if (students.isEmpty()) {
                throw new EmptyStudentListException("List of students is empty.");
            }

            Student StudentWithHighestGPA = students.get(0);

            for (Student student : students) {
                if (student.getGPA() > StudentWithHighestGPA.getGPA()) {
                    StudentWithHighestGPA = student;
                }
            }
            return StudentWithHighestGPA;
    }

    public Student getLongestNameStudent() throws EmptyStudentListException{
        if(students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }

            Student studentWithLongestName = students.get(0);

            for (Student student : students) {
                if (student.getName().length() > studentWithLongestName.getName().length()) {
                    studentWithLongestName = student;
                }
            }
            return studentWithLongestName;
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataException{
        for(Student student : students){
            if(student.getGPA() < 6 || student.getGPA() > 10){
                throw new InvalidStudentDataException("Read data has invalid rows.");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        try {
            StudentSystem studentSystem = new StudentSystem("C:\\Users\\Imad\\Desktop\\students.csv");

            System.out.println("Number of students: " + studentSystem.noOfStudents());

            int studentId = 12;
            Optional<Student> student = studentSystem.getStudentById(studentId);
            student.ifPresentOrElse(
                    s -> System.out.println("Student with ID " + studentId + ": " + s.getName()),
                    () -> System.out.println("Student with ID " + studentId + " was not found.")
            );

            try {
                Student highestGPAStudent = studentSystem.getHighestGPAStudent();
                System.out.println("Student with highest GPA: " + highestGPAStudent.getName() + " with GPA: " + highestGPAStudent.getGPA());
            } catch (EmptyStudentListException e) {
                System.out.println(e.getMessage());
            }

            try {
                Student longestNameStudent = studentSystem.getLongestNameStudent();
                System.out.println("Student with longest name is: " + longestNameStudent.getName());
            } catch (EmptyStudentListException e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException | InvalidStudentDataException e) {
            System.out.println("Mistake: " + e.getMessage());
        }
    }
}
