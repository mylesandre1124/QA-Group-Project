import objects.IndividualAssignment;
import objects.IndividualContributions;
import objects.StudentInfo;

import java.util.ArrayList;
import java.util.HashSet;

public class GradesDB {

    private GradeImporter importer;

    public GradesDB(String fileName) {
        importer = new GradeImporter(fileName);
    }

    public void close() {
        importer.close();
    }


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
        ArrayList assignments = importer.importAssignments();
        int count = 0;
        for (Object assignment : assignments) {
            if (assignment instanceof String && ((String) assignment).toLowerCase().contains("assignment")) {
                count++;
            }
        }
        return count;
    }

    public int getNumProjects() {
        ArrayList projects = importer.importProjects();
        int count = 0;
        for (Object project : projects) {
            if (project instanceof String && ((String) project).toLowerCase().contains("project")) {
                count++;
            }
        }
        return count;
    }

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
