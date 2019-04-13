import objects.IndividualAssignment;
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

    public ArrayList<IndividualAssignment> importIndividualGrades() {
        ArrayList<IndividualAssignment> assignments = new ArrayList<>();
        try {
            excelIO.setExcelSheet(3);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            ArrayList<String> fields = new ArrayList<>(Arrays.asList("name", "assignment1", "assignment2", "assignment3"));
            for (ArrayList row: lists) {
                assignments.add((IndividualAssignment)excelIO.convertRowToObject(new IndividualAssignment(), fields, row));
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return assignments;
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
