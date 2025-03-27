//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PopulateDatabase {
    public static void main(String[] args) {

        System.out.println("CREATE TABLE Student (Name varchar(255), Id integer PRIMARY KEY );\n" +
                "CREATE TABLE Teacher (FirstName varchar(255), LastName varchar(255), Id integer PRIMARY KEY );\n" +
                "CREATE TABLE CourseName (CourseName varchar(255), CourseNameId integer PRIMARY KEY );\n" +
                "CREATE TABLE Departments (Id integer PRIMARY KEY, Name varchar(255), NumOfTeachers integer );\n" +
                "CREATE TABLE CourseType (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "CREATE TABLE Room (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "CREATE TABLE Courses (CourseNameId integer, CourseId integer PRIMARY KEY, DepartmentId integer, TypeId integer, RoomId integer, TeacherId integer, StudentId integer, FOREIGN KEY (CourseNameId) REFERENCES CourseName(CourseNameId), FOREIGN KEY (DepartmentId) REFERENCES Departments(Id), FOREIGN KEY (TypeId) REFERENCES CourseType(Id), FOREIGN KEY (RoomId) REFERENCES Room(Id), FOREIGN KEY (TeacherId) REFERENCES Teacher(Id), FOREIGN KEY (StudentId) REFERENCES Student(Id));\n" +
                "CREATE TABLE Assignments (Name varchar(255), CourseId integer, Grade integer, Type varchar(255), StudentId integer, FOREIGN KEY (CourseId) REFERENCES CourseName(CourseNameId), FOREIGN KEY (StudentId) REFERENCES Students(Id));\n" +
                "CREATE TABLE Teacher_Schedules (TeacherId integer, Pd1 integer, Pd2 integer, Pd3  integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (TeacherId) REFERENCES Teacher(Id), FOREIGN KEY (Pd1) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd2) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd3) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd4) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd5) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd6) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd7) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd8) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd9) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd10) REFERENCES CourseName(CourseId));\n" +
                "CREATE TABLE Student_Schedules (StudentId integer, Pd1 integer, Pd2 integer, Pd3 integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (StudentId) REFERENCES Student(Id), FOREIGN KEY (Pd1) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd2) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd3) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd4) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd5) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd6) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd7) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd8) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd9) REFERENCES CourseName(CourseId), FOREIGN KEY (Pd10) REFERENCES CourseName(CourseId));\n");
        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Student ( Name, Id ) VALUES ( 'Student" + i + "', " + i + ")");
        }
    }
}
