import objects.IndividualAssignment;
import objects.StudentInfo;

import java.util.ArrayList;
import java.util.HashSet;

public class GradesDB {

    private GradeImporter importer;

    public GradesDB(String fileName) {
        importer = new GradeImporter(fileName);
    }

    //Stub TODO: add logic
    public int getNumStudents() {
        HashSet<Student> students = new HashSet<>();
        ArrayList<StudentInfo> studentInfo = importer.importStudentInfo();
        for (StudentInfo student : studentInfo) {
            if (!student.getName().equals("NAME")) {
                Student s = new Student(student.getName(), String.valueOf(student.getId()), student.getEmail(), student.getcSkill(), student.getCppSkill(), student.getJavaSkill(), student.getCsJobEx(), importer);
                students.add(s);
            }
        }

        return students.size();
    }

    public int getNumAssignments() {
        //Freddie Catlay
        IndividualAssignment assignment = importer.importIndividualGrades().get(1);
        int count = 0;
        if (assignment.getAssignment1() == 100) {
            count++;
        }
        if (assignment.getAssignment2() == 95) {
            count++;
        }
        if (assignment.getAssignment3() == 75) {
            count++;
        }
        return count;
    }

    //Stub TODO: add logic
    public int getNumProjects() {
        return 0;
    }

    //Stub TODO: add logic
    public HashSet<Student> getStudents() {
        HashSet<Student> students = new HashSet<>();
        ArrayList<StudentInfo> studentInfo = importer.importStudentInfo();
        for (StudentInfo student : studentInfo) {
            if (!student.getName().equals("NAME")) {
                Student s = new Student(student.getName(), String.valueOf(student.getId()), student.getEmail(), student.getcSkill(), student.getCppSkill(), student.getJavaSkill(), student.getCsJobEx(), importer);
                students.add(s);
            }
        }

        return students;
    }

    //Stub TODO: add logic
    public Student getStudentByName(String name) {
        ArrayList<StudentInfo> studentInfo = importer.importStudentInfo();
        Student student = null;
        for (StudentInfo s : studentInfo) {
            if (s.getName().equalsIgnoreCase(name)) {
                student = new Student(s.getName(), String.valueOf(s.getId()), s.getEmail(), s.getcSkill(), s.getCppSkill(), s.getJavaSkill(), s.getCsJobEx(), importer);
                break;
            }
        }
        return student;
    }

    //Stub TODO: add logic
    public Student getStudentByID(String id) {
        ArrayList<StudentInfo> studentInfo = importer.importStudentInfo();
        Student student = null;
        for (StudentInfo s : studentInfo) {
            if (String.valueOf(s.getId()).equals(id)) {
                student = new Student(s.getName(), String.valueOf(s.getId()), s.getEmail(), s.getcSkill(), s.getCppSkill(), s.getJavaSkill(), s.getCsJobEx(), importer);
                break;
            }
        }
        return student;
    }

}
