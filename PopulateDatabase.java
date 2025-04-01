import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int k = 0;
        boolean department = false
        for (int i = 0; i < teacherNames.size(); i++) {
            String[] seperateNames = teacherNames.get(i).split(" ");
            //case switch with department name...
            if (department) System.out.println("INSERT  INTO Teacher ( FirstName, LastName, Id, departmentId ) VALUES ( " + seperateNames[0] + ", " + seperateNames[1] + ", " + (i + 1) + " );");
        }
        ArrayList<String> teacherNames = getFileData("src/teacherName.csv");
        for (int i = 0; i < teacherNames.size(); i++) {
            String[] seperateNames = teacherNames.get(i).split(" ");
            System.out.println("INSERT  INTO Teacher ( FirstName, LastName, Id, departmentId ) VALUES ( " + seperateNames[0] + ", " + seperateNames[1] + ", " + (i + 1) + " );");
        }
        System.out.println("CREATE TABLE Student (Name varchar(255), Id integer PRIMARY KEY );\n" +
                "CREATE TABLE Teacher (FirstName varchar(255), LastName varchar(255), Id integer PRIMARY KEY, departmentId integer, FOREIGN KEY (departmentId) REFERENCES Departments(Id));\n" +
                "CREATE TABLE CourseName (CourseName varchar(255), CourseNameId integer PRIMARY KEY );\n" +
                "CREATE TABLE Departments (Id integer PRIMARY KEY, Name varchar(255), NumOfTeachers integer );\n" +
                "CREATE TABLE CourseType (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "CREATE TABLE Room (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "CREATE TABLE Courses (CourseNameId integer, CourseId integer PRIMARY KEY, TypeId integer, RoomId integer, TeacherId integer, StudentId integer, FOREIGN KEY (CourseNameId) REFERENCES CourseName(CourseNameId), FOREIGN KEY (TypeId) REFERENCES CourseType(Id), FOREIGN KEY (RoomId) REFERENCES Room(Id), FOREIGN KEY (TeacherId) REFERENCES Teacher(Id), FOREIGN KEY (StudentId) REFERENCES Student(Id));\n" +
                "CREATE TABLE Assignments (Name varchar(255), CourseId integer, Grade integer, Type varchar(255), StudentId integer, FOREIGN KEY (CourseId) REFERENCES CourseName(CourseNameId), FOREIGN KEY (StudentId) REFERENCES Student(Id));\n" +
                "CREATE TABLE Teacher_Schedules (TeacherId integer, Pd1 integer, Pd2 integer, Pd3 integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (TeacherId) REFERENCES Teacher(Id), FOREIGN KEY (Pd1) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd2) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd3) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd4) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd5) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd6) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd7) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd8) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd9) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd10) REFERENCES CourseName(CourseNameId));\n" +
                "CREATE TABLE Student_Schedules (StudentId integer, Pd1 integer, Pd2 integer, Pd3 integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (StudentId) REFERENCES Student(Id), FOREIGN KEY (Pd1) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd2) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd3) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd4) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd5) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd6) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd7) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd8) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd9) REFERENCES CourseName(CourseNameId), FOREIGN KEY (Pd10) REFERENCES CourseName(CourseNameId));\n");
        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT  INTO Student ( Name, Id ) VALUES ( 'Student" + i + "', " + i + ");");
        }
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
