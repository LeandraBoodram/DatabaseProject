import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class PopulateDatabase {
    public static void main(String[] args) {
        System.out.println("CREATE TABLE Student (Name varchar(255), Id integer PRIMARY KEY );\n" +
                "CREATE TABLE Departments (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "CREATE TABLE Teacher (FirstName varchar(255), LastName varchar(255), Id integer PRIMARY KEY, departmentId integer, FOREIGN KEY (departmentId) REFERENCES Departments(Id));\n" +
                "CREATE TABLE CourseName (CourseName varchar(255), CourseNameId integer PRIMARY KEY, CourseType varchar(255) );\n" +
                "CREATE TABLE Room (Id integer PRIMARY KEY, Name varchar(255) );\n" +
                "CREATE TABLE Courses (CourseNameId integer, CourseId integer PRIMARY KEY, RoomId integer, TeacherId integer, FOREIGN KEY (CourseNameId) REFERENCES CourseName(CourseNameId), FOREIGN KEY (RoomId) REFERENCES Room(Id), FOREIGN KEY (TeacherId) REFERENCES Teacher(Id) );\n" +
                "CREATE TABLE Assignments (Name varchar(255), CourseId integer, Grade integer, Type varchar(255), StudentId integer, FOREIGN KEY (CourseId) REFERENCES Courses(CourseId), FOREIGN KEY (StudentId) REFERENCES Student(Id));\n" +
                "CREATE TABLE Teacher_Schedules (TeacherId integer, Pd1 integer, Pd2 integer, Pd3 integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (TeacherId) REFERENCES Teacher(Id), FOREIGN KEY (Pd1) REFERENCES Courses(CourseId), FOREIGN KEY (Pd2) REFERENCES Courses(CourseId), FOREIGN KEY (Pd3) REFERENCES Courses(CourseId), FOREIGN KEY (Pd4) REFERENCES Courses(CourseId), FOREIGN KEY (Pd5) REFERENCES Courses(CourseId), FOREIGN KEY (Pd6) REFERENCES Courses(CourseId), FOREIGN KEY (Pd7) REFERENCES Courses(CourseId), FOREIGN KEY (Pd8) REFERENCES Courses(CourseId), FOREIGN KEY (Pd9) REFERENCES Courses(CourseId), FOREIGN KEY (Pd10) REFERENCES Courses(CourseId));\n" +
                "CREATE TABLE Student_Schedules (StudentId integer, Pd1 integer, Pd2 integer, Pd3 integer, Pd4 integer, Pd5 integer, Pd6 integer, Pd7 integer, Pd8 integer, Pd9 integer, Pd10 integer, FOREIGN KEY (StudentId) REFERENCES Student(Id), FOREIGN KEY (Pd1) REFERENCES Courses(CourseId), FOREIGN KEY (Pd2) REFERENCES Courses(CourseId), FOREIGN KEY (Pd3) REFERENCES Courses(CourseId), FOREIGN KEY (Pd4) REFERENCES Courses(CourseId), FOREIGN KEY (Pd5) REFERENCES Courses(CourseId), FOREIGN KEY (Pd6) REFERENCES Courses(CourseId), FOREIGN KEY (Pd7) REFERENCES Courses(CourseId), FOREIGN KEY (Pd8) REFERENCES Courses(CourseId), FOREIGN KEY (Pd9) REFERENCES Courses(CourseId), FOREIGN KEY (Pd10) REFERENCES Courses(CourseId));");

        ArrayList<String> teacherNames = getFileData("/home/raziz299/Projects/Database/teachernames.csv");
        ArrayList<String> courseNames = getFileData("/home/raziz299/Projects/Database/coursename.csv");
        for (int i = 0; i < courseNames.size(); i++) {
            String[] seperateCourseNames = courseNames.get(i).split(",");
            System.out.println("INSERT INTO CourseName ( CourseName, CourseNameId, CourseType ) VALUES ( \'" + seperateCourseNames[1] + "\', " + (i + 1) + ", \'" + seperateCourseNames[2] + "\' );");
        }
        String[] departments = {"Biology", "Chemistry", "CTE", "English", "Health & PE", "LOTE", "Mathematics", "Physics", "Social Studies", "Visual & Performing Arts"};
        for (int i = 1; i <= departments.length; i++) {
            System.out.println("INSERT INTO Departments ( Id, Name ) VALUES ( " + i + ", \'" + departments[i - 1] + "\');");
        }
        for (int i = 0; i < teacherNames.size(); i++) {
            String[] seperateNames = teacherNames.get(i).split(" ");
            System.out.println("INSERT INTO Teacher ( FirstName, LastName, Id, departmentId ) VALUES ( \'" + seperateNames[0] + "\', \'" + seperateNames[1].substring(0, seperateNames[1].length() - 1) + "\', " + (i + 1) + ", " + seperateNames[2] + " );");
        }
        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Student ( Name, Id ) VALUES ( 'Student" + i + "', " + i + ");");
        }
        String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] wings = {"N", "S", "E", "W"};
        int[] room_numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        ArrayList<String> combinations = new ArrayList<>();
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < wings.length; j++) {
                for (int k = 0; k < room_numbers.length; k++) {
                    if (room_numbers[k] < 10) {
                        combinations.add(wings[j] + floors[i] + "0" + room_numbers[k]);
                    } else {
                        combinations.add(wings[j] + floors[i] + room_numbers[k]);
                    }
                }
            }
        }
        for (int i = 0; i < combinations.size(); i++) {
            System.out.println("INSERT INTO Room ( Id, Name ) VALUES ( " + (i + 1) + ", \'" + combinations.get(i) + "\' );");
        }
        ArrayList<Integer> teacheridsP1 = new ArrayList<>();
        ArrayList<Integer> teacheridsP2 = new ArrayList<>();
        ArrayList<Integer> teacheridsP3 = new ArrayList<>();
        ArrayList<Integer> teacheridsP4 = new ArrayList<>();
        ArrayList<Integer> teacheridsP5 = new ArrayList<>();
        ArrayList<Integer> teacheridsP6 = new ArrayList<>();
        ArrayList<Integer> teacheridsP7 = new ArrayList<>();
        ArrayList<Integer> teacheridsP8 = new ArrayList<>();
        ArrayList<Integer> teacheridsP9 = new ArrayList<>();
        ArrayList<Integer> teacheridsP10 = new ArrayList<>();
        ArrayList<Integer> roomsP1 = new ArrayList<>();
        ArrayList<Integer> roomsP2 = new ArrayList<>();
        ArrayList<Integer> roomsP3 = new ArrayList<>();
        ArrayList<Integer> roomsP4 = new ArrayList<>();
        ArrayList<Integer> roomsP5 = new ArrayList<>();
        ArrayList<Integer> roomsP6 = new ArrayList<>();
        ArrayList<Integer> roomsP7 = new ArrayList<>();
        ArrayList<Integer> roomsP8 = new ArrayList<>();
        ArrayList<Integer> roomsP9 = new ArrayList<>();
        ArrayList<Integer> roomsP10 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < courseNames.size(); i++) {
            String[] seperateCourseNames = courseNames.get(i).split(",");
            for (int j = 0; j < 30; j++) {
                if (teacheridsP1.size() != 312  && roomsP1.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP1.contains(randomTeacher) || roomsP1.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP1.add(randomTeacher);
                    roomsP1.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP2.size() != 312  && roomsP2.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP2.contains(randomTeacher) || roomsP2.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP2.add(randomTeacher);
                    roomsP2.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP3.size() != 312  && roomsP3.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP3.contains(randomTeacher) || roomsP3.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP3.add(randomTeacher);
                    roomsP3.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP4.size() != 312  && roomsP4.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP4.contains(randomTeacher) || roomsP4.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP4.add(randomTeacher);
                    roomsP4.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP5.size() != 312 && roomsP5.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP5.contains(randomTeacher) || roomsP5.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP5.add(randomTeacher);
                    roomsP5.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP6.size() != 312 && roomsP6.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP6.contains(randomTeacher) || roomsP6.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP6.add(randomTeacher);
                    roomsP6.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP7.size() != 312 && roomsP7.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP7.contains(randomTeacher) || roomsP7.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP7.add(randomTeacher);
                    roomsP7.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP8.size() != 312 && roomsP8.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP8.contains(randomTeacher) || roomsP8.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP8.add(randomTeacher);
                    roomsP8.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP9.size() != 312 && roomsP9.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP9.contains(randomTeacher) || roomsP9.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP9.add(randomTeacher);
                    roomsP9.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                } else if (teacheridsP10.size() != 312 && roomsP10.size() != 756) {
                    count++;
                    int randomTeacher = (int) (Math.random() * 312 + 1);
                    int randomRoom = (int) (Math.random() * 756 + 1);
                    while (teacheridsP10.contains(randomTeacher) || roomsP10.contains(randomRoom)) {
                        randomTeacher = (int) (Math.random() * 312 + 1);
                        randomRoom = (int) (Math.random() * 756 + 1);
                    }
                    teacheridsP10.add(randomTeacher);
                    roomsP10.add(randomRoom);
                    System.out.println("INSERT INTO Courses ( CourseNameId, CourseId, RoomId, TeacherId ) VALUES ( " + seperateCourseNames[3] + ", " + count + ", " + randomRoom + ", " + randomTeacher + " );");
                }
            }
        }
        int teacherP1 = 0;
        int teacherP2 = 0;
        int teacherP3 = 0;
        int teacherP4 = 0;
        int teacherP5 = 0;
        int teacherP6 = 0;
        int teacherP7 = 0;
        int teacherP8 = 0;
        int teacherP9 = 0;
        int teacherP10 = 0;
        for (int j = 1; j <= 312; j++) {
            for (int i = 0; i < teacheridsP1.size(); i++) {
                if (teacheridsP1.get(i) == j) {
                    teacherP1 = i + 1;
                }
                if (teacheridsP2.get(i) == j) {
                    teacherP2 = i + 313;
                }
                if (teacheridsP3.get(i) == j) {
                    teacherP3 = i + 312 * 2 + 1;
                }
                if (teacheridsP4.get(i) == j) {
                    teacherP4 = i + 312 * 3 + 1;
                }
                if (teacheridsP5.get(i) == j) {
                    teacherP5 = i + 312 * 4 + 1;
                }
                if (teacheridsP6.get(i) == j) {
                    teacherP6 = i + 312 * 5 + 1;
                }
                if (teacheridsP7.get(i) == j) {
                    teacherP7 = i + 312 * 6 + 1;
                }
                if (teacheridsP8.get(i) == j) {
                    teacherP8 = i + 312 * 7 + 1;
                }
                if (teacheridsP9.get(i) == j) {
                    teacherP9 = i + 312 * 8 + 1;
                }
                if (teacheridsP10.get(i) == j) {
                    teacherP10 = i + 312 * 9 + 1;
                }
            }
            System.out.println("INSERT INTO Teacher_Schedules ( TeacherId, Pd1, Pd2, Pd3, Pd4, Pd5, Pd6, Pd7, Pd8, Pd9, Pd10 ) VALUES ( " + j + ", " + teacherP1 + ", " + teacherP2 + ", " + teacherP3 + ", " + teacherP4 + ", " + teacherP5 + ", " + teacherP6 + ", " + teacherP7 + ", " + teacherP8 + ", " + teacherP9 + ", " + teacherP10 + " );");
        }
        int studentCourse1 = 0;
        int studentCourse2 = 0;
        int studentCourse3 = 0;
        int studentCourse4 = 0;
        int studentCourse5 = 0;
        int studentCourse6 = 0;
        int studentCourse7 = 0;
        int studentCourse8 = 0;
        int studentCourse9 = 0;
        int studentCourse10 = 0;
        int randomGrade = 0;
        for (int i = 1; i <= 5000; i++){
            studentCourse1 = ((int) (Math.random() * 312) + 1);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse1 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse1 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse2 = ((int) (Math.random() * 312) + 313);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse2 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse2 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse3 = ((int) (Math.random() * 312) + 625);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse3 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse3 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse4 = ((int) (Math.random() * 312) + 937);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse4 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse4 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse5 = ((int) (Math.random() * 312) + 1249);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse5 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse5 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse6 = ((int) (Math.random() * 312) + 1561);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse6 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse6 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse7 = ((int) (Math.random() * 312) + 1873);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse7 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse7 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse8 = ((int) (Math.random() * 312) + 2185);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse8 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse8 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse9 = ((int) (Math.random() * 312) + 2497);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse9 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse9 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            studentCourse10 = ((int) (Math.random() * 312) + 2809);
            for (int j = 1; j <= 12; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Minor" + j + "\', " + studentCourse10 +", " + randomGrade +", \'Minor\', " + i + ");");
            }
            for (int j = 1; j <= 3; j++) {
                randomGrade = (int) (Math.random() * 25) + 75;
                System.out.println("INSERT INTO Assignments ( Name, CourseId, Grade, Type, StudentId ) VALUES ( \'Major" + j + "\', " + studentCourse10 +", " + randomGrade +", \'Major\', " + i + ");");
            }
            System.out.println("INSERT INTO Student_Schedules ( StudentId, Pd1, Pd2, Pd3, Pd4, Pd5, Pd6, Pd7, Pd8, Pd9, Pd10 ) VALUES ( " + i + ", " + studentCourse1 + ", " + studentCourse2 + ", " + studentCourse3 + ", " + studentCourse4 + ", " + studentCourse5 + ", " + studentCourse6 + ", " + studentCourse7 + ", " + studentCourse8 + ", " + studentCourse9 + ", " + studentCourse10 + " );");
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
// /home/raziz299/Projects/Database/teachernames.csv
// /home/raziz299/Porjects/Database/coursename.csv
