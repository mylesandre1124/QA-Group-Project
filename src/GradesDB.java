import objects.StudentInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class GradesDB {

    private GradeImporter importer;
    private GradeExporter exporter;

    public GradesDB() {
    }

    public void loadSpreadsheet(String fileName) {
        importer = new GradeImporter(fileName);
        exporter = new GradeExporter(fileName);
    }

    public GradeImporter getImporter() {
        return importer;
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

    public void createNewAssignment() {
        ArrayList<Object> data = new ArrayList<Object>(Arrays.asList("ASSIGNMENT 4", 95, 96, 65, 17, 87, 65, 90, 35, 67, 95, 96, 65, 17, 87));
        exporter.setExcelSheet(3);
        exporter.appendData(data);
        exporter.close();
    }

    public void createNewContribution() {
        ArrayList<Object> data = new ArrayList<Object>(Arrays.asList("PROJECT 4", 95, 96, 65, 17, 87, 65, 90, 35, 67));
        exporter.setExcelSheet(4);
        exporter.appendData(data);
        exporter.close();
    }



}
