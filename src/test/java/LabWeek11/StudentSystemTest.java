package LabWeek11;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class StudentSystemTest {
    @Test
    public void testIfStudentIsPresent() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("students.csv");
        assertTrue(system.noOfStudents() > 0, "The student list should not be empty.");
    }

    @Test
    public void testStudentWithId100() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("students.csv");
        Optional<Student> student = system.getStudentById(100);
        assertFalse(student.isPresent(), "Student with ID 100 should not exist.");
    }

    @Test
    public void testHighestGPAStudent() throws InvalidStudentDataException, IOException, EmptyStudentListException {
        StudentSystem system = new StudentSystem("students.csv");
        Student highestGPAStudent = system.getHighestGPAStudent();
        assertEquals(9.8, highestGPAStudent.getGPA(), "The student with the highest GPA should have a GPA of 9.8.");
    }

    @Test
    public void testExceptionForEmptyStudentList() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("empty.csv");
        Exception exception = assertThrows(EmptyStudentListException.class, () -> {
            system.getHighestGPAStudent();
        });
        assertEquals("List of students is empty.", exception.getMessage());
    }

    @Test
    public void testExceptionMessageForEmptyStudentList() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("empty.csv");
        Exception exception = assertThrows(EmptyStudentListException.class, () -> {
            system.getHighestGPAStudent();
        });
        assertEquals("List of students is empty.", exception.getMessage());
    }

    @Test
    public void testNamesArray() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("students.csv");
        List<String> studentNames = system.getStudents().stream()
                .map(Student::getName)
                .limit(5)
                .toList();
        assertEquals(List.of("Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson"), studentNames);
    }

    @Test
    public void testSameStudent() throws InvalidStudentDataException, IOException, EmptyStudentListException {
        StudentSystem system = new StudentSystem("students.csv");
        Student highestGPAStudent = system.getHighestGPAStudent();
        Optional<Student> studentWithId12 = system.getStudentById(12);
        assertTrue(studentWithId12.isPresent(), "Student with ID 12 should exist.");
        assertEquals(highestGPAStudent, studentWithId12.get(), "The student with the highest GPA should be the same as the student with ID 12.");
    }


    @Test
    public void testExceptionForEmptyStudentListInOtherMethods() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("empty.csv");
        assertThrows(EmptyStudentListException.class, () -> {
            system.getLongestNameStudent();
        });
    }

    @Test
    public void testGetStudentById() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("students.csv");
        Optional<Student> student = system.getStudentById(1);
        assertTrue(student.isPresent(), "Student with ID 1 should be found.");
        assertEquals(1, student.get().getID(), "Student ID should be 1.");
    }

    @Test
    public void testStudentDataValidation() {
        List<Student> invalidStudents = List.of(
                new Student(1, "John Doe", "University", "Department", 5.0),
                new Student(2, "Jane Doe", "University", "Department", 11.0)
        );

        assertThrows(InvalidStudentDataException.class, () -> {
            new StudentSystem(invalidStudents);
        });
    }

    @Test
    public void testNoStudentsInConstructor() {
        assertThrows(EmptyStudentListException.class, () -> {
            new StudentSystem("empty.csv");
        });
    }

    @Test
    public void testStudentListInitializationFromFile() throws InvalidStudentDataException, IOException {
        StudentSystem system = new StudentSystem("students.csv");
        assertNotNull(system.getStudents(), "The student list should be initialized.");
        assertTrue(system.noOfStudents() > 0, "There should be at least one student in the list.");
    }
}