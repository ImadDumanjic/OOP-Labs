package LabWeek11;

class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message){
        super(message);
    }
}

class EmptyStudentListException extends Exception{
    public EmptyStudentListException(String message){
        super(message);
    }
}

class InvalidStudentDataException extends Exception{
    public InvalidStudentDataException(String message){
        super(message);
    }
}
