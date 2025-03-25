//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PopulateDatabase {
    public static void main(String[] args) {
        System.out.println("DROP TABLE Student;");
        System.out.println("DROP TABLE Teacher;");
        System.out.println("DROP TABLE Roster;");
        System.out.println("DROP TABLE Teacher_Schedule;");
        System.out.println("DROP TABLE Student_schedule;");
        System.out.println("DROP TABLE Assignments;");
        System.out.println("DROP TABLE Courses;");
        System.out.println("DROP TABLE CourseName;");
        System.out.println("DROP TABLE Departments;");
        System.out.println("DROP TABLE CourseType;");
        System.out.println("DROP TABLE Room;");
        System.out.println("CREATE TABLE Student (FirstName varchar(255), LastName varchar(255), Id integer PRIMARY KEY );\n" +
                "\n" +
                "CREATE TABLE Teacher (FirstName varchar(255), LastName varchar(255), Id integer PRIMARY KEY );\n" +
                "\n" +
                "CREATE TABLE CourseName (CourseName varchar(255), CourseNameId integer PRIMARY KEY );\n" +
                "\n" +
                "CREATE TABLE Departments (Id integer PRIMARY KEY, Name varchar(255), NumOfTeachers integer );\n" +
                "\n" +
                "CREATE TABLE CourseType (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "\n" +
                "CREATE TABLE Room (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "\n" +
                "CREATE TABLE Courses (CourseNameId integer, CourseId integer PRIMARY KEY, DepartmentId integer, TypeId integer, RoomId integer, TeacherId integer, StudentId integer, FOREIGN KEY (CourseNameId) REFERENCES CourseName(CourseNameId), FOREIGN KEY (DepartmentId) REFERENCES Departments(Id), FOREIGN KEY (TypeId) REFERENCES CourseType(Id), FOREIGN KEY (RoomId) REFERENCES Room(Id), FOREIGN KEY (TeacherId) REFERENCES Teacher(Id), FOREIGN KEY (StudentId) REFERENCES Student(Id));\n" +
                "\n" +
                "CREATE TABLE Assignments (Name varchar(255), CourseId integer, Grade integer, Type varchar(255), StudentId integer, FOREIGN KEY (CourseId) REFERENCES Courses(CourseNameId), FOREIGN KEY (StudentId) REFERENCES Students(Id));\n" +
                "\n" +
                "CREATE TABLE Teacher_Schedules (TeacherId integer, Pd1 integer, Pd2 integer, Pd3  integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (TeacherId) REFERENCES Teacher(Id), FOREIGN KEY (Pd1) REFERENCES Courses(CourseId), FOREIGN KEY (Pd2) REFERENCES Courses(CourseId), FOREIGN KEY (Pd3) REFERENCES Courses(CourseId), FOREIGN KEY (Pd4) REFERENCES Courses(CourseId), FOREIGN KEY (Pd5) REFERENCES Courses(CourseId), FOREIGN KEY (Pd6) REFERENCES Courses(CourseId), FOREIGN KEY (Pd7) REFERENCES Courses(CourseId), FOREIGN KEY (Pd8) REFERENCES Courses(CourseId), FOREIGN KEY (Pd9) REFERENCES Courses(CourseId), FOREIGN KEY (Pd10) REFERENCES Courses(CourseId));\n" +
                "\n" +
                "CREATE TABLE Student_Schedules (StudentId integer, Pd1 integer, Pd2 integer, Pd3 integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (StudentId) REFERENCES Student(Id), FOREIGN KEY (Pd1) REFERENCES Courses(CourseId), FOREIGN KEY (Pd2) REFERENCES Courses(CourseId), FOREIGN KEY (Pd3) REFERENCES Courses(CourseId), FOREIGN KEY (Pd4) REFERENCES Courses(CourseId), FOREIGN KEY (Pd5) REFERENCES Courses(CourseId), FOREIGN KEY (Pd6) REFERENCES Courses(CourseId), FOREIGN KEY (Pd7) REFERENCES Courses(CourseId), FOREIGN KEY (Pd8) REFERENCES Courses(CourseId), FOREIGN KEY (Pd9) REFERENCES Courses(CourseId), FOREIGN KEY (Pd10) REFERENCES Courses(CourseId));\n");
    }
}
