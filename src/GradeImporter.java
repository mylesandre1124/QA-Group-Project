import objects.IndividualAssignment;
import objects.IndividualContributions;
import objects.StudentAttendance;
import objects.StudentInfo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeImporter {

    private ExcelIO excelIO;

    public GradeImporter(String fileName) {
        this.excelIO = new ExcelIO(fileName);
    }

    public void close() {
        try {
            excelIO.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList importAssignments() {
        ArrayList assignments = new ArrayList<>();
        try {
            excelIO.setExcelSheet(3);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            assignments = lists.get(0);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return assignments;
    }

    public ArrayList importProjects() {
        ArrayList projects = new ArrayList<>();
        try {
            excelIO.setExcelSheet(4);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            projects = lists.get(0);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public ArrayList<StudentInfo> importStudentInfo() {
        ArrayList<StudentInfo> students = new ArrayList<>();
        try {
            excelIO.setExcelSheet(0);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            ArrayList<String> fields = new ArrayList<>(Arrays.asList("name", "id", "email", "cSkill", "cppSkill", "javaSkill", "csJobEx"));
            for (ArrayList row: lists) {
                students.add((StudentInfo)excelIO.convertRowToObject(new StudentInfo(), fields, row));
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return students;
    }

    public ArrayList<IndividualAssignment> importAssignmentInfo() {
        ArrayList<IndividualAssignment> assignments = new ArrayList<>();
        try {
            excelIO.setExcelSheet(3);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            ArrayList<String> fields = new ArrayList<>(Arrays.asList("name", "assignment1", "assignment2", "assignment3"));
            for (ArrayList row: lists) {
                assignments.add((IndividualAssignment) excelIO.convertRowToObject(new IndividualAssignment(), fields, row));
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return assignments;
    }

    public ArrayList<IndividualContributions> importProjectInfo() {
        ArrayList<IndividualContributions> projects = new ArrayList<>();
        try {
            excelIO.setExcelSheet(4);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            ArrayList<String> fields = new ArrayList<>(Arrays.asList("name", "project1", "project2", "project3"));
            for (ArrayList row: lists) {
                projects.add((IndividualContributions) excelIO.convertRowToObject(new IndividualContributions(), fields, row));
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public ArrayList<StudentAttendance> importStudentAttendance() {
        ArrayList<StudentAttendance> students = new ArrayList<>();
        try {
            excelIO.setExcelSheet(2);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            ArrayList<String> fields = new ArrayList<>(Arrays.asList("name", "attendance"));
            for (ArrayList row: lists) {
                students.add((StudentAttendance)excelIO.convertRowToObject(new StudentAttendance(), fields, row));
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return students;
    }
}
